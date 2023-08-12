<template>
  <div class="damageReported">
    
    <div class="itemsText">
      <p class="itemsTextP">物品损坏上报</p>
    </div>
    
    <!-- 上报页面 -->
    <div class="damageReportedInner">

      <template>
        <div class="damageReportedInnerHeader">

          <el-button @click="clearFilter">重置状态筛选</el-button>

          <!-- 上报人搜索 -->
          <el-input
            v-model.trim="searchByReportName"
            size="mini"
            placeholder="上报人搜索(回车)"
            @keyup.enter.native="searchByReportNameFuncButton"/>

          <!-- 处理人搜索 -->
          <el-input
          v-model.trim="searchByDisposeName"
          size="mini"
          placeholder="处理人搜索(回车)"
          @keyup.enter.native="searchByDisposeNameFuncButton"/>

          <!-- 查看全部按钮 -->
          <el-button class="seeAll" type="primary" round @click="seeAll">查看全部</el-button>
        </div>
        
        <!-- 表格 -->
        <el-table
          class="itemsTable" 
          ref="filterTable"
          :data="tableData"
          style="width: 100%">
          <!-- 上报信息id -->
          <el-table-column
            width="100px"
            align='center'
            prop="sequenceId"
            label="上报信息id">
          </el-table-column>
          <!-- 上报时间 -->
          <el-table-column
            width="160px"
            align='center'
            prop="reportTime"
            label="上报时间"
            sortable
            column-key="reportTime">
          </el-table-column>
          <!-- 上报人 -->
          <el-table-column
            width="100px"
            align='center'
            prop="reportName"
            label="上报人">
          </el-table-column>
          <!-- 物品id -->
          <el-table-column
            width="100px"
            align='center'
            prop="goodsId"
            label="物品id">
          </el-table-column>
          <!-- 物品名称 -->
          <el-table-column
            width="100px"
            align='center'
            prop="goodsName"
            label="物品名称"
            :formatter="formatter">
          </el-table-column>
          <!-- 损坏描述 -->
          <el-table-column

            align='center'
            prop="damageDescription"
            label="损坏描述">
          </el-table-column>
          <!-- 状态 -->
          <el-table-column
            width="100px"
            align='center'
            prop="goodsState"
            label="状态"
            :filters="[{ text: '未处理', value: '未处理' }, { text: '已处理', value: '已处理' }]"
            :filter-method="filterTag"
            filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag
                :type="scope.row.goodsState === '未处理' ? 'info' : 'success'"
                disable-transitions>{{scope.row.goodsState}}</el-tag>
            </template>
          </el-table-column>
          <!-- 处理时间 -->
          <el-table-column
            width="160px"
            align='center'
            prop="processTime"
            label="处理时间"
            sortable
            column-key="processTime">
          </el-table-column>
          <!-- 处理人 -->
          <el-table-column
            align='center'
            prop="disposeName"
            label="处理人">
          </el-table-column>
          <!-- 删除操作 -->
           <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>

    </div>


    <!-- 上报列表弹窗 -->
    <el-dialog title="上报" :visible.sync="dialogFormVisible" :append-to-body="true" class="itemsDialog">
      
      <el-form :model="items" :rules="rules" ref="items" class="demo-ruleForm">
        <el-form-item label="上报人id" prop="reportNameId">
          <el-input v-model="items.reportNameId" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="上报人姓名" prop="reportName">
          <el-input v-model.number="items.reportName" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="物品id" prop="goodsId">
          <el-input v-model.number="items.goodsId"></el-input>
        </el-form-item>
        <el-form-item label="损坏描述" prop="damageDescription">
          <el-input type="textarea" v-model="items.damageDescription"></el-input>
        </el-form-item>
        <el-button type="primary" @click="submitForm('rules')">上 报</el-button>
      </el-form>

      
        
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">关 闭</el-button>
      </div>
    </el-dialog>
    <!-- 分页 -->
    <div class="pagination">
      <Pagination :total="total" :totalPages="totalPages" @currentChange="currentChange"></Pagination>
    </div>

  </div>
</template>

<script>
// 防抖引入
import { debounce } from 'lodash-es';
// 分页
import Pagination from '@/components/pagination/Pagination';

import { reportList,searchByReportNameFunc,searchByDisposeNameFunc,deleteGoods } from "@/api/damage/damageAdmin.js"
// 时间戳处理
import dayjs from 'dayjs';
export default {
  name: 'Content-DamageReported',
  components:{Pagination,},

  data() {
    return {
      // 列表
      // sequenceId: 1,
      // reportTime: '2023-07-02 03:29:33',
      // reportName: '门酱',
      // goodsId: 1,
      // goodsName: '物品名字',
      // damageDescription: '描述',
      // goodsState: '未处理',
      // processTime: '2023-08-01 06:30:55',
      // disposeName: '无'
      tableData: [],
      // 上报损坏物品信息
      items: {
        reportNameId:'',        // 1上报人id
        reportName:'',          // 1上报人账号：用户自己
        goodsId: '',            // 1上报物品id
        damageDescription: '',  // 1上报损坏描述
      },
      ok: {
        reportNameId: 120,         // 1上报人id
        reportName:'李浩坤',        // 1上报人账号：用户自己
        goodsId: 35447,            // 1上报物品id
        damageDescription: '描述', // 1上报损坏描述
      },
      // 搜索
      searchByReportName: '',
      searchByDisposeName: '',
      // 关于页码
      // 总共条数
      total: 0,
      // 页码数量
      totalPages: 10,
      // 当前页码有几个
      pageSize: 10,
      // 当前页码
      pageNum: 1,
      // 控制弹窗
      dialogFormVisible: false,
      // 添加物品规则
      rules: {
        goodsId: [
          { required: true, message: '请输入物品id', trigger: 'blur' },
        ],
        goodsName: [
          { required: true, message: '请输入物品名称', trigger: 'blur' },
        ],
        damageDescription: [
          { required: true, message: '请输入损坏描述', trigger: 'blur' }
        ],
      },
    };
  },
  methods: {
    // 获取上报列表数据接口
    async getReportList(pageNum,pageSize){
      let res = await reportList({pageNum: pageNum,pageSize: pageSize})
      console.log("上报列表数据-----",res)
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.total = res.data.data.total
        this.totalPages = res.data.data.pages
        this.tableData.forEach( e => {
          e.reportTime = dayjs(e.reportTime).format("YYYY-MM-DD HH:mm:ss");
        })
        this.tableData.forEach( e => {
          e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
        })
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
    },

    // 上报人搜索接口
    async getSearchByReportNameFunc(pageNum,pageSize,reportName){
      let res = await searchByReportNameFunc({pageNum: pageNum,pageSize: pageSize,reportName: reportName})
      console.log("上报人搜索数据-----",res);
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.total = res.data.data.total
        this.totalPages = res.data.data.pages
        this.tableData.forEach( e => {
          e.reportTime = dayjs(e.reportTime).format("YYYY-MM-DD HH:mm:ss");
        })
        this.tableData.forEach( e => {
          e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
        })
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
    },

    // 处理人搜索接口
    async getSearchByDisposeNameFunc(pageNum,pageSize,disposeName){
      let res = await searchByDisposeNameFunc({pageNum: pageNum,pageSize: pageSize,disposeName: disposeName})
      console.log("处理人搜索数据-----",res);
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.total = res.data.data.total
        this.totalPages = res.data.data.pages
        this.tableData.forEach( e => {
          e.reportTime = dayjs(e.reportTime).format("YYYY-MM-DD HH:mm:ss");
        })
        this.tableData.forEach( e => {
          e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
        })
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
    },

    // 删除数据接口
    async getDeleteGoods(sequenceId){
      let res = await deleteGoods({sequenceId: sequenceId})
      console.log("删除数据-----",res);
      if(res.status === 200){
        this.$message({
          type: 'success',
          message: '删除成功咯!',
        })
        // 重新获取列表
        this.getReportList(1,this.pageSize)
      }
    },

    // 上报人搜索操作
    searchByReportNameFuncButton:debounce(function() {
      if(this.searchByReportName){
        this.getSearchByReportNameFunc(this.pageNum,this.pageSize,this.searchByReportName)
      }
    }, 300),

    // 处理人搜索操作
    searchByDisposeNameFuncButton:debounce(function() {
      if(this.searchByDisposeName){
        this.getSearchByDisposeNameFunc(this.pageNum,this.pageSize,this.searchByDisposeName)
      }
    }, 300),

    // 查看全部
    seeAll(){
      this.getReportList(1,this.pageSize)
      this.searchByReportName = ''
      this.searchByDisposeName = ''
    },

    // 删除操作
    handleDelete(index, row) {
      this.$confirm('此操作将删除该上报数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.getDeleteGoods(row.sequenceId)
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });          
      });
    },

    // 更新页码
    currentChange(val){
      console.log("更新页码-----",val);
      this.pageNum = val
      this.getReportList(val,this.pageSize)
    },

    // 上报列表函数
    formatter(row, column) {
      return row.goodsName;
    },
    filterTag(value, row) {
      return row.goodsState === value;
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
      this.getReportList(1,this.pageSize)
    },
  },
  created() {
    // 获取上报列表数据操作
    this.getReportList(this.pageNum,this.pageSize)
  },
  mounted() {
    this.items.reportName = this.$store.state.login.name
    this.items.reportNameId = Number(this.$store.state.login.id)
  },
};
</script>

<style scoped>
  .damageReported{
    width: 100%;
    height: 100%;
    position: relative;
    
  }
  .itemsText{
    font-size: 38px;
    margin-bottom: 20px;
    padding-top: 2px;
    padding-bottom: 3px;
    background-color: #e0dbdb;
    font-weight: bold;
    color: gray;
    text-align: center;
    position: fixed;
    width: 100%;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 30px 60px -12px, rgba(0, 0, 0, 0.3) 0px 18px 36px -18px;
    z-index: 1;
  }
  .reportedListButton{
    position: fixed;
    top: 60px;
    right: 1%;
  }
  .damageReportedInner{
    width: 90%;
    font-size: 25px;
    margin: 80px auto;
  }
  .damageReportedInnerHeader{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 100px;
    margin-bottom: 10px;
  }
  .damageReportedInnerHeader >>> .el-input{
    width: 150px;
    height: 40px;
  }
  .damageReportedInnerHeader >>> .el-input__inner{
    height: 100%;
    font-size: 10px;
  }
  .itemsTable{
    background-color: transparent;
    border-radius: 15px;
  }
  ::v-deep .el-table th,
  ::v-deep .el-table tr,
  ::v-deep .el-table td {
    background-color: rgba(255, 255, 255, 0.281) !important;
  }
  /* 去除底部白线 */
  .el-table::before{
    background-color: transparent;
  }
  
  .dialog-footer{
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
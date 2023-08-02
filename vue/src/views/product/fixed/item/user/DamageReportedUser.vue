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
            @keyup.enter.native="searchByReportNameFunc"/>

        </div>
        
        <!-- 表格 -->
        <el-table
          class="itemsTable" 
          ref="filterTable"
          :data="tableData"
          style="width: 100%">
          <!-- 上报信息id -->
          <el-table-column
            align='center'
            prop="sequenceId"
            label="上报信息id">
          </el-table-column>
          <!-- 上报时间 -->
          <el-table-column
            align='center'
            prop="reportTime"
            label="上报时间"
            sortable
            width="160"
            column-key="reportTime">
          </el-table-column>
          <!-- 上报人 -->
          <el-table-column
            align='center'
            prop="reportName"
            label="上报人">
          </el-table-column>
          <!-- 物品id -->
          <el-table-column
            align='center'
            prop="goodsId"
            label="物品id">
          </el-table-column>
          <!-- 物品名称 -->
          <el-table-column
            align='center'
            prop="goodsName"
            label="物品名称"
            :formatter="formatter">
          </el-table-column>
          <!-- 状态 -->
          <el-table-column
            align='center'
            prop="goodsState"
            label="状态"
            :filters="[{ text: '未处理', value: '未处理' }, { text: '未同意', value: '未同意' }, { text: '已同理未处理', value: '已同理未处理' }, { text: '已处理', value: '已处理' }]"
            :filter-method="filterTag"
            filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag
                :type="tagColor(scope)"
                disable-transitions>{{scope.row.goodsState}}</el-tag>
            </template>
          </el-table-column>
          <!-- 处理时间 -->
          <el-table-column
            align='center'
            prop="processTime"
            label="处理时间"
            sortable
            width="160"
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

      <div slot="footer" class="damageReportedButton">
        <el-button type="success" round class="reportedListButton" @click="reportedListButton">上报损坏物品</el-button>
      </div>

    </div>


    <!-- 上报列表弹窗 -->
    <el-dialog title="上报" :visible.sync="dialogFormVisible" :append-to-body="true" class="itemsDialog">
      
      <el-form :model="items" :rules="rules" ref="items" class="demo-ruleForm">
        <el-form-item label="物品id(请输入数字)" prop="goodsId">
          <el-input v-model.number="items.goodsId"></el-input>
        </el-form-item>
        <!-- <el-form-item label="物品名称" prop="goodsName">
          <el-input v-model="items.goodsName"></el-input>
        </el-form-item> -->
        <el-form-item label="损坏描述" prop="damageDescription">
          <el-input type="textarea" v-model="items.damageDescription"></el-input>
        </el-form-item>
        <el-button type="primary" @click="submitForm()">上 报</el-button>
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
import { reportList,searchByReportNameFunc,damageReported,deleteGoods } from "@/api/damage/damageUser.js"
export default {
  name: 'Content-DamageReported',
  components:{Pagination,},

  data() {
    return {
      // 列表
      tableData: [{
        sequenceId: 1,
        reportTime: '2023-07-02 03:29:33',
        reportName: '门酱',
        goodsId: 1,
        goodsName: '物品名字',
        goodsState: '未处理',
        processTime: '2023-08-01 06:30:55',
        disposeName: '无'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-01 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '已同理未处理',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-03 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '已处理',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        sequenceId: 1,
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }],
      // 上报损坏物品信息
      items: {
        reportName:'',          // 1上报人：用户自己
        goodsId: '',            // 1上报物品id
        damageDescription: '',  // 1上报损坏描述
        reportTime: '',         // 上报时间
        disposeName: '',        // 1处理人
        goodsState: '',         // 处理状态
      },
      // 搜索
      searchByReportName: '',
      // 关于页码
      // 总共条数
      total: 100,
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
          { type: 'number', message: '物品id必须为数值'}
        ],
        // goodsName: [
        //   { required: true, message: '请输入物品名称', trigger: 'blur' },
        // ],
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
      console.log("上报列表数据-----",res.data)
      // 列表赋值
      this.tableData = [...res.data]
      this.total = res.data.total
      this.totalPages = res.data.totalPages
    },

    // 上报提交接口
    async postDamageReported(items){
      let res = await damageReported({items: items})
      console.log("上报提交-----",res.data);
    },

    // 上报人搜索接口
    async getSearchByReportNameFunc(pageNum,pageSize,reportName){
      let res = await searchByReportNameFunc({pageNum: pageNum,pageSize: pageSize,reportName: reportName})
      console.log("上报人搜索数据-----",res.data);
      // 列表赋值
      this.tableData = [...res.data]
    },

    // 删除数据接口
    async getDeleteGoods(sequenceId){
      let res = await deleteGoods({sequenceId: sequenceId})
      console.log("删除数据-----",res.data);
      if(res.data.code === 200){
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
        // 重新获取列表
        this.getReportList(this.pageNum,this.pageSize)
      }
    },

    // 上报人搜索操作
    searchByReportNameFunc:debounce(function() {
      this.getSearchByReportNameFunc(this.pageNum,this.pageSize,this.reportName)
    }, 300),

    // 上报提交操作
    submitForm(items){
      this.$refs.items.validate((valid) => {
        if (valid) {
          console.log("上报提交按钮-----",this.items);
          this.postDamageReported(this.items)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    // 上报列表弹窗展开
    reportedListButton(){
      this.dialogFormVisible = true
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
    },

    // 状态颜色判断
    tagColor(scope){
      if(scope.row.goodsState === "未处理"){
        return "info"
      } else if(scope.row.goodsState === "未同意"){
        return "danger"
      } else if(scope.row.goodsState === "已同理未处理"){
        return "warning"
      } else if(scope.row.goodsState === "已处理"){
        return "success"
      } 
    },
  },
  created() {
    // 获取上报列表数据操作
    this.getReportList(this.pageNum,this.pageSize)
  },
};
</script>

<style scoped>
  .damageReported{
    width: 100%;
    height: 100%;
    position: relative;
    background-color: rgba(255, 255, 255, 0.6);
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
    width: 80%;
    height: 100%;
    font-size: 25px;
    margin: 80px auto;
  }
  .damageReportedInnerHeader{
    display: flex;
    justify-content: space-between;
    align-items: center;
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
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

          <!-- id搜索 -->
          <el-input
            v-model.number="searchById"
            prop="goodsId"
            size="mini"
            placeholder="id搜索(回车)"
            @keyup.enter.native="searchByIdFunc"/>

          <!-- 上报人搜索 -->
          <el-input
            v-model.trim="searchByReportName"
            size="mini"
            placeholder="上报人搜索(回车)"
            @keyup.enter.native="searchByReportNameFunc"/>

          <!-- 处理人搜索 -->
          <el-input
          v-model.trim="searchByDisposeName"
          size="mini"
          placeholder="处理人搜索(回车)"
          @keyup.enter.native="searchByDisposeNameFunc"/>

        </div>
        
        <!-- 表格 -->
        <el-table
          class="itemsTable" 
          ref="filterTable"
          :data="tableData"
          style="width: 100%">
          <!-- 上报时间 -->
          <el-table-column
            prop="reportTime"
            label="上报时间"
            sortable
            width="160"
            column-key="reportTime"
          >
          </el-table-column>
          <!-- 上报人 -->
          <el-table-column
            prop="reportName"
            label="上报人">
          </el-table-column>
          <!-- 物品id -->
          <el-table-column
            prop="goodsId"
            label="物品id">
          </el-table-column>
          <!-- 物品名称 -->
          <el-table-column
            prop="goodsName"
            label="物品名称"
            :formatter="formatter">
          </el-table-column>
          <!-- 状态 -->
          <el-table-column
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
            prop="processTime"
            label="处理时间"
            sortable
            width="160"
            column-key="processTime">
          </el-table-column>
          <!-- 处理人 -->
          <el-table-column
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

  </div>
</template>

<script>
import dayjs from "dayjs"
// 防抖引入
import { debounce } from 'lodash-es';
import { reportList,searchByIdFunc,searchByReportNameFunc,searchByDisposeNameFunc,damageReported,deleteGoods } from "@/api/damage/damage.js"
export default {
  name: 'Content-DamageReported',

  data() {
    return {
      // 列表
      tableData: [{
        reportTime: '2023-07-02 03:29:33',
        reportName: '门酱',
        goodsId: 1,
        goodsName: '物品名字',
        goodsState: '未处理',
        processTime: '2023-08-01 06:30:55',
        disposeName: '无'
      }, {
        reportTime: '2023-07-04 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '未同意',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        reportTime: '2023-07-01 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '已同理未处理',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }, {
        reportTime: '2023-07-03 03:29:33',
        reportName: '门酱',
        goodsName: '物品名字',
        goodsId: 1,
        goodsState: '已处理',
        processTime: '2023-08-01 06:30:55',
        disposeName: '袁笙'
      }],
      // 损坏物品信息
      items: {
        reportName:'',          // 1上报人：用户自己
        goodsId: '',            // 1上报物品id
        damageDescription: '',  // 1上报损坏描述
        reportTime: '',         // 上报时间
        disposeName: '',        // 1处理人
        goodsState: '',         // 处理状态
      },
      // 搜索
      searchById: '',
      searchByReportName: '',
      searchByDisposeName: '',
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
    async getReportList(){
      let res = await reportList()
      console.log("上报列表数据-----",res.data)
      // 列表赋值
      this.tableData = [...res.data]
    },

    // 上报提交接口
    async postDamageReported(items){
      let res = await damageReported({items})
      console.log("上报提交-----",res.data);
    },

    // id搜索接口
    async getSearchByIdFunc(goodsId){
      let res = await searchByIdFunc(goodsId)
      console.log("id搜索数据-----",res.data);
      // 列表赋值
      this.tableData = [...res.data]
    },

    // 上报人搜索接口
    async getSearchByReportNameFunc(reportName){
      let res = await searchByReportNameFunc(reportName)
      console.log("上报人搜索数据-----",res.data);
      // 列表赋值
      this.tableData = [...res.data]
    },

    // 处理人搜索接口
    async getSearchByDisposeNameFunc(disposeName){
      let res = await searchByDisposeNameFunc(disposeName)
      console.log("处理人搜索数据-----",res.data);
      // 列表赋值
      this.tableData = [...res.data]
    },

    // 删除数据接口
    async getDeleteGoods(goodsId){
      let res = await deleteGoods(goodsId)
      console.log("删除数据-----",res.data);
      if(res.data.code === 200){
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
        // 重新获取列表
        this.getReportList()
      }
    },

    // id搜索操作
    searchByIdFunc:debounce(function() {
      this.getSearchByIdFunc(this.searchById)
    }, 300),
    // 上报人搜索操作
    searchByReportNameFunc:debounce(function() {
      this.getSearchByReportNameFunc(this.searchById)
    }, 300),
    // 处理人搜索操作
    searchByDisposeNameFunc:debounce(function() {
      this.getSearchByDisposeNameFunc(this.searchByDisposeName)
    }, 300),

    // 上报提交操作
    submitForm(items){
      this.$refs.items.validate((valid) => {
        if (valid) {
          console.log("上报提交按钮-----",this.$refs.items);
          this.reportTime = dayjs(Date.now()).format("YYYY-MM-DD HH:mm:ss");
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
        this.getDeleteGoods(row.goodsId)
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });          
      });
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
    this.getReportList()
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
<template>
  <div class="checkItems">

    <div class="itemsText">
      <p class="itemsTextP">物品展示</p>
    </div>

    <!-- 上报列表弹窗 -->
    <el-dialog title="上报" :visible.sync="dialogFormVisibleReported" :append-to-body="true" class="itemsDialog">
      
      <el-form :model="report" :rules="rules" ref="report" class="demo-ruleForm">
        <el-form-item label="上报人id" prop="reportNameId">
          <el-input v-model="report.reportNameId" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="上报人姓名" prop="reportName">
          <el-input v-model.number="report.reportName" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="物品id" prop="goodsId">
          <el-input v-model.number="report.goodsId" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="损坏描述" prop="damageDescription">
          <el-input type="textarea" v-model="report.damageDescription"></el-input>
        </el-form-item>
        <el-button type="primary" @click="submitFormReport('rules')">上 报</el-button>
      </el-form>


      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleReported = false">关 闭</el-button>
      </div>
    </el-dialog>

    <div class="checkItemsInner">

      <div class="checkItemsInnerHeader">
        <!-- 物品id搜索 -->
        <div class="inputDiv">
          <el-input
            v-model="searchByGoodsId"
            size="mini"
            placeholder="物品id搜索(回车)"
            @keyup.enter.native="searchByGoodsIdFunc"/>
        </div>
        <!-- 物品名搜索 -->
        <div class="inputDiv">
          <el-input
            v-model.trim="searchByGoodsName"
            size="mini"
            placeholder="物品名搜索(回车)"
            @keyup.enter.native="searchByGoodsNameFunc"/>
        </div>
        
        <!-- 查看全部按钮 -->
        <el-button class="seeAll" type="primary" round @click="seeAll">查看全部</el-button>
      </div>

      <!-- 展示页面 -->
      <el-table :data="tableData" border align="center" class="itemsTable" :header-cell-style="{'text-align':'center'}">
          <el-table-column width="100px" prop="goodsId" label="物品id" align='center'></el-table-column>
          <el-table-column prop="goodsImage" label="物品照片" align='center'>
              <template slot-scope="scope">
                  <img style="width:200px;max-height:200px;object-fit:contain;" :src="scope.row.goodsImage">
              </template>
          </el-table-column>
          <el-table-column width="100px" prop="goodsName" label="物品名称" align='center'></el-table-column>
          <!-- 状态 -->
          <el-table-column
            width="100px"
            align='center'
            prop="goodsState"
            label="物品状态"
            :filters="[{ text: '未损坏', value: '未损坏' }, { text: '已损坏', value: '已损坏' }]"
            :filter-method="filterTag"
            filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag
                :type="scope.row.goodsState === '未损坏' ? 'info' : 'danger'"
                disable-transitions>{{scope.row.goodsState}}</el-tag>
            </template>
          </el-table-column>
          <!-- 操作 -->
          <el-table-column label="操作" align='center'>
              <template slot-scope="scope">
                  <el-button type="primary" @click="damageReportFromItems(scope.$index,scope.row)" size="mini">损坏上报</el-button>
              </template>
          </el-table-column>
      </el-table>

    </div>

    <!-- 分页 -->
    <div class="pagination">
      <Pagination :total="total" :pageSize="pageSize" :totalPages="totalPages" @currentChange="currentChange"></Pagination>
    </div>

  </div>
</template>

<script>
// 防抖引入
import { debounce } from 'lodash-es';
import Pagination from '@/components/pagination/Pagination';
import { itemsList,searchByGoodsNameFunc,searchByGoodsIdFunc } from '@/api/goods/goodsUser.js'

import { damageReported } from "@/api/damage/damageUser.js"
export default {
  goodsName: 'Content-CheckItems',
  components:{Pagination,},
  data() {
    return {
      formLabelWidth: '120px',
      tableData: [],
      // 控制弹窗
      dialogFormVisibleAdd: false,
      // 弹窗标题
      dialogFormVisibleTitle: "",
      // 上报损坏物品信息
      report: {
        reportNameId:'',        // 1上报人id
        reportName:'',          // 1上报人账号：用户自己
        goodsId: '',            // 1上报物品id
        damageDescription: '',  // 1上报损坏描述
      },
      // 搜索
      searchByGoodsName: '',
      searchByGoodsId: '',
      // 控制弹窗
      dialogFormVisibleReported: false,
      // 暂存图片
      fileList:[],
      // 添加物品规则
      rules: {
        goodsName: [
          { required: true, message: '请输入物品名称', trigger: 'blur' },
        ],
        goodsQuantity: [
          { required: true, message: '请输入物品数量', trigger: 'blur' },
        ],
        goodsState: [
          { required: true, message: '请选择物品状态', trigger: 'change' }
        ],
        goodsImage: [
          { required: true, message: '请上传图片', trigger: 'change' }
        ],
      },
      // 关于页码
      // 总共条数
      total: 0,
      // 页码数量
      totalPages: 10,
      // 当前页码有几个
      pageSize: 5,
      // 当前页码
      pageNum: 1,
    };
  },
  methods: {
    // 获取物品列表数据接口
    async getItemsList(pageNum,pageSize){
    let res = await itemsList({pageNum: pageNum,pageSize: pageSize})
      console.log("产品列表数据-----",res)
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.total = res.data.data.total
        this.totalPages = res.data.totalPages
        this.tableData.forEach( (e,index) => {
          e.goodsImage = 'data:image/png;base64,' + res.data.responseEntityList[index].body
        })
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
    },

    // 上报提交接口
    async postDamageReported(report){
      let res = await damageReported({items: report})
      console.log("上报提交-----",res);
      if(res.status === 201){
        this.$message({
          type: 'success',
          message: '上报成功咯!',
        })
        this.dialogFormVisibleReported = false
        this.report.goodsId = ""
        this.report.damageDescription = ""
        // 重新获取列表
        this.getItemsList(1,this.pageSize)
      }
    },

    // 物品名字搜索接口
    async getSearchByGoodsNameFunc(pageNum,pageSize,goodsName){
      let res = await searchByGoodsNameFunc({pageNum: pageNum, pageSize: pageSize, goodsName: goodsName})
      console.log("上报人搜索数据-----",res);
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.tableData.forEach( (e,index) => {
          e.goodsImage = 'data:image/png;base64,' + res.data.responseEntityList[index].body
        })
        this.total = res.data.data.total
        this.totalPages = res.data.totalPages
        this.pageNum = 1
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
      
    },

    // 物品id搜索接口
    async getSearchByGoodsIdFunc(goodsId){
      let res = await searchByGoodsIdFunc({goodsId: goodsId})
      console.log("物品id搜索数据-----",res);
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.tableData.forEach( (e,index) => {
          e.goodsImage = 'data:image/png;base64,' + res.data.responseEntityList[index].body
        })
        this.total = 1
        this.totalPages = 1
        this.pageNum = 1
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
    },

    // 更新页码
    currentChange(val){
      console.log("更新页码-----",val);
      this.pageNum = val
      this.getItemsList(val,this.pageSize)
    },

    // 上报弹窗展开
    damageReportFromItems(index,row){
      console.log("上报弹窗展开",index,row);
      this.dialogFormVisibleReported = true
      this.report.goodsId = row.goodsId
    },
    // 上报提交操作
    submitFormReport(){
      this.$refs.report.validate((valid) => {
        if (valid) {
          console.log("上报提交按钮-----",this.report);
          this.postDamageReported(this.report)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    // 物品名字搜索操作
    searchByGoodsNameFunc:debounce(function() {
      if(this.searchByGoodsName){
        console.log("我要搜索咯-----",this.searchByGoodsName);
        this.getSearchByGoodsNameFunc(this.pageNum,this.pageSize,this.searchByGoodsName)
      } 
    }, 300),

    // 物品id搜索操作
    searchByGoodsIdFunc:debounce(function() {
      if(this.searchByGoodsId){
        console.log("我要搜索咯-----",this.searchByGoodsId);
        this.getSearchByGoodsIdFunc(this.searchByGoodsId)
      }
    }, 300),

    // 查看全部
    seeAll(){
      this.getItemsList(1,this.pageSize)
      this.searchByGoodsName = ''
      this.searchByGoodsId = ''
    },
    

    // 过滤标签 
    filterTag(value, row) {
      return row.goodsState === value;
    },
 
  },
  created() {
    this.getItemsList(1,this.pageSize)
  },
  mounted() {
    this.report.reportName = this.$store.state.login.name
    this.report.reportNameId = Number(this.$store.state.login.id)
  },
};
</script>

<style scoped>
  .checkItems{
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
  .itemsButton{
    margin-top: 60px;
    font-size: 18px;
    position: fixed;
    border-radius: 20px;
    left: 20px;
    top: 5px;
    background-color: aliceblue;
    z-index: 1;
  }
  .checkItemsInner{
    width: 80%;
    /* height: 100%; */
    font-size: 25px;
    margin: 40px auto;
    margin-bottom: 80px;
  }
  .checkItemsInnerHeader{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
  }
  .inputDiv{
    margin-top: 60px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .inputDiv >>> .el-input{
    width: 150px;
    height: 40px;
  }
  .inputDiv >>> .el-input__inner{
    height: 100%;
    font-size: 10px;
  }
  .seeAll{
    margin-top: 60px;
  }
  .itemsImg{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .itemsImg >>> .el-upload-list{
    width: 60%;
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
  .dialog-footer{
    display: flex;
    justify-content: center;
    align-items: center;
  }
  /* 去除底部白线 */
  .el-table::before{
    background-color: transparent;
  }
</style>
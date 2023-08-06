<template>
  <div class="messageReported">
    
    <div class="itemsText">
      <p class="itemsTextP">管理员审批</p>
    </div>

    <div class="messageHeader">
      <!-- 损坏上报 -->
      <el-badge :value="reportedMessage" :max="99" class="messageHeaderReported">
        <el-button type="success">损坏上报</el-button>
      </el-badge>
      <!-- 资金审批 -->
      <el-badge :value="assetsMessage" :max="99" class="messageHeaderAssets">
        <el-button type="info" @click="gotoMessageAssets">资金审批</el-button>
      </el-badge>
    </div>

    <div class="messageReportedInner">
      <!-- 表格 -->
      <el-table
        class="reportedTable" 
        ref="filterTable"
        :data="tableData"
        style="width: 100%">
        <!-- 上报信息id -->
        <el-table-column
          align='center'
          prop="sequenceId"
          label="上报信息id">
        </el-table-column>
        <!-- 上报人id -->
        <el-table-column
          align='center'
          prop="reportNameId"
          label="上报人id">
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
          :filters="[{ text: '未处理', value: '未处理' }]"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag
              type="info"
              disable-transitions>{{scope.row.goodsState}}</el-tag>
          </template>
        </el-table-column>
        <!-- 损坏描述信息 -->
        <el-table-column
          align='center'
          prop="damageDescription"
          label="损坏描述">
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
        <!-- 处理操作 -->
        <el-table-column label="处理">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="warning"
            @click="disposeButton(scope.$index, scope.row)">处理</el-button>
        </template>
      </el-table-column>
      </el-table>

      <!-- 弹窗 -->
      <el-dialog title="损坏物品处理" :visible.sync="dialogFormVisibleEdit" :append-to-body="true" class="itemsDialog">

      <el-form :model="dispose" :rules="rules" ref="dispose" class="demo-ruleForm">

        <el-form-item label="上报人" prop="reportName">
          <el-input v-model="dispose.reportName" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="物品id" prop="goodsId">
          <el-input v-model="dispose.goodsId" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="物品名字" prop="goodsName">
          <el-input v-model="dispose.goodsName" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="上报人描述" prop="damageDescription">
          <el-input type="textarea" v-model="dispose.damageDescription" :disabled="true"></el-input>
        </el-form-item>


        <el-form-item label="是否删除已损坏物品" prop="goodsState">
          <el-radio-group v-model="dispose.goodsState">
            <el-radio label="是"></el-radio>
            <el-radio label="否"></el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="是否申请资金购买新物品" prop="gotoApply">
          <el-radio-group v-model="dispose.gotoApply">
            <el-radio label="是"></el-radio>
            <el-radio label="否"></el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="处理人描述" prop="disposeDescription">
          <el-input type="textarea" v-model="dispose.disposeDescription"></el-input>
        </el-form-item>

        <el-button type="primary" @click="submitForm()">提 交</el-button>

      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleEdit = false">关 闭</el-button>
      </div>
    </el-dialog>

    </div>

     <!-- 分页 -->
    <div class="pagination">
      <Pagination :total="total" :totalPages="totalPages" @currentChange="currentChange"></Pagination>
    </div>

  </div>
</template>

<script>
import { unprocessedReport,updateProcessedReport } from "@/api/message/messageReported"
import { deleteGoods } from "@/api/damage/damageAdmin.js"
// 节流
import { throttle } from 'lodash-es';
// 分页
import Pagination from '@/components/pagination/Pagination';
import getMessageQuantity from "@/utils/getMessageQuantity";
import getUnprocessedReportNum from "@/utils/getReportedMessage"
import getUnprocessedAssetsNum from "@/utils/getAssetsMessage"
// 时间戳处理
import dayjs from 'dayjs';
export default {
  name: 'Message-MessageReported',
  components:{Pagination,},

  data() {
    return {
      // 列表
      tableData: [],
      // 处理信息
      dispose: {
        // 不可修改的框框
        reportName: '',            // 上报人
        goodsId: '',               // 物品id
        goodsName: '',             // 物品名称
        damageDescription: '',     // 上报人描述
        gotoApply: '',             // 是否跳转

        // post的数据
        sequenceId: '',            // 1上报信息id
        disposeNameId: '',         // 1处理人id
        disposeName: '',           // 1处理人姓名
        disposeDescription: '',    // 1处理描述
        disposeResult: '',         // 1处理状态判断
      },
      // 处理信息规则
      rules: {
        goodsState: [
          { required: true, message: '请选择处理状态', trigger: 'change' }
        ],
        gotoApply: [
          { required: true, message: '请选择是否跳转到申请资金', trigger: 'change' }
        ],
        disposeDescription: [
          { required: true, message: '请填入处理描述', trigger: 'blur' }
        ]
      },
      // 关于页码
      // 总共条数
      total: 100,
      // 页码数量
      totalPages: 10,
      // 当前页码有几个
      pageSize: 7,
      // 当前页码
      pageNum: 1,
      // 控制弹窗
      dialogFormVisibleEdit: false,
      // 用于判断下面
      role: '',
      // 损坏上报未处理信息数
      reportedMessage: '',
      // 资金申请未处理信息数
      assetsMessage: '',
    };
  },

  methods: {
    // [查询]未(待)处理物品损坏记录接口
    async getUnprocessedReport(pageNum){
      let res = await unprocessedReport({pageNum: pageNum})
      console.log("未处理损坏物品数据-----",res)
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.total = res.data.data.total
        this.totalPages = res.data.data.pages
        this.tableData.forEach( e => {
          e.applyTime = dayjs(e.applyTime).format("YYYY-MM-DD HH:mm:ss");
        })
      }
    },

    // [更新]管理员处理(未处理的)损坏记录信息接口
    async postUpdateProcessedReport(sequenceId,disposeNameId,disposeName,disposeDescription){
      let res = await updateProcessedReport({sequenceId: sequenceId,disposeNameId: disposeNameId,disposeName: disposeName,disposeDescription :disposeDescription})
      console.log("审批损坏结果-----",res)
      if(res.state === 200){
        this.$message({
          type: 'success',
          message: '删除成功咯!',
        })
        // 重新获取列表
        this.getUnprocessedReport(1)
      }
    },

    // 上报提交操作
    submitForm(){
      this.$refs.dispose.validate((valid) => {
        if (valid) {
          console.log("处理提交按钮-----",this.dispose);
          this.dispose.disposeNameId = Number(this.dispose.disposeNameId)
          this.postUpdateProcessedReport(this.dispose.sequenceId,this.dispose.disposeNameId,this.dispose.disposeName,this.dispose.disposeDescription)
          // 触发弹窗
          this.dialogFormVisibleEdit = false
          if( this.dispose.goodsState === "是" ){
            // 调用物品损坏上报的删除接口
            console.log("调用物品损坏上报删除接口-----");
            deleteGoods({sequenceId: this.dispose.sequenceId}).then((res) => {
              console.log("物品损坏上报删除此条目成功");
            })
          }
          if( this.dispose.gotoApplyRes === "是" ){
            if( this.role === "user" ){
              this.$router.push({ name:"user_shenqing" })
            }else if( this.role === "admin" ){
              this.$router.push({ name:"admin_shenqing" })
            }
          }
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    // table处理按钮
    disposeButton(index, row){
      console.log("处理操作-----",index, row); 
      // 触发弹窗
      this.dialogFormVisibleEdit = true
      // 将弹窗标题修改
      this.dialogFormVisibleTitle = "物品损坏处理"
      // 往表单填展示数据(不可修改的)
      this.dispose.reportName =  row.reportName               // 上报人
      this.dispose.goodsId = row.goodsId                      // 物品id
      this.dispose.goodsName = row.goodsName                  // 物品名称
      this.dispose.damageDescription = row.damageDescription  // 上报人描述

      // 往表单填数据(不显示出来但是要post的)
      this.dispose.sequenceId = row.sequenceId                    // 上报信息id
      this.dispose.disposeNameId = this.$store.state.login.id     // 处理人id
      this.dispose.disposeName = this.$store.state.login.name     // 处理人姓名
      // this.dispose.disposeDescription = row.disposeDescription // 处理描述不需要，因为v-model

    },
    // 更新页码
    currentChange(val){
      console.log("更新页码-----",val);
      this.pageNum = val
      this.getUnprocessedReport(val)
    },
    // 上报列表函数
    formatter(row, column) {
      return row.goodsName;
    },

    // 跳转资金审批
    gotoMessageAssets: throttle(function(){
        this.$router.push({ name:"admin_message_assets" }).catch(err => err)
      },1500),
    },

  created() {
    // 获取未处理损坏物品列表数据操作
    this.getUnprocessedReport(this.pageNum)
    getMessageQuantity(this)

    
  },
  mounted() {
    getUnprocessedReportNum().then( resReported => {
      console.log("resReported",resReported);
      this.reportedMessage = resReported.data.data
    } )
    
    getUnprocessedAssetsNum().then( resAssets => {
      console.log("resAssets",resAssets);
      this.assetsMessage = resAssets.data.data
    })

    this.role = this.$store.state.login.role
  },
};
</script>

<style scoped>
  .messageReported{
    width: 100%;
    height: 100%;
    background-color: rgba(255, 255, 255, 0.6);
    overflow-y: scroll;
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
  .messageHeader{
    margin-top: 85px;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
  }
  .el-badge{
    transform: scale(1.5);
  }
  .messageReportedInner{
    width: 80%;
    font-size: 25px;
    margin: 80px;
    margin-top: 20px;
  }
  .reportedTable{
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
  .pagination{
    background-color: rgba(255, 255, 255, 0.815) !important;
  }
</style>
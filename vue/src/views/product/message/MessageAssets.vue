<template>
  <div class="messageAssets">
    
    <div class="itemsText">
      <p class="itemsTextP">管理员审批</p>
    </div>

    <div class="messageHeader">
      <!-- 损坏上报 -->
      <el-badge :value="reportedMessage" :max="99" class="messageHeaderReported">
        <el-button type="info" @click="gotoMessageReported">损坏上报</el-button>
      </el-badge>
      <!-- 资金审批 -->
      <el-badge :value="assetsMessage" :max="99" class="messageHeaderAssets">
        <el-button type="success">资金审批</el-button>
      </el-badge>
    </div>

    <div class="messageAssetsInner">
      <!-- 表格 -->
      <el-table
        class="assetsTable" 
        ref="filterTable"
        :data="tableData"
        style="width: 100%">
        <!-- 申请id -->
        <el-table-column
          align='center'
          prop="applyId"
          label="申请id">
        </el-table-column>
        <!-- 申请人id -->
        <el-table-column
          align='center'
          prop="applyNameId"
          label="申请人id">
        </el-table-column>
        <!-- 申请人名称 -->
        <el-table-column
          align='center'
          prop="applyName"
          label="申请人名称">
        </el-table-column>
        <!-- 申请金额 -->
        <el-table-column
          align='center'
          prop="applyAssets"
          label="申请金额"
          :formatter="formatter">
        </el-table-column>
        <!-- 申请状态 -->
        <el-table-column
          align='center'
          prop="applyState"
          label="状态"
          :filters="[{ text: '未处理', value: '未处理' }]"
          :filter-method="filterTag"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag
              type="info"
              disable-transitions>{{scope.row.applyState}}</el-tag>
          </template>
        </el-table-column>
        <!-- 申请信息描述 -->
        <el-table-column
          align='center'
          prop="applyDescription"
          label="申请信息描述">
        </el-table-column> 
        <!-- 申请时间 -->
        <el-table-column
          align='center'
          prop="applyTime"
          label="申请时间"
          sortable
          width="160"
          column-key="applyTime">
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
      <el-dialog title="申请资金处理" :visible.sync="dialogFormVisibleEdit" :append-to-body="true" class="itemsDialog">
      
      <el-form :model="dispose" :rules="rules" ref="dispose" class="demo-ruleForm">
        
        <el-form-item label="申请id" prop="applyId">
          <el-input v-model="dispose.applyId" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="申请人" prop="applyName">
          <el-input v-model="dispose.applyName" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="申请描述" prop="applyDescription">
          <el-input type="textarea" v-model="dispose.applyDescription" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="申请资金" prop="applyAssets">
          <el-input v-model.number="dispose.applyAssets"></el-input>
        </el-form-item>

        <el-form-item label="是否同意申请资金添加新物品" prop="applyState">
          <el-radio-group v-model="dispose.applyState">
            <el-radio label="同意"></el-radio>
            <el-radio label="不同意"></el-radio>
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
import { unprocessedApply,updateProcessedApply } from "@/api/message/messageAssets"
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
  name: 'Message-MessageAssets',
  components:{Pagination,},

  data() {
    return {
      // 列表
      tableData: [],
      // 处理信息
      dispose: {
        // 不可修改的框框
        // applyId: '',             // 申请id，这个既不可修改也post
        applyName: '',              // 申请人
        applyDescription: '',       // 申请描述

        // post的数据
        applyId: '',                // 申请id，这个既不可修改也post
        disposeNameId: '',          // 处理人id
        disposeName: '',            // 处理人名称
        applyState: '',             // 处理状态
        disposeDescription:''       // 处理人描述
      },
      // 处理信息规则
      rules: {
        applyState: [
          { required: true, message: '请选择处理状态', trigger: 'change' }
        ],
        disposeDescription: [
          { required: true, message: '请填入处理描述', trigger: 'blur' }
        ]
      },
      // 关于页码
      // 总共条数
      total: 0,
      // 页码数量
      totalPages: 10,
      // 当前页码有几个
      pageSize: 7,
      // 当前页码
      pageNum: 1,
      // 控制弹窗
      dialogFormVisibleEdit: false,
      // 损坏上报未处理信息数
      reportedMessage: '',
      // 资金申请未处理信息数
      assetsMessage: '',
    };
  },

  methods: {
    // [查询]未(待)处理资金申请记录接口
    async getUnprocessedAssets(pageNum){
      let res = await unprocessedApply({pageNum: pageNum})
      console.log("未处理资金申请数据-----",res)
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
    async postUpdateProcessedAssets(applyId,disposeName,disposeNameId,applyState,disposeDescription){
      let res = updateProcessedApply({applyId: applyId,disposeName: disposeName,disposeNameId:disposeNameId,applyState :applyState,disposeDescription: disposeDescription})
      console.log("审批损坏结果-----",res)
      if(res.state === 200){
        this.$message({
          type: 'success',
          message: '删除成功咯!',
        })
        // 重新获取列表
        this.getUnprocessedAssets(1)
      }
    },

    // 上报提交操作
    submitForm(){
      this.$refs.dispose.validate((valid) => {
        if (valid) {
          this.dispose.disposeNameId = Number(this.dispose.disposeNameId)
          console.log("处理提交按钮-----",this.dispose);
          this.postUpdateProcessedAssets(this.dispose.applyId,this.dispose.disposeName,this.dispose.disposeNameId,this.dispose.applyState,this.dispose.disposeDescription)
          // 触发弹窗
          this.dialogFormVisibleEdit = false
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
      this.dispose.applyNameId =  row.applyNameId             // 申请id
      this.dispose.applyName = row.applyName                  // 申请人
      this.dispose.applyAssets = row.applyAssets              // 申请金额
      this.dispose.applyDescription = row.applyDescription    // 申请描述

      // 往表单填数据(不显示出来但是要post的)
      this.dispose.applyId = row.applyId                          // 申请信息id
      this.dispose.applyState = row.applyState                    // 申请状态
      this.dispose.disposeNameId = this.$store.state.login.id     // 处理人id
      this.dispose.disposeName = this.$store.state.login.name     // 处理人姓名
      // this.dispose.disposeDescription = row.disposeDescription // 处理描述不需要，因为v-model
    },

    // 更新页码
    currentChange(val){
      console.log("更新页码-----",val);
      this.pageNum = val
      this.getUnprocessedAssets(val,this.pageSize)
    },
    // 上报列表函数
    formatter(row, column) {
      return row.applyAssets;
    },
    filterTag(value, row) {
      return row.applyState === value;
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },

    // 跳转损坏审批
    gotoMessageReported: throttle(function(){
      this.$router.push({ name:"admin_message_reported" }).catch(err => err)
    },1500),
  },
  
  created() {
    // 获取未处理损坏物品列表数据操作
    this.getUnprocessedAssets(this.pageNum)
  },

  mounted() {
    getMessageQuantity(this)
    getUnprocessedReportNum().then( resReported => {
      console.log("resReported",resReported);
      this.reportedMessage = resReported.data.data
    } )
    
    getUnprocessedAssetsNum().then( resAssets => {
      console.log("resAssets",resAssets);
      this.assetsMessage = resAssets.data.data
    })
  },
};
</script>

<style scoped>
  .messageAssets{
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
  .messageAssetsInner{
    width: 80%;
    font-size: 25px;
    margin: 80px;
    margin-top: 20px;
  }
  .assetsTable{
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
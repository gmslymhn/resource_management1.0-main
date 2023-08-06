<template>
  <div class="apply">
    <div class="itemsText">
      <p class="itemsTextP">资金申请</p>
    </div>

    <div class="applyInner">
      <el-row id="wrappper_button">
        <el-button type="danger" round id="applyMoney">资金申请</el-button>
        <el-button
          :disabled="disabled"
          type="danger"
          round
          id="findAllApply"
          @click="findAllApply"
          >查询所有申请</el-button
        >
      </el-row>
      <!-- //单选按钮 -->
      <el-radio-group v-model="radio">
        <el-radio :label="1">id查询</el-radio>
        <el-radio :label="2">通过处理人查询</el-radio>
        <el-radio :label="3">通过申请人查询</el-radio>
        <el-input v-model="inputFind" placeholder="请输入内容"></el-input>
      </el-radio-group>
      <br />
      <br />
      <el-table :data="newTableData" style="width: 100%">
        <el-table-column fixed prop="applyId" label="申请id" width="100">
        </el-table-column>
        <el-table-column prop="applyAssets" label="申请金额" width="120">
        </el-table-column>
        <el-table-column prop="applyNameId" label="申请人id" width="120">
        </el-table-column>
        <el-table-column prop="applyName" label="申请人名称" width="120">
        </el-table-column>
        <el-table-column prop="disposeNameId" label="处理人id" width="120">
        </el-table-column>
        <el-table-column prop="disposeName" label="处理人姓名" width="120">
        </el-table-column>
        <el-table-column prop="applyDescription" label="申请描述" width="300">
        </el-table-column>
        <el-table-column prop="disposeDescription" label="处理描述" width="300">
        </el-table-column>
        <el-table-column prop="applyTime" label="申请时间" width="120">
        </el-table-column>
        <el-table-column prop="disposeTime" label="处理时间" width="120">
        </el-table-column>
        <el-table-column prop="applyState" label="处理状态" width="120">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="120">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >审批</el-button
            >
            <el-button type="text" size="small" style="">编辑</el-button>
            <el-button type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { set } from "vue";
export default {
  name: "Content-Apply",
  methods: {
    handleClick(row) {
      console.log(row);
    },
    //禁用按钮 防止多次发送请求
    findAllApply() {
      this.disabled = true;
      setInterval(() => {
        this.disabled = false;
      }, 10000);
      //查询所有资金申请信息
      axios({
        method: "post",
        url: "http://172.16.1.49:8080/user/userapply/getAllApply",
        params: {
          pageNum: 10,
          pageSize: 10,
        },
      }).then((Response) => {
        this.tableData = [...Response.data.data.list];
        this.newTableData = [...Response.data.data.list];
      });
    },
  },
  watch: {
    inputFind(newval) {
      switch (this.radio) {
        case 1:
          this.newTableData = this.tableData.filter((item) => {
            return item.applyId==newval;
          });
          break;
        case 2:
          this.newTableData = this.tableData.filter((item) => {
            console.log(typeof(disposeName))
            return item.disposeName==newval;
          });
          break;
        case 3:
          this.newTableData = this.tableData.filter((item) => {
            return item.applyName==newval;
          });
          break;
      }
    },
  },
  data() {
    return {
      disabled: false,
      newTableData: null,
      inputFind: "",
      radio: 1,
      tableData: [],
    };
  },

  created() {
    //根据上报信息id删除上报信息
    // axios({
    //   method:'POST',
    //   url:"http://172.16.1.49:8080/admin/admapply/addApply",
    //   data:{
    //     sequenceld:5
    //   }
    // }).then(Response=>{
    //   console.log(Response)
    // })
  },
};
</script>

<style scoped>
.apply {
  width: 100%;
  height: 100%;
  position: relative;
  background-color: rgba(255, 255, 255, 0.6);
}
#applyMoney {
  margin-bottom: 30px;
}
.itemsText {
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
  box-shadow: rgba(50, 50, 93, 0.25) 0px 30px 60px -12px,
    rgba(0, 0, 0, 0.3) 0px 18px 36px -18px;
  z-index: 1;
}
.applyInner {
  position: relative;
  width: 60%;
  height: 100%;
  font-size: 25px;
  margin: 60px auto;
}
#findAllApply {
  position: absolute;
  left: 85%;
}
</style>
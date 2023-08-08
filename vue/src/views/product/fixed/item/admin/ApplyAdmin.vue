<template>
  <div class="apply">
    <div class="itemsText">
      <p class="itemsTextP">资金申请与查询</p>
    </div>

    <div class="applyInner">
      <div id="part1" v-show="Options">
        <el-row id="wrappper_button" >
          <el-button type="danger" round id="applyMoney" @click="applyMoney"
            >资金申请</el-button
          >
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
        <el-radio-group v-model="radio" >
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
          <el-table-column
            prop="disposeDescription"
            label="处理描述"
            width="300"
          >
          </el-table-column>
          <el-table-column prop="applyTime" label="申请时间" width="120">
          </el-table-column>
          <el-table-column prop="disposeTime" label="处理时间" width="120">
          </el-table-column>
          <el-table-column prop="applyState" label="处理状态" width="120">
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="120">
            <template slot-scope="scope">
              <el-button
                @click="handleClick(scope.row)"
                type="text"
                size="small"
                >删除</el-button
              >
              <el-button type="text" size="small" @click="apply"
                >审批</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </div>

      <div
        id="part2"
        style="position: absolute; top: 100px; width: 60%"
        v-show="!Options"
      >
        <el-input
          type="text"
          placeholder="请输入申请的金额"
          v-model="text"
          maxlength="10"
          show-word-limit
        >
        </el-input>
        <div style="margin: 20px 0"></div>
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="textarea"
          maxlength="30"
          show-word-limit
        >
        </el-input>
        <br />
        <br />
        <el-row>
          <el-button
            type="danger"
            round
            id="applyMoney_bottom"
            @click="applyMoney_bottom"
            >提交申请</el-button
          >
        </el-row>
      </div>
    </div>
  </div>
</template>
<script>
import dayjs from "dayjs";
import axios from "axios";
import { set } from "vue";
export default {
  name: "Content-Apply",
  methods: {
    apply() {
      this.$router.push({ name: "admin_message_assets" }).catch((err) => err);
    },
    applyMoney_bottom() {
      axios({
        method: "POST",
        url: "http://localhost:8080/admin/admapply/addApply",
        data: {
          applyAssets: this.text,
          applyNameId: this.$store.state.login.id,
          applyName: this.$store.state.login.name,
          applyDescription: this.textarea,
        },
      })
        .then(() => {
          alert("提交成功！");
        })
        .catch(() => {
          alert("请求失败，请稍后重试");
        });
      this.Options = !this.Options;
    },
    applyMoney() {
      this.Options = !this.Options;
    },
    handleClick(sco) {
      const result = window.confirm("确定要删除吗？");
      if (result) {
        axios({
          method: "POST",
          url: "http://localhost:8080/admin/admapply/deleteApply",
          params: {
            applyId: sco.applyId,
          },
        })
          .then((response) => {
            alert("删除成功,请重新刷新");
            console.log(response);
          })
          .catch(() => {
            alert("请求失败，请稍后重试");
          });
      }
    },
    //禁用按钮 防止多次发送请求
    findAllApply() {
      this.disabled = true;
      setInterval(() => {
        this.disabled = false;
      }, 2000);
      //查询所有资金申请信息
      axios({
        method: "post",
        url: "http://localhost:8080/user/userapply/getAllApply",
        params: {
          //当前页码
          pageNum: 1,
          //当前页面有几个
          pageSize: 100000000,
        },
      }).then((Response) => {
        this.tableData = [...Response.data.data.list];
        this.newTableData = [...Response.data.data.list];
        this.tableData.forEach((e) => {
          e.disposeTime = dayjs(e.disposeTime).format("YYYY-MM-DD HH:mm:ss");
        });
        this.tableData.forEach((e) => {
          e.applyTime = dayjs(e.applyTime).format("YYYY-MM-DD HH:mm:ss");
        });
        this.total = Response.data.data.total;
      });
    },
  },
  watch: {
    inputFind(newval) {
      switch (this.radio) {
        case 1:
          this.newTableData = this.tableData.filter((item) => {
            return item.applyId == newval;
          });
          break;
        case 2:
          this.newTableData = this.tableData.filter((item) => {
            console.log(typeof disposeName);
            return item.disposeName == newval;
          });
          break;
        case 3:
          this.newTableData = this.tableData.filter((item) => {
            return item.applyName == newval;
          });
          break;
      }
    },
  },
  data() {
    return {
      Options: true,
      text: null,
      textarea: "",
      disabled: false,
      newTableData: null,
      inputFind: "",
      radio: 1,
      tableData: [],
    };
  },
  created() {
    //查询所有资金申请信息
    axios({
      method: "post",
      url: "http://localhost:8080/user/userapply/getAllApply",
      params: {
        //当前页码
        pageNum: 1,
        //当前页面有几个
        pageSize: 100000000,
      },
    }).then((Response) => {
      this.tableData = [...Response.data.data.list];
      this.newTableData = [...Response.data.data.list];
      this.tableData.forEach((e) => {
        e.disposeTime = dayjs(e.disposeTime).format("YYYY-MM-DD HH:mm:ss");
      });
      this.tableData.forEach((e) => {
        e.applyTime = dayjs(e.applyTime).format("YYYY-MM-DD HH:mm:ss");
      });
      this.total = Response.data.data.total;
    });
  },
};
</script>

<style scoped>
.apply {
  width: 100%;
  height: 100%;
  position: relative;
  background-color: rgba(255, 255, 255, 0.6);
  overflow-y: scroll;
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
  z-index: 99999;
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
#apply_money {
  margin-top: 200px;
}
</style>
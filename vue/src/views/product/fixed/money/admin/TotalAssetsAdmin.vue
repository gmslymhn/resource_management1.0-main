<template>
  <div class="totalAsstes">
    <div class="itemsText">
      <p class="itemsTextP">资产管理</p>
    </div>
    <div id="totalAsstes1">总资产：{{ totalAssets + "￥" }}</div>
    <div id="totalAsstes2">可支配资产：{{ disposableAssets + "￥" }}</div>
    <div id="table">
      <el-table :data="tableData" border class="tableData">
        <el-table-column fixed prop="id" label="id" width="150">
        </el-table-column>
        <el-table-column prop="totalAssets" label="总资产" width="120">
        </el-table-column>
        <el-table-column prop="disposableAssets" label="可支配资产" width="120">
        </el-table-column>
        <el-table-column prop="time" label="时间" width="180">
        </el-table-column>
        <el-table-column prop="description" label="描述" width="300">
        </el-table-column>
        <el-table-column
          prop="percentage"
          label="百分比"
          width="120"
        ></el-table-column>
      </el-table>
    </div>
    <div id="buttons">
      <el-row>
        <el-button round @click="findAllAssets">刷新所有资产</el-button>
        <br />
        <br />
        <el-button type="primary" round @click="changePercentage"
          >修改总百分比</el-button
        >
        <br />
        <br />
        <el-button type="danger" round style="text" @click="changeAllAssets"
          >修改总资产</el-button
        >
      </el-row>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import dayjs from "dayjs";
export default {
  data() {
    return {
      totalAssets: "(请查询)",
      disposableAssets: "(请查询)",
      tableData: [],
    };
  },
  methods: {
    //查询所有资产
    findAllAssets() {
      // 查询当前资产
      axios({
        method: "get",
        url: "http://localhost:8080/admin/admassets/assets",
        params: {
          pageNum: 1,
          pageSize: 1000000,
        },
      })
        .then((response) => {
          this.tableData = [...response.data.data.data.list];
          console.log(this.tableData);
          this.tableData.forEach((e) => {
            e.time = dayjs(e.disposeTime).format("YYYY-MM-DD HH:mm:ss");
          });
        })
        .catch(() => {
          alert("请求失败，请稍后重试");
        });
      // 查询最新的资产
      axios
        .get("http://localhost:8080/admin/admassets/assets/new")
        .then((response) => {
          console.log(response.data.data);
          this.totalAssets = response.data.data.totalAssets;
          this.disposableAssets = response.data.data.disposableAssets;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //修改可用资产的百分比
    changePercentage() {
      const percentage = window.prompt("请输入修改后的百分比(%)");
      const description = window.prompt("请输入修改的描述");
      //修改可用资产的百分比
      //说明:调用此接口，传入修改的百分比，更改可用资产值（可用资产值=总资产*百分比）
      axios({
        method: "put",
        url: "http://localhost:8080/admin/admassets/assets/update/percentage",
        params: {
          percentage,
          description,
        },
      })
        .then((response) => {
          console.log(response);
          alert("修改成功！");
        })
        .then(() => {
          this.findAllAssets();
        })
        .catch(() => {
          alert("请求失败，请稍后重试");
        });
    },
    //修改总资产
    changeAllAssets() {
      const totalAssets = window.prompt("请输出修改后的总资产");
      const description = window.prompt("请输入修改的描述");
      //修改总资产
      axios({
        method: "put",
        url: "http://localhost:8080/admin/admassets/assets/update/total",
        params: {
          //现有的总资产
          totalAssets,
          description,
        },
      })
        .then((response) => {
          console.log(response.data.code == 1);
          if (response.data.code == 1) alert("修改成功！请重新刷新");
          else {
            alert("修改失败！请稍后再试");
          }
        })
        .then(() => {
          this.findAllAssets();
        })
        .catch(() => {
          alert("请求失败，请稍后重试");
        });
    },
  },
  created() {
    // 查询当前资产
    axios({
      method: "get",
      url: "http://localhost:8080/admin/admassets/assets",
      params: {
        pageNum: 1,
        pageSize: 1000000,
      },
    })
      .then((response) => {
        this.tableData = [...response.data.data.data.list];
        console.log(this.tableData);
        this.tableData.forEach((e) => {
          e.time = dayjs(e.disposeTime).format("YYYY-MM-DD HH:mm:ss");
        });
      })
      .catch((err) => {
        console.log(err);
      });
    // 查询最新的资产
    axios
      .get("http://localhost:8080/admin/admassets/assets/new")
      .then((response) => {
        console.log(response.data.data);
        this.totalAssets = response.data.data.totalAssets;
        this.disposableAssets = response.data.data.disposableAssets;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style scoped>
#buttons {
  position: absolute;
  left: 2%;
  top: 60px;
}
#table {
  position: absolute;
  top: 230px;
  left: 50%;
  transform: translateX(-50%);
}
.itemsText {
  font-size: 38px;
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
.tableData {
  width: 100%;
}
.totalAsstes {
  width: 100%;
  height: 100%;
  position: relative;
  background-color: rgba(255, 255, 255, 0.6);
}
#totalAsstes1 {
  line-height: 50px;
  width: 250px;
  height: 50px;
  border: 1px solid black;
  position: absolute;
  left: 30%;
  top: 100px;
  border-radius: 10px;
}
#totalAsstes2 {
  border-radius: 10px;
  line-height: 50px;
  width: 250px;
  height: 50px;
  border: 1px solid black;
  position: absolute;
  left: 60%;
  top: 100px;
}
</style>
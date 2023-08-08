<template>
  <div class="damageReported">
    <div class="itemsText">
      <p class="itemsTextP">资金日志</p>
    </div>
    <div id="totalAsstes1">总资产：{{ totalAssets + "￥" }}</div>
    <div id="totalAsstes2">可支配资产：{{ disposableAssets + "￥" }}</div>
    <div id="button_search">
      <el-radio v-model="radio" label="1">通过id查询日志</el-radio>
      <el-radio v-model="radio" label="2">通过用户姓名查询日志</el-radio>
      <br />
      <el-input
        v-model="logsFind"
        placeholder="请输入内容"
        style="width: 330px"
      ></el-input>
    </div>
    <el-row style="position: absolute; left: 60%; top: 240px">
      <el-button type="danger" round @click="findAllLogs"
        >查询所有日志</el-button
      >
    </el-row>
    <div id="tabledata">
      <el-table :data="newTableData" border>
        <el-table-column fixed prop="assetsLogId" label="日志id" width="150">
        </el-table-column>
        <el-table-column prop="userName" label="用户姓名" width="120">
        </el-table-column>
        <el-table-column prop="beforeAssets" label="已有资产" width="120">
        </el-table-column>
        <el-table-column prop="changeAssets" label="消耗资产" width="120">
        </el-table-column>
        <el-table-column prop="afterAssets" label="花费后资产" width="120">
        </el-table-column>
        <el-table-column prop="description" label="描述" width="300">
        </el-table-column>
        <el-table-column prop="processTime" label="处理时间" width="180">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick1(scope.row)" type="text" size="small"
              >删除</el-button
            >
            <el-button @click="handleClick2(scope.row)" type="text" size="small"
              >修改</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import dayjs from "dayjs";
import axios from "axios";
export default {
  name: "Content-DamageReported",

  data() {
    return {
      totalAssets: "",
      disposableAssets: "",
      radio: "1",
      logsFind: "",
      newTableData: [],
      tableData: [],
    };
  },
  watch: {
    logsFind(newval) {
      switch (this.radio) {
        case "1":
          this.newTableData = this.tableData.filter((item) => {
            return item.assetsLogId == newval;
          });
          break;
        case "2":
          this.newTableData = this.tableData.filter((item) => {
            return item.userName == newval;
          });
          break;
      }
    },
  },
  methods: {
    //处理删除
    handleClick1(row) {
      console.log(row);
      const result = confirm("确认删除吗");
      //删除日志
      if (result) {
        axios({
          url: "http://localhost:8080/admin/admassets/assetslog/{assetsLogId}",
          method: "delete",
          params: {
            assetsLogId: row.assetsLogId,
          },
        })
          .then(() => {
            alert("删除成功！");
          })
          .then(() => {
            axios({
              url: "http://localhost:8080/admin/admassets/assetslog",
              method: "get",
              params: {
                pageNum: 1,
                pageSize: 1000000,
              },
            }).then((response) => {
              this.tableData = response.data.data.data.list;
              this.newTableData = response.data.data.data.list;
              this.tableData.forEach((e) => {
                e.processTime = dayjs(e.processTime).format(
                  "YYYY-MM-DD HH:mm:ss"
                );
              });
              this.newTableData.forEach((e) => {
                e.processTime = dayjs(e.processTime).format(
                  "YYYY-MM-DD HH:mm:ss"
                );
              });
            });
          })
          .catch(() => {
            alert("请求失败，请稍后重试");
          });
      }
    },
    //处理修改
    handleClick2(row) {
      console.log(row);
      //修改日志的描述  传过去id 和描述  修改日志的描述内容 其他不可以修改
      const description = prompt("请输入修改的日志描述");
      axios({
        method: "put",
        url: "http://localhost:8080/admin/admassets/assetslog/update",
        params: {
          id: row.assetsLogId,
          description,
        },
      })
        .then(() => {
          alert("修改成功！");
        })
        .then(() => {
          axios({
            url: "http://localhost:8080/admin/admassets/assetslog",
            method: "get",
            params: {
              pageNum: 1,
              pageSize: 1000000,
            },
          }).then((response) => {
            this.tableData = response.data.data.data.list;
            this.newTableData = response.data.data.data.list;
            this.tableData.forEach((e) => {
              e.processTime = dayjs(e.processTime).format(
                "YYYY-MM-DD HH:mm:ss"
              );
            });
            this.newTableData.forEach((e) => {
              e.processTime = dayjs(e.processTime).format(
                "YYYY-MM-DD HH:mm:ss"
              );
            });
          });
        })
        .catch(() => {
          alert("请求失败，请稍后重试");
        });
    },
    //查询所有日志
    findAllLogs() {
      // 查询现在所有的日志
      axios({
        url: "http://localhost:8080/admin/admassets/assetslog",
        method: "get",
        params: {
          pageNum: 1,
          pageSize: 1000000,
        },
      })
        .then((response) => {
          this.tableData = response.data.data.data.list;
          this.newTableData = response.data.data.data.list;
          this.tableData.forEach((e) => {
            e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
          });
          this.newTableData.forEach((e) => {
            e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
          });
        })
        .catch(() => {
          alert("请求失败，请稍后重试");
        });
      //查询最新日志
      axios
        .get("http://localhost:8080/admin/admassets/assets/new")
        .then((response) => {
          this.totalAssets = response.data.data.totalAssets;
          this.disposableAssets = response.data.data.disposableAssets;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    //获取总资产和可支配资产
    axios
      .get("http://localhost:8080/admin/admassets/assets/new")
      .then((response) => {
        this.totalAssets = response.data.data.totalAssets;
        this.disposableAssets = response.data.data.disposableAssets;
      })
      .catch((err) => {
        console.log(err);
      });
    // 查询现在所有的日志
    axios({
      url: "http://localhost:8080/admin/admassets/assetslog",
      method: "get",
      params: {
        pageNum: 1,
        pageSize: 1000000,
      },
    })
      .then((response) => {
        this.tableData = response.data.data.data.list;
        this.newTableData = response.data.data.data.list;
        this.tableData.forEach((e) => {
          e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
        });
        this.newTableData.forEach((e) => {
          e.processTime = dayjs(e.processTime).format("YYYY-MM-DD HH:mm:ss");
        });
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style scoped>
#button_search {
  position: absolute;
  left: 25%;
  top: 220px;
}
.damageReported {
  width: 100%;
  height: 100%;
  position: relative;
  background-color: rgba(255, 255, 255, 0.6);
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
#tabledata {
  position: absolute;
  width: 80%;
  margin: 40px auto;
  margin-top: 0;
  margin-bottom: 0;
  top: 360px;
  left: 50%;
  transform: translateX(-50%);
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
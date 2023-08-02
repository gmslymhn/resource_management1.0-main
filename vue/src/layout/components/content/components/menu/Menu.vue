<template>
  <div class="menu">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      :router='true'
      @open="handleOpen"
      @close="handleClose"
      background-color="#454654cc"
      text-color="#EBEEF5"
      active-text-color="#8cc540"
      :default-openeds="openeds">
      <!-- background-color="#fbc8d4e5" -->

      <!-- 首页 -->
      <el-menu-item index="home">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item>


      <!-- 固定资产管理 -->
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-money"></i>
          <span>固定资产管理</span>
        </template>

          <el-submenu index="2-1">
            <template slot="title">物品管理</template>
            <el-menu-item index="checkItems">查询物品</el-menu-item>
            <el-menu-item index="damageReported">物品损坏上报</el-menu-item>
            <el-menu-item index="apply">申请</el-menu-item>
          </el-submenu>


          <el-submenu index="2-2">
            <template slot="title">资金管理</template>
            <el-menu-item index="permission">审批</el-menu-item>
            <el-menu-item index="totalAssets">资产</el-menu-item>
          </el-submenu>

      </el-submenu>

      <!-- 云端资源管理 -->
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-cloudy"></i>
          <span>云端资源管理</span>
        </template>

        <el-menu-item index="3-1">代码片段管理</el-menu-item>
        <el-menu-item index="3-2">考试资源管建</el-menu-item>
      </el-submenu>
      

    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Layout-Menu',

  data() {
    return {
      openeds:["home","2","3"]
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  },
};
</script>

<style scoped>
  .menu{
    width: 200px;
    border-right: 10px;
    position: fixed;
    left: 0;
    top: 80px;
    bottom: 0;
  }
  .el-menu-vertical-demo{
    height: 100%;
    border: 0;
  }
</style>
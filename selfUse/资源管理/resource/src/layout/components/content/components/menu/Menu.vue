<template>
  <div class="menu">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">

      <!-- 首页 -->
      <el-menu-item index="1">
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
            <el-menu-item index="2-1-1">查询物品</el-menu-item>
            <el-menu-item index="2-1-2">物品损坏上报</el-menu-item>
            <el-menu-item index="2-1-3">申请</el-menu-item>
          </el-submenu>


          <el-submenu index="2-2">
            <template slot="title">资金管理</template>
            <el-menu-item index="2-2-1">审批</el-menu-item>
            <el-menu-item index="2-2-2">资产</el-menu-item>
            <el-menu-item index="2-2-3">查询物品</el-menu-item>
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
      
    };
  },
  methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
};
</script>

<style scoped>
</style>
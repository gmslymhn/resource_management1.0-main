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


          <el-submenu index="2-2" v-if="this.role === 'admin'">
            <template slot="title">资金管理</template>
            <el-menu-item index="logs">日志</el-menu-item>
            <el-menu-item index="totalAssets">资产</el-menu-item>
          </el-submenu>

      </el-submenu>

    

      <div class="information">
        <span class="informationRole">{{this.role}} : {{this.name}}</span>
        <!-- <span class="informationRole">admin: 我名字长你能咋地</span> -->
        <span class="informationAccount">账号 : {{this.account}}</span>
        <!-- <span class="informationAccount">账号 : 我账号长你能咋地能咋地能咋地</span> -->
      </div>  

    </el-menu>

    

  </div>
</template>

<script>
export default {
  name: 'Layout-Menu',

  data() {
    return {
      openeds: ["home","2","3","2-1","2-2"],
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
  computed: {
    role(){
      return this.$store.state.login.role
    },
    name(){
      return this.$store.state.login.name
    },
    account(){
      return this.$store.state.login.account
    }

  }
};
</script>

<style scoped>
  @font-face {
    font-family:AliMedium;
    src:url('@/assets/font/ttf/AlibabaPuHuiTi-2-65-Medium.ttf')
  }
  @font-face {
    font-family:AliHeavy;
    src:url('@/assets/font/ttf/AlibabaPuHuiTi-2-105-Heavy.ttf')
  }
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
  .information{
    position: fixed;
    bottom: 2em;
    padding-left: 20px;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
  }
  .information span{
    color:#0000FF; /*设置文字颜色*/
    text-decoration: none;
    font-size: 20px; /*设置字体大小*/
    font-style: italic;
    font-family:"AliMedium";/*设置字体*/
    animation: shine 2.4s infinite;/*设置动画*/
    word-break: break-all;
    white-space: normal;
    width: 150px;
  }
  @keyframes shine{/*创建动画*/
    0%,100%{ color:#fff;text-shadow:0 0 10px #0000FF,0 0 10px #0000FF; }
    50%{ text-shadow:0 0 10px #0000FF,0 0 40px #0000FF; }
  }
  .informationAccount{
    padding-left: 30px;
    padding-top: 0.5em;
  }
</style>
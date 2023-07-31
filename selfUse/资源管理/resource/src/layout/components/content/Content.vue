<template>
  <div>
    <!-- 侧栏 -->
    <div class="menu">
      <Menu></Menu>
    </div>

    <!-- 内容 -->
    <div class="main">
      <router-view></router-view>
    </div>

  </div>
</template>

<script>
import Menu from "./components/menu/Menu.vue"
export default {
  name: 'Layout-Content',
  components:{Menu},
  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
};
</script>

<style scoped>
  .menu{
    width: 200px;
    border-right: 0px;
    background-color: rgb(84, 92, 100);
    position: fixed;
    left: 0;
    top: 100px;
    bottom: 0;
  }
  .menu >>> .el-submenu,
  .menu >>> .el-menu-item{
    width: 200px;
  }

  .main{
    padding-left: 200px;
    background-color: skyblue;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
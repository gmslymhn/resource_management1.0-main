<template>
  <div class="content">
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
  .content{
    margin-top: 80px;
    padding-bottom: 80px;
    height: calc(100% + 80px);
  }
  .main{
    margin-left: 200px;
    /* background-color: rgba(255, 255, 255, 0.075); */
    backdrop-filter: blur(0.000001px);
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    height: calc( 100% + 80px );
  }
</style>
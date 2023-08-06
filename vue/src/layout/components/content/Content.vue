<template>
  <div class="content2">
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
  components:{ Menu },
  data() {
    return {
      contentActive:''
    };
  },
  methods: {
    
  },

  created() {
    this.contentActive = this.$store.state.style
  },
};
</script>

<style scoped>
  .content2{
    height: 100%;
    overflow-y: scroll;
    background-color: rgba(255, 255, 255, 0.6);
  }
  ::-webkit-scrollbar {
    display: none; /* Chrome Safari */
  }
  .main{
    margin-left: 200px;
    /* margin-top: 80px; */
    backdrop-filter: blur(0.000001px);
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
</style>
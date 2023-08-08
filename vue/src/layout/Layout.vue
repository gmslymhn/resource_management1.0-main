<template>
    <div class="layout">
      <!-- 上面头部 -->
      <div class="header">
        <Header></Header>
      </div>

      <!-- 下面主体 -->
      <div class="content">
        <Content></Content>
      </div>

    </div>
</template>

<script>
import Header from "./components/header/Header.vue"
import Content from "./components/content/Content.vue"

export default {
  name: 'Resource-Layout',
  components:{Header,Content},
  data() {
    return {

    };
  },

  created() {
    
  },
};
</script>

<style scoped>
  .layout{
    height: 100vh;
    background-position: center center;
    background-size: cover;
    background-image: url("../assets/zhuyeBackground.jpg");
    overflow-y: hidden;
    overflow: hidden;

  }
  .content{
    height: calc( 100% - 80px );
    margin-top: 80px;
  }
</style>
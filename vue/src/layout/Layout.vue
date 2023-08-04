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
};
</script>

<style scoped>
  .layout{
    height: 100vh;
    /* min-width: 1000px;
    min-height: 800px; */
    background-position: center center;
    background-size: cover;
    background-image: url("../assets/zhuyeBackground.jpg");
    overflow-y: hidden;
    overflow: hidden;

  }
  .content{
    height: 100%;
  }
</style>
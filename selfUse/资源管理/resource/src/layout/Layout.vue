<template>
  <div class="min">
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
    min-width: 1000px;
    min-height: 800px;
    overflow: auto;
  }
  .header{
    position: fixed;
    top: 0;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 100px;
    background-color: pink;
  }
  .content{
    padding-top: 100px;
    width: 100%;
    height: 100%;
  }
</style>
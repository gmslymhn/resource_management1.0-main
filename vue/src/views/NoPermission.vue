<template>
  <div class="inner">
    <p>无权!越权访问达咩!!</p>
    <el-button class="btn" type="danger" round @click="back">点此返回上级</el-button>
  </div>
</template>

<script>
export default {
  name: 'App-NoPermission',

  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    back(){
      this.$router.back()
    }
  },
};
</script>

<style scoped>
  .inner{
    background-color: antiquewhite;
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  p{
    font-size: 50px;
  }
  .btn{
    margin-top: 50px;
    transform: scale(2);    
  }
</style>
<template>
  <div class="inner">
    <p>呦呵?测试BUG呢?</p>
    <p>不许告状!</p>
    <el-button class="btn" type="primary" round @click="back">去去去回去</el-button>
  </div>
</template>

<script>
export default {
  name: 'WorkspaceJsonError',

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
    background-color: gray;
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
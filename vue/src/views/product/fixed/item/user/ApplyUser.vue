<template>
  <div class="apply">
    
    <div class="itemsText">
      <p class="itemsTextP">申请购买物品</p>
    </div>


    <div class="applyInner">

    </div>

  </div>
</template>

<script>
export default {
  name: 'Content-Apply',

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
  .apply{
    width: 100%;
    height: 100%;
    position: relative;
    background-color: rgba(255, 255, 255, 0.6);
  }
  .itemsText{
    font-size: 38px;
    margin-bottom: 20px;
    padding-top: 2px;
    padding-bottom: 3px;
    background-color: #e0dbdb;
    font-weight: bold;
    color: gray;
    text-align: center;
    position: fixed;
    width: 100%;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 30px 60px -12px, rgba(0, 0, 0, 0.3) 0px 18px 36px -18px;
    z-index: 1;
  }
  .applyInner{
    width: 60%;
    height: 100%;
    font-size: 25px;
    margin: 60px auto;
  }
</style>
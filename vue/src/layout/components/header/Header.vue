<template>
  <div class="header">
    <div class="headerImg">
      <img src="@/assets/logo.png" alt="LOGO">
    </div>

    <div class="headerInner">

      <!-- 消息 -->
      <el-badge :value="200" :max="99" class="innerItem">
        <el-button size="" icon="el-icon-message" class="innerItemButton" @click="message"></el-button>
      </el-badge>

      <!-- 头像 -->
      <el-dropdown size="medium">
        <el-row class="demo-avatar demo-basic">
          <el-col :span="12">
            <div class="demo-basic--circle">
              <div class="block">
                <el-avatar :size="45" :src="circleUrl"></el-avatar>
              </div>
            </div>
          </el-col>  
        </el-row>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="loginOut">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      
      
    </div>
  </div>
</template>

<script>
import Cookie from "js-cookie"
export default {
  name: 'Content-Header',

  data() {
    return {
      // 头像地址
      circleUrl: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
    };
  },
  methods: {
    message(){
      this.$router.push({path:"/zhuye/message"})
    },
    loginOut(){
      // 清除cookie的token
      Cookie.remove("token")
      this.$router.replace("/")
      // 清除vuex的token和role
      this.$store.dispatch("clearToken")
      this.$store.dispatch("clearRole")
    }
  },
};
</script>

<style scoped>
  .header{
    position: fixed;
    top: 0;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 80px;
    /* background-image: linear-gradient(to top, #fbc8d4e5 0%, #9795f0e5 100%); */
    /* background-color: #bd837f; */
    /* background-image: linear-gradient(to top, #e4a29de5 0%, #bd837fe5 100%); */
    /* background-color: rgba(0,0,0,0.8); */
    background-image: linear-gradient(to top, rgba(255, 255, 255, 0) 10%, #6b6c78 100%, rgba(255, 255, 255, 0) 150%);
    display: flex;
    justify-content: space-between;
  }
  /* .headerText{
    width: 200px;
    height: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .headerText span{
    font-family: "Microsoft YaHei";
    font-size: 2rem;
    display: inline-block;
    font-weight: bold;
  }
  .headerText span:nth-child(1){
    color: wheat;
  }
  .headerText span:nth-child(2){
    color: #6A5ACD	;
  } */
  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
  .headerImg{
    width: 200px;
    height: 80px;
    border-top-right-radius: 1em;
    border-bottom-right-radius: 1em;
    overflow: hidden;
  }
  .headerImg img{
    width: 100%;
    height: 100%;
    object-fit: cover;
    background-color: blue;
  }
  .headerInner{
    width: 400px;
    display: flex;
    justify-content: end;
    align-items: center;
  }
  .innerItem{
    margin-right: 50px;
  }
  .header >>> .innerItemButton{
    height: 36px;
  }
  .demo-avatar{
    margin-right: 30px;
  }
</style>
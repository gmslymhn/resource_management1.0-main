<template>
  <div class="header">
    <div class="headerImg">
      <img src="@/assets/logo.png" alt="LOGO">
    </div>

    <div class="headerInner">

      <!-- 消息 -->
      <el-badge :value="messageNum" :max="99" class="innerItem" v-if="shenfen === 'admin'">
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
// 节流
import { throttle } from 'lodash-es';
// 消息查询
import { messageQuantity } from "@/api/message/message"
export default {
  name: 'Content-Header',

  data() {
    return {
      // 头像地址
      circleUrl: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
      // 身份
      shenfen: '',
      // 消息有几条
      messageNum: '',
    };
  },
  methods: {
    message: throttle(function(){
      this.$router.push({ name:"admin_message_reported" }).catch(err => err)
    },1500),

    loginOut(){
      // 清除vuex的token和role和account和name
      this.$store.dispatch("login/clearToken")
      this.$store.dispatch("login/clearRole")
      this.$store.dispatch("login/clearAccount")
      this.$store.dispatch("login/clearName")
      // 清除cookie的token
      Cookie.remove("token")
      // 回到登录界面
      this.$router.replace("/")
    },

    // 消息查询
    async getMessageQuantity(){
      let res = await messageQuantity();
      console.log("消息查询操作-----", res);
      this.messageNum = res.data;
      if(this.messageNum){
        this.$notify.info({
          title: '消息',
          message: '您有待审批消息'
        });
      }
    }
  },
  mounted() {
    this.shenfen = this.$store.state.login.role
    console.log("身份是:",this.$store.state.login.role);

    // 消息查询
    if(this.shenfen === "admin"){
      this.getMessageQuantity()
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
    border-bottom: 3px #6b6c78 solid;
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
    width: 200px;
    height: 80px;
    object-fit: cover;
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
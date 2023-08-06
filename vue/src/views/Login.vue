<template>
  <div id="poster">
    <el-form class="loginContainer" ref="loginForm" :model="loginForm">
      <h3 class="loginTitle">
        系统登录
      </h3>

      <el-alert
        v-if= isLoginFail
        title="登陆失败"
        type="error"
        description="请检查账号密码是否正确"
        show-icon>
      </el-alert>

      <el-form-item label="">
        <el-input v-model="loginForm.loginName" autocomplete="off" placeholder="请输入账号" clearable></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="loginForm.loginPassword" autocomplete="off" placeholder="请输入密码" show-password  @keyup.enter.native="LoginButton"></el-input>
      </el-form-item>
      <div class="tool">
        <div>
          
        </div>
        <div>
          <span class="forgetPassword" @click="open2">忘记密码？</span>
        </div>
      </div>
      <el-form-item class="button">
        <el-button class="button1" type="danger" round @click="LoginButton">登录</el-button>
        <el-button type="info" round @click="toRegister">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import Cookie from "js-cookie"
import { login } from "@/api/login/login"
export default {
  name: 'App-Login',

  data() {
    return {
      loginForm: {
        loginName: '',
        loginPassword: '',
      },
      checked: false,
      isLoginFail: false
    }
  },
  methods: {
    // 登录按钮
    LoginButton() {
      // this.$router.replace("/admin");
      // console.log({useraccount: this.loginForm.loginName, password: this.loginForm.loginPassword});
      login({useraccount: this.loginForm.loginName, password: this.loginForm.loginPassword})
        .then((res) => {
          console.log("用户信息-----",res);
          if(res.data.code === 1){
            // 请求成功后跳转到指定路由界面
            Cookie.set("token",res.data.data.token);
            this.$store.dispatch("login/setAccount", res.data.data.account);
            this.$store.dispatch("login/setId", res.data.data.id);
            this.$store.dispatch("login/setName", res.data.data.name);
            this.$store.dispatch("login/setRole", res.data.role);
            this.$store.dispatch("login/setToken", res.data.data.token);

            this.$message({
              showClose:true,
              type:"success",
              message:"成功登录！喜欢您来",
            })
            if(res.data.role === "admin"){
              this.$router.replace("/admin");
            } else if(res.data.role === "user") {
              this.$router.replace("/user");
            }
          } else{
            this.loginForm = {},
            this.isLoginFail = true
          }
        })
    },

    // 注册
    toRegister() {
      this.$router.push({path:"/register"})
    },
    // 是否记住密码
    remenber(data){
      this.checked = data
      if(this.checked){
          localStorage.setItem("news",JSON.stringify(this.form))
      }else{
        localStorage.removeItem("news")
      }
    },
    // 忘记密码
    open2() {
      this.$message({
        showClose:true,
        type:"success",
        message:"恭喜你忘记了密码！(蒸乌鱼😥)",
      })
    },
  }
};
</script>

<style scoped>
  #poster{
    height: 100%;
    width: 100%;
    min-width: 1000px;
    min-height: 800px;
    position: fixed;
    background-position: center center;
    background-size: cover;
    background-image: url("../assets/loginBackground.jpg");
    overflow: auto;
    padding-top: 150px;
  }
  .loginContainer{
    width: 400px;
    height: 300px;
    transform: translate(-50%);
    margin-left: 50%;
    padding: 80px 100px;
    box-shadow: 5px 5px 10px rgb(179, 86, 86);
    border-radius: 20px;
  }
  .loginTitle {
    margin-bottom: 20px;
    line-height: 50px;
    text-align: center;
    font-size: 250%;
    font-weight: bolder;
    color: white;
    text-shadow: 2px 2px 4px #000000;
  }
  .el-alert{
    margin-top: 10px;
    margin-bottom: 10px;
  }
  .tool {
    display: flex;
    justify-content: space-between;
  }
  .remeberPassword{
    color: #b3b3b3;
    text-shadow: 2px 2px 4px #000000;
  }
  .forgetPassword {
    font-size: 14px;
    color: #b3b3b3;
    text-shadow: 2px 2px 4px #000000;
    cursor: pointer;
  }
  .button{
    margin-top: 50px;
    text-align: center;
  }
  .button1{
    margin-right: 40px;
  }
</style>
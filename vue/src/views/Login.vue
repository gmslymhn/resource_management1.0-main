<template>
  <div id="poster">
    <el-form class="loginContainer" ref="loginForm" :model="loginForm">
      <h3 class="loginTitle">
        系统登录
      </h3>
      <el-form-item label="">
        <el-input v-model="loginForm.loginName" autocomplete="off" placeholder="请输入账号" clearable></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="loginForm.loginPassword" autocomplete="off" placeholder="请输入密码" show-password></el-input>
      </el-form-item>
      <div class="tool">
        <div>
          <el-checkbox v-model="checked" @change="remenber" class="remeberPassword">
            记住密码
          </el-checkbox>
        </div>
        <div>
          <span class="forgetPassword" @click="open2">忘记密码？</span>
        </div>
      </div>
      <el-form-item class="button">
        <el-button class="button1" type="primary" round @click="Login">登录</el-button>
        <el-button type="success" round @click="toRegister">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'App-Login',

  data() {
    return {
      loginForm: {
        loginName: '',
        loginPassword: '',
      },
      checked: false
    }
  },
  methods: {
    // 登录
    Login() {
      // this.axios.post("http://localhost:xxxx/user/login",this.loginForm).then((response) => {
      //   let data = response.data
      //   if(data){
      //     this.loginForm = {}
      //     this.$router.push({path:"/zhuye"})
      //     this.$message({
      //       showClose:true,
      //       type:"success",
      //       message:"成功登录！喜欢您来",
      //     })
      //     console.log(data)
      //   }
      // }).catch(err => {
      //   console.log(err);
      // })
      this.$router.push({path:"/zhuye"})
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
    background-color:rgba(255,255,255,0.15);
    box-shadow: 5px 5px 10px rgb(85, 238, 71);
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
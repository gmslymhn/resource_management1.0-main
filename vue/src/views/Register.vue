<template>
  <div id="poster">
    <el-form class="registerContainer" :model="registerForm" status-icon :rules="rules" ref="registerForm">
      <h3 class="registerTitle">
        系统注册
      </h3>

      <el-scrollbar class="scrollbar">

        <div class="scrollbarDiv" >

          <!-- 账号 -->
          <el-form-item label="" prop="userName">
            <el-input 
              v-model.trim="registerForm.userName" 
              autocomplete="off" 
              placeholder="请输入账号"
              prefix-icon="el-icon-user-solid"
              clearable>
            </el-input>
          </el-form-item>

          <!-- 密码 -->
          <el-form-item label="" prop="pass">
            <el-input 
              type="password" 
              v-model.trim="registerForm.pass" 
              autocomplete="off" 
              placeholder="请输入密码"
              prefix-icon="el-icon-lock">
            </el-input>
          </el-form-item>

          <!-- 确认密码 -->
          <el-form-item label="" prop="checkPass">
            <el-input 
              type="password" 
              v-model.trim="registerForm.checkPass" 
              autocomplete="off" 
              placeholder="请重新输入密码"
              prefix-icon="el-icon-lock">
            </el-input>
          </el-form-item>
          
          <!-- 姓名 -->
          <el-form-item label="" prop="peopleName">
            <el-input 
              v-model.trim="registerForm.peopleName" 
              autocomplete="off" 
              placeholder="请输入你的姓名"
              prefix-icon="el-icon-user-solid"
              clearable>
            </el-input>
          </el-form-item>

          <!-- 学号 -->
          <el-form-item label="" prop="studentNum">
            <el-input 
              v-model.trim="registerForm.studentNum" 
              autocomplete="off" 
              placeholder="请输入你的学号"
              prefix-icon="el-icon-tickets"
              clearable>
            </el-input>
          </el-form-item>

          <!-- 邮箱 -->
          <el-form-item label="" prop="email">
            <el-input 
              v-model.trim="registerForm.email" 
              autocomplete="off" 
              placeholder="请输入邮箱"
              prefix-icon="el-icon-message"
              clearable>
            </el-input>
          </el-form-item>

        </div>
      </el-scrollbar>


      <!-- 提交按钮 -->
      <el-form-item class="button">
        <el-button class="button1" type="warning" round @click="registerButton()">注册</el-button>
        <el-button type="primary" round @click="toLogin">返回登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { register } from "@/api/register/register"
export default {
  name: 'App-Register',
  data() {
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.registerForm.checkPass !== '') {
          this.$refs.registerForm.validateField('checkPass');
        }
        callback();
      }
    };
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.registerForm.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      registerForm: {
        userName: '',   // 账号
        pass: '',       // 密码
        checkPass: '',
        peopleName:'',  // 姓名
        studentNum:'',  // 学号
        email:'',       // 邮箱
      },
      rules: {
        userName: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          // { min: 2, max: 9, message: '长度2~9个字符', trigger: 'blur'}
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        peopleName: [
          { required: true, message: '请输入姓名', trigger: 'blur' }
        ],
        studentNum: [
          { required: true, message: '请输入学号', trigger: 'blur' },
          // { min: 10, max: 10, message: '长度10个数字', trigger: 'blur'}
        ],
        email: [
          { required: true, message: '请输入邮箱地址', trigger: 'blur' }
        ]
      },
    };
  },
  methods: {
    async postRegister(userName,pass,peopleName,studentNum,email){
      let res =  await register({userAccount: userName,userPassword: pass,userName: peopleName,userNumber: studentNum,userpost: email})
      console.log(res);
      if(res.data.code === 1){
        this.registerForm = {}
        this.$message({
          showClose:true,
          type:"success",
          message:"注册成功，前往登录",
        })
        this.$router.push({path:"/login"})
      } else if(res.data.code === 0){
        if(res.data.msg === "学号已存在"){
          this.$message({
            showClose: true,
            message: '学号已存在',
            type: 'error'
          })
        }else if(res.data.msg === "账号已存在"){
          this.$message({
            showClose: true,
            message: '账号已存在',
            type: 'error'
          })
        }
      }
    },

    // 注册按钮
    registerButton() {
      console.log(this.registerForm.userName, this.registerForm.pass, this.registerForm.peopleName, this.registerForm.studentNum, this.registerForm.email);
      this.$refs.registerForm.validate((valid) => {
        if (valid) {
          this.postRegister(this.registerForm.userName, this.registerForm.pass, this.registerForm.peopleName, this.registerForm.studentNum, this.registerForm.email)
        }else {
          this.$message({
            showClose: true,
            message: '不符合规则',
            type: 'error'
          });
          console.log('error submit!!');
          return false;
        }
      });
    },

    // 返回登录界面
    toLogin(){
      this.$router.push({path:"/login"})
    }


  },

}
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
  .registerContainer{
    width: 400px;
    height: 350px;
    transform: translate(-50%);
    margin-left: 50%;
    padding: 80px 100px;
    box-shadow: 5px 5px 10px rgb(179, 86, 86);
    border-radius: 20px;
  }
  .registerTitle {
    margin-bottom: 20px;
    line-height: 50px;
    text-align: center;
    font-size: 250%;
    font-weight: bolder;
    color: white;
    text-shadow: 2px 2px 4px #000000;
  }
  .scrollbar{
    width: 100%;
    height: 75%;
    
  }
  .scrollbarDiv{
    width: 85%;
    margin: 0 auto;
    overflow:hidden
  }
  .scrollbar >>> .el-scrollbar__wrap{
    overflow-x: hidden;
  }
  .scrollbar >>> .el-scrollbar__thumb{
    background-color: rgb(255, 255, 255);
  }
  .button{
    margin-top: 30px;
    text-align: center;
  }
  .button1{
    margin-right: 40px;
  }
</style>
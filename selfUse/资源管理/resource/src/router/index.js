import VueRouter from 'vue-router';

// 引入组件
import Login from "@/views/Login"
import Register from "@/views/Register"
import Layout from "@/layout/Layout"
import Home from "@/views/product/Home"

const router = new VueRouter({
  routes:[
    // 默认/但是重定向给login
    {
      path:"/",
      redirect:"/login",
    },
    // 登录界面
    {
      name:"denglu",
      path:"/login",
      component: Login,
    },
    // 注册界面
    {
      name:"zhuce",
      path:"/register",
      component: Register,
    },
    // 主页
    {
      name:"zhuye",
      path:"/layout",
      component: Layout,
      children:[
        // 默认/但是重定向给login
        {
          path:"/",
          redirect:"/home",
        },
        // 主页下的首页
        {
          name:"shouye",
          path:"/home",
          component:Home
        }
      ]
    },
  ]
})

export default router
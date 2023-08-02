import VueRouter from 'vue-router';

// 引入组件
import Login from "@/views/Login"
import Register from "@/views/Register"
import Layout from "@/layout/Layout"
import Home from "@/views/product/Home"
import Message from "@/views/product/Message"

// admin
const CheckItemsAdmin = () => import("@/views/product/fixed/item/admin/CheckItemsAdmin")
const ApplyAdmin = () => import("@/views/product/fixed/item/admin/ApplyAdmin")
const DamageReportedAdmin = () => import("@/views/product/fixed/item/admin/DamageReportedAdmin")
const PermissionAdmin = () => import("@/views/product/fixed/money/admin/PermissionAdmin")
const TotalAssetsAdmin = () => import("@/views/product/fixed/money/admin/TotalAssetsAdmin")

// user
const CheckItemsUser = () => import("@/views/product/fixed/item/user/CheckItemsUser")
const ApplyUser = () => import("@/views/product/fixed/item/user/ApplyUser")
const DamageReportedUser = () => import("@/views/product/fixed/item/user/DamageReportedUser")
const PermissionUser = () => import("@/views/product/fixed/money/user/PermissionUser")
const TotalAssetsUser = () => import("@/views/product/fixed/money/user/TotalAssetsUser")


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
    // 管理员的
    {
      // name:"admin",
      path:"/admin",
      component: Layout,
      children:[
        // 默认/但是重定向给home
        {
          path:"/",
          redirect:"home",
        },
        // 主页下的首页
        {
          name:"admin_shouye",
          path:"home",
          component:Home,
          meta: { requiresAdmin: true },
        },
        // 消息页面
        {
          name:"admin_xiaoxi",
          path:"message",
          component:Message,
          meta: { requiresAdmin: true },
        },
        // 固定资产-物品管理-查询物品
        {
          name:"admin_cha",
          path:"checkItems",
          component:CheckItemsAdmin,
          meta: { requiresAdmin: true },
        },
        // 固定资产-物品管理-申请购买新物品
        {
          name:"admin_shenqing",
          path:"apply",
          component:ApplyAdmin,
          meta: { requiresAdmin: true },
        },
        // 固定资产-物品管理-物品损坏上报
        {
          name:"admin_shangbao",
          path:"damageReported",
          component:DamageReportedAdmin,
          meta: { requiresAdmin: true },
        },
        // 固定资产-资金管理-审批
        {
          name:"admin_shenpi",
          path:"permission",
          component:PermissionAdmin,
          meta: { requiresAdmin: true },
        },
        // 固定资产-资金管理-查看资产
        {
          name:"admin_zichan",
          path:"totalAssets",
          component:TotalAssetsAdmin,
          meta: { requiresAdmin: true },
        }
      ]
    },
    // 普通用户的
    {
      // name:"user",
      path:"/user",
      component: Layout,
      children:[
        // 默认/但是重定向给home
        {
          path:"/",
          redirect:"home",
        },
        // 主页下的首页
        {
          name:"user_shouye",
          path:"home",
          component:Home,
          meta: { requiresUser: true },
        },
        // 消息页面
        {
          name:"user_xiaoxi",
          path:"message",
          component:Message,
          meta: { requiresUser: true },
        },
        // 固定资产-物品管理-查询物品
        {
          name:"user_cha",
          path:"checkItems",
          component:CheckItemsUser,
          meta: { requiresUser: true },
        },
        // 固定资产-物品管理-申请购买新物品
        {
          name:"user_shenqing",
          path:"apply",
          component:ApplyUser,
          meta: { requiresUser: true },
        },
        // 固定资产-物品管理-物品损坏上报
        {
          name:"user_shangbao",
          path:"damageReported",
          component:DamageReportedUser,
          meta: { requiresUser: true },
        },
        // 固定资产-资金管理-审批
        {
          name:"user_shenpi",
          path:"permission",
          component:PermissionUser,
          meta: { requiresUser: true },
        },
        // 固定资产-资金管理-查看资产
        {
          name:"user_zichan",
          path:"totalAssets",
          component:TotalAssetsUser,
          meta: { requiresUser: true },
        }
      ]
    },
  ]
})

import Cookie from 'js-cookie';

// 添加全局前置路由守卫
router.beforeEach((to, from, next) => {
  // 获取身份
  const role = "admin"
  // 组件的meta
  const requiresAdmin = to.meta.requiresAdmin;
  const requiresUser = to.meta.requiresUser;
  // 判断token存不存在
  const token = Cookie.get("token")
  // 未登录，应该跳转登录页面
  if(!token && to.name !== "denglu") {
    next({ name: 'denglu' })
  } else if(token && to.name === "denglu") {
    // 已登录，跳转首页
    if (requiresAdmin && role === "admin") {
      next({ name: "admin_shouye" });
    } else if (requiresUser && role === "user") {
      next({ name: "user_shouye" });
    } else {
      next(  )
    }
  }else{
    next(  )
  }
})

export default router
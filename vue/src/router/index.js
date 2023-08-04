import VueRouter from 'vue-router';

// 引入组件
import Login from "@/views/Login"
import Register from "@/views/Register"
import Layout from "@/layout/Layout"
import Home from "@/views/product/Home"

const CheckItems = () => import("@/views/product/fixed/item/CheckItems")
const Apply = () => import("@/views/product/fixed/item/Apply")
const DamageReported = () => import("@/views/product/fixed/item/DamageReported")
const CheckItemsAdmin = () => import("@/views/product/fixed/money/CheckItemsAdmin")
const Permission = () => import("@/views/product/fixed/money/Permission")
const TotalAssets = () => import("@/views/product/fixed/money/TotalAssets")



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
      path:"/zhuye",
      component: Layout,
      children:[
        // 默认/但是重定向给login
        {
          path:"/",
          redirect:"home",
        },
        // 主页下的首页
        {
          name:"shouye",
          path:"home",
          component:Home
        },
        // 固定资产-物品管理-查询物品(普通用户)
        {
          name:"cha",
          path:"checkItems",
          component:CheckItems
        },
        // 固定资产-物品管理-申请购买新物品
        {
          name:"shenqing",
          path:"apply",
          component:Apply
        },
        // 固定资产-物品管理-物品损坏上报
        {
          name:"shangbao",
          path:"damageReported",
          component:DamageReported
        },
        // 固定资产-资金管理-查询物品(管理员)
        {
          name:"chaAdmin",
          path:"checkItemsAdmin",
          component:CheckItemsAdmin
        },
        // 固定资产-资金管理-审批
        {
          name:"shenpi",
          path:"permission",
          component:Permission
        },
        // 固定资产-资金管理-查看资产
        {
          name:"zichan",
          path:"totalAssets",
          component:TotalAssets
        }
      ]
    },
  ]
})

export default router
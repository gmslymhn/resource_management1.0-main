import VueRouter from 'vue-router';

// 引入组件
const Login = () => import("@/views/Login")
const Register = () => import("@/views/Register")
const NoPermission = () => import("@/views/NoPermission")
const ErrorPage = () => import("@/views/Error")
const Layout = () => import("@/layout/Layout")
const Home = () => import("@/views/product/Home")
const MessageReported = () => import("@/views/product/message/MessageReported")
const MessageAssets = () => import("@/views/product/message/MessageAssets")

// admin
const CheckItemsAdmin = () => import("@/views/product/fixed/item/admin/CheckItemsAdmin")
const ApplyAdmin = () => import("@/views/product/fixed/item/admin/ApplyAdmin")
const DamageReportedAdmin = () => import("@/views/product/fixed/item/admin/DamageReportedAdmin")
const LogsAdmin = () => import("@/views/product/fixed/money/admin/LogsAdmin")
const TotalAssetsAdmin = () => import("@/views/product/fixed/money/admin/TotalAssetsAdmin")

// user
const CheckItemsUser = () => import("@/views/product/fixed/item/user/CheckItemsUser")
const ApplyUser = () => import("@/views/product/fixed/item/user/ApplyUser")
const DamageReportedUser = () => import("@/views/product/fixed/item/user/DamageReportedUser")


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
      meta: { title: '登录-ReManage-年轻人的次世代资源管理系统' },
    },
    // 注册界面
    {
      name:"zhuce",
      path:"/register",
      component: Register,
      meta: { title: '注册-ReManage-年轻人的次世代资源管理系统' },
    },
    // 无权访问页面
    {
      name:"wuquan",
      path:"/nopermission",
      component: NoPermission,
      meta: { title: '越权爬爬爬' },
    },
    // 错误页面
    { 
      name:"cuowu",
      path: '/404',
      component: ErrorPage,
      hidden: true,
      meta: { title: '报错咯好耶' },
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
          meta: { requiresAdmin: true ,title: '首页-ReManage-年轻人的次世代资源管理系统' },
        },
        // 消息页面-上报
        {   
          name:"admin_message_reported",
          path:"messageReported",
          component: MessageReported,
          meta: { requiresAdmin: true ,title: '物品损坏上报审批-ReManage-年轻人的次世代资源管理系统' },
        },
        // 消息页面-资产
        {
          name:"admin_message_assets",
          path:"messageAssets",
          component: MessageAssets,
          meta: { requiresAdmin: true ,title: '申请资金审批-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-物品管理-查询物品
        {
          name:"admin_cha",
          path:"checkItems",
          component:CheckItemsAdmin,
          meta: { requiresAdmin: true ,title: '物品管理-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-物品管理-申请购买新物品
        {
          name:"admin_shenqing",
          path:"apply",
          component:ApplyAdmin,
          meta: { requiresAdmin: true ,title: '申请购买物品-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-物品管理-物品损坏上报
        {
          name:"admin_shangbao",
          path:"damageReported",
          component:DamageReportedAdmin,
          meta: { requiresAdmin: true ,title: '物品损坏上报-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-资金管理-日志
        {
          name:"admin_rizhi",
          path:"logs",
          component:LogsAdmin,
          meta: { requiresAdmin: true ,title: '资金日志-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-资金管理-全部资产
        {
          name:"admin_zichan",
          path:"totalAssets",
          component:TotalAssetsAdmin,
          meta: { requiresAdmin: true ,title: '全部资产-ReManage-年轻人的次世代资源管理系统' },
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
          meta: { requiresUser: true ,title: '首页-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-物品管理-查询物品
        {
          name:"user_cha",
          path:"checkItems",
          component:CheckItemsUser,
          meta: { requiresUser: true ,title: '物品管理-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-物品管理-申请购买新物品
        {
          name:"user_shenqing",
          path:"apply",
          component:ApplyUser,
          meta: { requiresUser: true ,title: '申请购买物品-ReManage-年轻人的次世代资源管理系统' },
        },
        // 固定资产-物品管理-物品损坏上报
        {
          name:"user_shangbao",
          path:"damageReported",
          component:DamageReportedUser,
          meta: { requiresUser: true ,title: '物品损坏上报-ReManage-年轻人的次世代资源管理系统' },
        },
      ]
    },
    // 匹配不符合上面页面的
    {     
      path: '*',
       redirect: '/404',
       hidden: true
    }
  ]
})

import Cookie from 'js-cookie';
import store from '@/store/index';

// 添加全局前置路由守卫
router.beforeEach((to, from, next) => {
  // 获取身份
  const role = store.state.login.role;
  console.log("前置路由守卫检查出role为:",role);
  // 组件的meta
  const requiresAdmin = to.meta.requiresAdmin;
  const requiresUser = to.meta.requiresUser;
  // 判断token存不存在
  const token = Cookie.get("token")
  // 未登录，应该跳转登录页面
  // if(!token) {
  //   console.log("没有token,未登录");
  //   next( { name: 'denglu' }) 
  // } else if(token) {
  //   // 已登录，跳转首页
  //   if ( requiresAdmin && role === "admin") {
  //     console.log("已登录,且当前页面为登录,为管理员,前往管理员首页");
  //     next( { name: "admin_shouye" } );
  //     return 
  //   } else if ( requiresUser && role === "user") {
  //     console.log("已登录,且当前页面为登录,为用户,前往用户首页");
  //     next( { name: "user_shouye" } );
  //     return 
  //   } else {
  //     // console.log("已登录,且当前页面为登录,但没有身份,前往无权");
  //     next()
  //   }
  // } else{
  //   if( role === "admin" ){
  //     next( { name: "admin_shouye" } )
  //   } else if( role === "user" ){
  //     next( { name: "user_shouye" } )
  //   }
  // }

  // 检查路由元数据中的 requiresAdmin 和 requiresUser 属性
  if (to.meta.requiresAdmin && role !== 'admin') {
    // 用户无权访问管理员页面
    next('/nopermission');
  } else if (to.meta.requiresUser && role !== 'user') {
    // 用户无权访问普通用户页面
    next('/nopermission');
  } else {
    // 用户有权限访问该页面
    next();
  }
})



// 切换标题
router.beforeEach((to, from, next) => {
  // 在每次路由切换前更新页面标题
  if (to.meta.title) {
    document.title = to.meta.title;
  }
  next();
});



export default router
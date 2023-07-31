// 对API进行统一管理
import requests from "./requests";

// 三级联动接口

//
// URL:/api/xxx method: get/post   数据:xxx yyy
// export const reqLogin = () => requests({url:"/xxx/xxx/",method: "get"})
// export const reqLogin2 = () => requests({url:`/xxx/xxx/${???}`,method: "get"})
// export const reqLogin3 = (???) => requests({url:"xxx",data,method:"post"})

// 使用：Vuex里在action中
// async userLogin({commit},data){
//   let result = await reqUserLogin(data)
// }
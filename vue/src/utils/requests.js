// // 对axios进行二次封装

// import axios from "axios"

// // 1.利用axios方法create，去创建一个axios实例
// // 2.request就是axios，为了配置一下axios
// const requests = axios.create({
//   // 基础路径，发请求路径中会出现/api
//   baseURL:"/api",
//   // 代表请求超时事件5s
//   timeout:5000,
// });

// // 请求拦截器
// requests.interceptors.request.use((config) => {
//   // config配置对象，对象里有一个属性：headers请求头
//   return config;
// })

// // 响应拦截器
// requests.interceptors.response.use((res) => {
//   // 成功回调函数
//   return res.data
// },(error) => {
//   // 失败回调函数
//   return Promise.reject(new Error("fail"))
// })

// // 对外暴露
// export default requests;

// 引入axios
import axios from 'axios'
//引入loading组件(以实际项目为准)
import { Loading } from 'element-ui';
// 创建的axios的实列 requests
const requests = axios.create({
    baseURL:"http://localhost:8080", // 基准地址 可直接配置路径,也可代理路径(以实际项目为准)
    timeout: 10000 // 超时时间
})
// 请求拦截
// 声明变量接收logding
let loadingInstance
requests.interceptors.request.use((config) => {
    // // 设置请求头
    // let token = localStorage.getItem('token')
    // config.headers.Authorization = token
    // 设置logding配置 赋值
    loadingInstance = Loading.service({
        lock: true,
        text: '拼命加载中...',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
    });
    // 返回请求头
    return config
}, err => {
   // 请求失败返回失败信息
    return Promise.reject(err)
})

// 响应拦截
requests.interceptors.response.use((res) => {
    // 响应成功则关闭loading加载
    loadingInstance.close();
    // 返回响应数据
    return res
}, err => {
    // 响应失败则关闭loading加载  
    setTimeout(() => {
        loadingInstance.close();
    }, 1000);
    // 响应失败返回失败信息
    return Promise.reject(err)
})

export default requests
// 对axios进行二次封装

import axios from "axios"

// 1.利用axios方法create，去创建一个axios实例
// 2.request就是axios，为了配置一下axios
const requests = axios.create({
  // 基础路径，发请求路径中会出现/api
  baseURL:"/api",
  // 代表请求超时事件5s
  timeout:5000,
});

// 请求拦截器
requests.interceptors.request.use((config) => {
  // config配置对象，对象里有一个属性：headers请求头
  return config;
})

// 响应拦截器
requests.interceptors.response.use((res) => {
  // 成功回调函数
  return res.data
},(error) => {
  // 失败回调函数
  return Promise.reject(new Error("fail"))
})

// 对外暴露
export default requests;
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

// vue.config.js
module.exports = {
  devServer: {
      proxy: {
          '/abc': {
              // target写后端的地址
              target: 'http://172.16.1.49:8080', // 你请求的第三方接口，注意结尾不要带 '/'
              changeOrigin: true, // 在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
              // ws: true,
              
              // 不用重写，已经二次封装了
              // pathRewrite: {  // 路径重写，
              //     '^/api': '/api' // 替换target中的请求地址，也就是说以后你在请求 http://localhost/api 这个地址的时候直接写成 /api 即可。
              // }
          }
      }
  }
}
/**
//  * 解决跨域问题
//  * @type {{devServer: {proxy: {"/api": {changeOrigin: boolean, pathRewrite: {"^/api": string}, target: string}}, host: string, open: boolean}}}
//  */
// module.exports = {
//   devServer: {
//       // 代理配置表，在这里可以配置特定的请求代理到对应的API接口
//       // 例如将'localhost:8080/api/xxx'代理到'www.example.com/api/xxx'
//       proxy: {
//           '/abc': { // 匹配所有以 '/api'开头的请求路径
//               target: 'http://172.16.1.49:8080', // 代理目标的基础路径
//               // secure: false,  // 如果是https接口，需要配置这个参数
//               changeOrigin: true, // 支持跨域
//               pathRewrite: { // 重写路径: 去掉路径中开头的'/api'
//                   '^/api': ''
//               }
//           }
//       }
//   }
// }


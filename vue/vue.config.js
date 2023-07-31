const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

// vue.config.js
module.exports = {
  devServer: {
      proxy: {
          '/api': {
              // target写后端的地址
              target: 'http://localhost', // 你请求的第三方接口，注意结尾不要带 '/'
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
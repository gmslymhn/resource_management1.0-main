import Vue from 'vue';
import App from './App.vue';
// // 引入vue-router
import VueRouter from 'vue-router';
// // 引入路由器
import router from './router/index';
// 引入ElementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 引入axios
import axios from "axios"
import VueAxios from 'vue-axios';
// 引入仓库
import store from "./store"
Vue.config.productionTip = false;

// 应用
Vue.use(VueRouter)
Vue.use(ElementUI)
Vue.use(VueAxios)
Vue.prototype.axios = axios;

// 创建vm
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store
})
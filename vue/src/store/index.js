import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

// 引入小仓库
import home from "@/store/modules/home"
import login from "@/store/modules/login"

export default new Vuex.Store({
  modules:{
    home,
    login
  }
})
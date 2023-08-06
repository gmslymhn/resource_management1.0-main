import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

// 引入小仓库
import message from "./modules/message"
import login from "@/store/modules/login"
import style from "@/store/modules/style"

export default new Vuex.Store({
  modules:{
    message,
    login,
    style
  }
})
import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

// 引入小仓库
import home from "./modules/Home"
export default new Vuex.Store({
  modules:{
    home,
  }
})
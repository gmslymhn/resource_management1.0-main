export default{
  namespaced: true,
  state:{
    contentActive: ""
  },
  mutations:{
    SET_CONTENT2_STYLE(state,contentActive){
      state.contentActive = contentActive
    },
    CLEAR_CONTENT2_STYLE(state){
      state.contentActive = ""
    },
  },
  actions:{
    setContent2Style(context,contentActive){
      console.log("setContent2Style执行了",contentActive);
      context.commit("SET_CONTENT2_STYLE",contentActive)
    },
    clearContent2Style(context){
      context.commit("CLEAR_CONTENT2_STYLE")
    },
  },

}
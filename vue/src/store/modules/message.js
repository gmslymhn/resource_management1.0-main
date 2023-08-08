export default{
  namespaced: true,
  state:{
    allMessage:'',
    reportMessage:'',
    assetsMessage:''
  },
  mutations:{
    SET_ALL_MESSAGE(state,allMessage){
      state.allMessage = allMessage
    },
    SET_REPORT_MESSAGE(state,reportMessage){
      state.reportMessage = reportMessage
    },
    SET_ASSESTS_MESSAGE(state,assetsMessage){
      state.assetsMessage = assetsMessage
    }
  },
  actions:{
    setAllMessage(context,allMessage){
      context.commit("SET_ALL_MESSAGE",allMessage)
    },
    setReportMessage(context,reportMessage){
      context.commit("SET_REPORT_MESSAGE",reportMessage)
    },
    setAssestsMessage(context,assetsMessage){
      context.commit("SET_ASSESTS_MESSAGE",assetsMessage)
    }
  },

}
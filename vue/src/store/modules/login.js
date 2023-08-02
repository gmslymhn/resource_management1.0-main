export default{
  namespaced: true,
  state:{
    role: null,
    token: null
  },
  mutations: {
    SET_ROLE(state,role) {
      state.role = role
    },
    CLEAR_ROLE(state){
      state.role = null
    },
    SET_TOKEN(state, token) {
      state.token = token;
    },
    CLEAR_TOKEN(state) {
      state.token = null;
    },
  },
  actions:{
    setRole(context,role) {
      context.commit("SET_ROLE",role)
    },
    clearRole(context) {
      context.commit("CLEAR_ROLE")
    },
    setToken(context,token) {
      context.commit("SET_TOKEN",token)
    },
    clearToken(context) {
      context.commit("CLEAR_TOKEN")
    }
  }
}

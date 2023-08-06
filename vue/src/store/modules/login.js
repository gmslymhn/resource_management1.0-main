export default{
  namespaced: true,
  state:{
    account: JSON.parse(sessionStorage.getItem('account')) ? JSON.parse(sessionStorage.getItem('account')) : [],
    id: JSON.parse(sessionStorage.getItem('id')) ? JSON.parse(sessionStorage.getItem('id')) : [],
    name: JSON.parse(sessionStorage.getItem('name')) ? JSON.parse(sessionStorage.getItem('name')) : [],
    role: JSON.parse(sessionStorage.getItem('role')) ? JSON.parse(sessionStorage.getItem('role')) : [],
    token: JSON.parse(sessionStorage.getItem('token')) ? JSON.parse(sessionStorage.getItem('token')) : [],
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
    SET_ACCOUNT(state, account) {
      state.account = account;
    },
    CLEAR_ACCOUNT(state) {
      state.account = null;
    },
    SET_ID(state, id) {
      state.id = id;
    },
    CLEAR_ID(state) {
      state.id = null;
    },
    SET_NAME(state, name) {
      state.name = name;
    },
    CLEAR_NAME(state) {
      state.name = null;
    },
  },
  actions:{
    setRole(context,role) {
      // 本地存储一份
      sessionStorage.setItem('role', JSON.stringify(role)) 
      context.commit("SET_ROLE",role)
    },
    clearRole(context) {
      // 本地删除
      sessionStorage.removeItem("role")
      context.commit("CLEAR_ROLE")
    },
    setToken(context,token) {
      // 本地存储一份
      sessionStorage.setItem('token', JSON.stringify(token)) 
      context.commit("SET_TOKEN",token)
    },
    clearToken(context) {
      // 本地删除
      sessionStorage.removeItem("token")
      context.commit("CLEAR_TOKEN")
    },
    setAccount(context,account) {
      // 本地存储一份
      sessionStorage.setItem('account', JSON.stringify(account)) 
      context.commit("SET_ACCOUNT",account)
    },
    clearAccount(context) {
      // 本地删除
      sessionStorage.removeItem("account")
      context.commit("CLEAR_ACCOUNT")
    },
    setId(context,id) {
      // 本地存储一份
      sessionStorage.setItem('id', JSON.stringify(id)) 
      context.commit("SET_ID",id)
    },
    clearId(context) {
      // 本地删除
      sessionStorage.removeItem("id")
      context.commit("CLEAR_ID")
    },
    setName(context,name) {
      // 本地存储一份
      sessionStorage.setItem('name', JSON.stringify(name)) 
      context.commit("SET_NAME",name)
    },
    clearName(context) {
      // 本地删除
      sessionStorage.removeItem("name")
      context.commit("CLEAR_NAME")
    }
  }
}

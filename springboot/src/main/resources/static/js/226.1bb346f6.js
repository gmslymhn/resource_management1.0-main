"use strict";(self["webpackChunkresource"]=self["webpackChunkresource"]||[]).push([[226],{4226:function(e,t,s){s.r(t),s.d(t,{default:function(){return u}});var n=function(){var e=this;e._self._c;return e._m(0)},o=[function(){var e=this,t=e._self._c;return t("div",{staticClass:"home"},[t("div",{attrs:{id:"selab"}},[t("img",{attrs:{src:s(1986)}})]),t("div",{staticClass:"title"},[t("p",[e._v("Welcome to ReManage")]),t("p",[e._v("年轻人的次世代资源管理系统")])])])}],r=s(7814),a={name:"Content-Home",data(){return{}},created(){this.$store.dispatch("style/setContent2Style","background-color: transparent !important")},mounted(){"admin"===this.$store.state.login.role&&(0,r.Z)(this)},beforeDestroy(){this.$store.dispatch("style/clearContent2Style")}},i=a,c=s(1001),l=(0,c.Z)(i,n,o,!1,null,"0fa80e01",null),u=l.exports},6481:function(e,t,s){s.d(t,{s:function(){return r}});var n=s(4974);const o="/admin/messageReminding",r=()=>n.Z.get(o+"/getMessageQuantity")},7814:function(e,t,s){var n=s(6481);async function o(e){let t=await(0,n.s)();console.log("消息查询操作-----",t);let s=t.data.code;s&&e.$notify.info({title:"消息",message:"您有待审批消息",offset:70})}t.Z=o},4974:function(e,t,s){var n=s(6154),o=s(4720);const r=n.Z.create({baseURL:"http://localhost:8080",timeout:1e4});let a;r.interceptors.request.use((e=>(a=o.Loading.service({lock:!0,text:"拼命加载中...",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),e)),(e=>Promise.reject(e))),r.interceptors.response.use((e=>(a.close(),e)),(e=>(setTimeout((()=>{a.close()}),1e3),Promise.reject(e)))),t.Z=r},1986:function(e,t,s){e.exports=s.p+"img/selab.1a3cfe94.png"}}]);
//# sourceMappingURL=226.1bb346f6.js.map
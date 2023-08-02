"use strict";(self["webpackChunkresource"]=self["webpackChunkresource"]||[]).push([[785],{6999:function(t,e,a){a.d(e,{Z:function(){return c}});var i=function(){var t=this,e=t._self._c;return e("div",[e("el-pagination",{attrs:{"current-page":t.currentPage,"page-size":t.pageSize,layout:"total, prev, pager, next, jumper",total:t.total},on:{"current-change":t.currentChange}})],1)},o=[],s={name:"CheckItems-Pagination",props:{total:{type:Number,defalut:100},pageSize:{type:Number,defalut:10}},data(){return{currentPage:1}},methods:{currentChange(t){console.log(`当前页: ${t}`),this.$emit("currentChange",t)}}},n=s,r=a(1001),l=(0,r.Z)(n,i,o,!1,null,"dbe9c99a",null),c=l.exports},4785:function(t,e,a){a.r(e),a.d(e,{default:function(){return f}});var i=function(){var t=this,e=t._self._c;return e("div",{staticClass:"checkItems"},[t._m(0),e("div",{staticClass:"checkItemsHeader"},[e("el-button",{staticClass:"itemsButton",attrs:{type:"text"},on:{click:t.itemsButton}},[t._v("添加新物品")]),e("el-input",{attrs:{size:"mini",placeholder:"物品名搜索(回车)"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.searchByGoodsNameFunc.apply(null,arguments)}},model:{value:t.searchByGoodsName,callback:function(e){t.searchByGoodsName="string"===typeof e?e.trim():e},expression:"searchByGoodsName"}})],1),e("el-dialog",{staticClass:"itemsDialog",attrs:{title:t.dialogFormVisibleTitle,visible:t.dialogFormVisible,"append-to-body":!0},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[e("el-form",{ref:"items",staticClass:"demo-ruleForm",attrs:{model:t.items,rules:t.rules,"label-width":"100px"}},[e("el-form-item",{attrs:{label:"物品名称",prop:"goodsName"}},[e("el-input",{model:{value:t.items.goodsName,callback:function(e){t.$set(t.items,"goodsName",e)},expression:"items.goodsName"}})],1),e("el-form-item",{attrs:{label:"物品状态",prop:"goodsState"}},[e("el-radio-group",{model:{value:t.items.goodsState,callback:function(e){t.$set(t.items,"goodsState",e)},expression:"items.goodsState"}},[e("el-radio",{attrs:{label:"已使用"}}),e("el-radio",{attrs:{label:"未使用"}})],1)],1),e("el-form-item",{attrs:{label:"上传图片",prop:"goodsImage"}},[e("el-upload",{staticClass:"itemsImg",attrs:{drag:"",action:"abc","list-type":"picture","on-change":t.changeFile}},[e("i",{staticClass:"el-icon-upload"}),e("div",{staticClass:"el-upload__text"},[t._v("将物品照片拖到此处，或"),e("em",[t._v("点击上传")])]),e("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])])],1)],1),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.submitButton("rules")}}},[t._v("确 定")]),e("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")])],1)],1),e("el-table",{staticClass:"itemsTable",attrs:{data:t.tableData,border:"",align:"center","header-cell-style":{"text-align":"center"}}},[e("el-table-column",{attrs:{prop:"id",label:"物品id",align:"center"}}),e("el-table-column",{attrs:{prop:"image",label:"物品照片",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[e("img",{staticStyle:{width:"80px",height:"80px"},attrs:{src:t.row.image}})]}}])}),e("el-table-column",{attrs:{prop:"name",label:"物品名称",align:"center"}}),e("el-table-column",{attrs:{prop:"state",label:"物品状态",align:"center"}}),e("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{type:"success",size:"mini"},on:{click:function(e){return t.editClick(a.$index,a.row)}}},[t._v("编辑")]),e("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(e){return t.removeClick(a.$index,a.row)}}},[t._v("删除")])]}}])})],1),e("div",{staticClass:"pagination"},[e("Pagination",{attrs:{total:t.total,totalPages:t.totalPages},on:{currentChange:t.currentChange}})],1)],1)},o=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"itemsText"},[e("p",{staticClass:"itemsTextP"},[t._v("物品展示")])])}],s=a(881),n=a(6999),r=a(9060);const l="/admin/admgoods",c=({pageNum:t,pageSize:e})=>r.Z.get(l+"/getAllGoods",{params:{pageNum:t,pageSize:e}}),m=({submitFormURL:t,goodsImage:e,formData:a})=>r.Z.post(l+`/addGoods${t}`,{uploadImage:e,goods:a},{headers:{"Content-type":"multipart/form-data"}}),u=({goodsName:t})=>r.Z.get(l+"/selectGoodsByGoodsName",{params:{goodsName:t}}),g=({goodsId:t})=>r.Z.get(l+"/deleteGoods",{params:{goodsId:t}});var d={name:"Content-CheckItems",components:{Pagination:n.Z},data(){const t=(t,e,a)=>{this.items.goodsImage?a():a(new Error("请上传图片"))};return{formLabelWidth:"120px",tableData:[{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"},{id:"001",image:"https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",state:"已使用",name:"门酱"}],dialogFormVisible:!1,dialogFormVisibleTitle:"",items:{goodsId:"",goodsName:"",goodsState:"",goodsImage:""},searchByGoodsName:"",fileList:[],rules:{goodsName:[{required:!0,message:"请输入物品名称",trigger:"blur"}],goodsState:[{required:!0,message:"请选择物品状态",trigger:"change"}],goodsImage:[{required:!0,validator:t,trigger:"change"}]},total:100,totalPages:10,pageSize:5,pageNum:1}},methods:{async getItemsList(t,e){let a=await c({pageNum:t,pageSize:e});console.log("产品列表数据-----",a.data),this.tableData=[...a.data.data],this.total=a.data.total,this.totalPages=a.data.totalPages},async postItemsEdit(t,e,a){let i=await m({submitFormURL:t,img:e,goods:a});console.log("修改/增加产品列表-----",i.data),this.getItemsList(this.pageNum)},async getItemsRemove(t){let e=await g({id:t});console.log("产品列表数据-----",e.data),200===e.data.status&&(this.$message({type:"success",message:"删除成功!"}),this.getItemsList(1,this.pageSize))},async getsearchByGoodsNameFunc(t){let e=await u({goodsName:t});console.log("上报人搜索数据-----",e.data),this.tableData=[...e.data],this.pageNum=1},currentChange(t){console.log("更新页码-----",t),this.pageNum=t,this.getItemsList(t,this.pageSize)},editClick(t,e){console.log("修改操作-----",t,e),this.dialogFormVisible=!0,this.dialogFormVisibleTitle="修改物品数据",this.items.goodsName=e.name,this.items.goodsState=e.state,this.$refs.items.validate((t=>{if(!t)return console.log("error submit!!"),!1;console.log("validate-----",this.$refs.items),this.submitForm("deleteGoods")}))},removeClick(t,e){console.log("删除操作-----",t,e),this.$confirm("此操作将删除该物品, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.getItemsRemove(e.id)})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},itemsButton(){this.dialogFormVisible=!0,this.dialogFormVisibleTitle="添加新物品",this.items.goodsName="",this.items.goodsState=""},submitButton(t){this.$refs.items.validate((t=>{if(!t)return console.log("error submit!!"),!1;console.log("validate-----",this.items),this.submitForm("addGoods")}))},changeFile(t,e){console.log(e),this.fileList=e},submitForm(t){let e=new FormData;this.items.goodsImage=this.fileList[0].raw,console.log(this.fileList[0].raw);for(let a in this.items)console.log(this.items[a]),e.append(a,this.items[a]);delete e.goodsImage,this.postItemsEdit(t,this.items.goodsImage,e)},searchByGoodsNameFunc:(0,s.Z)((function(){this.getSearchByGoodsNameFunc(this.searchByGoodsName)}),300)},created(){this.getItemsList(this.pageNum,this.pageSize)}},p=d,b=a(1001),h=(0,b.Z)(p,i,o,!1,null,"d995dae2",null),f=h.exports},881:function(t,e,a){function i(t){var e=typeof t;return null!=t&&("object"==e||"function"==e)}a.d(e,{Z:function(){return Q}});var o=i,s="object"==typeof global&&global&&global.Object===Object&&global,n=s,r="object"==typeof self&&self&&self.Object===Object&&self,l=n||r||Function("return this")(),c=l,m=function(){return c.Date.now()},u=m,g=/\s/;function d(t){var e=t.length;while(e--&&g.test(t.charAt(e)));return e}var p=d,b=/^\s+/;function h(t){return t?t.slice(0,p(t)+1).replace(b,""):t}var f=h,v=c.Symbol,y=v,w=Object.prototype,N=w.hasOwnProperty,_=w.toString,C=y?y.toStringTag:void 0;function k(t){var e=N.call(t,C),a=t[C];try{t[C]=void 0;var i=!0}catch(s){}var o=_.call(t);return i&&(e?t[C]=a:delete t[C]),o}var I=k,S=Object.prototype,x=S.toString;function z(t){return x.call(t)}var F=z,T="[object Null]",B="[object Undefined]",j=y?y.toStringTag:void 0;function G(t){return null==t?void 0===t?B:T:j&&j in Object(t)?I(t):F(t)}var $=G;function L(t){return null!=t&&"object"==typeof t}var O=L,P="[object Symbol]";function V(t){return"symbol"==typeof t||O(t)&&$(t)==P}var Z=V,D=NaN,E=/^[-+]0x[0-9a-f]+$/i,R=/^0b[01]+$/i,q=/^0o[0-7]+$/i,U=parseInt;function W(t){if("number"==typeof t)return t;if(Z(t))return D;if(o(t)){var e="function"==typeof t.valueOf?t.valueOf():t;t=o(e)?e+"":e}if("string"!=typeof t)return 0===t?t:+t;t=f(t);var a=R.test(t);return a||q.test(t)?U(t.slice(2),a?2:8):E.test(t)?D:+t}var A=W,M="Expected a function",H=Math.max,J=Math.min;function K(t,e,a){var i,s,n,r,l,c,m=0,g=!1,d=!1,p=!0;if("function"!=typeof t)throw new TypeError(M);function b(e){var a=i,o=s;return i=s=void 0,m=e,r=t.apply(o,a),r}function h(t){return m=t,l=setTimeout(y,e),g?b(t):r}function f(t){var a=t-c,i=t-m,o=e-a;return d?J(o,n-i):o}function v(t){var a=t-c,i=t-m;return void 0===c||a>=e||a<0||d&&i>=n}function y(){var t=u();if(v(t))return w(t);l=setTimeout(y,f(t))}function w(t){return l=void 0,p&&i?b(t):(i=s=void 0,r)}function N(){void 0!==l&&clearTimeout(l),m=0,i=c=s=l=void 0}function _(){return void 0===l?r:w(u())}function C(){var t=u(),a=v(t);if(i=arguments,s=this,c=t,a){if(void 0===l)return h(c);if(d)return clearTimeout(l),l=setTimeout(y,e),b(c)}return void 0===l&&(l=setTimeout(y,e)),r}return e=A(e)||0,o(a)&&(g=!!a.leading,d="maxWait"in a,n=d?H(A(a.maxWait)||0,e):n,p="trailing"in a?!!a.trailing:p),C.cancel=N,C.flush=_,C}var Q=K}}]);
//# sourceMappingURL=785.63206df9.js.map
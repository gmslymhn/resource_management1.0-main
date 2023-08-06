(self["webpackChunkresource"]=self["webpackChunkresource"]||[]).push([[241],{2170:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return v}});var a=function(){var e=this,t=e._self._c;return t("div",{staticClass:"checkItems"},[e._m(0),t("el-button",{staticClass:"itemsButton",attrs:{type:"text"},on:{click:e.itemsButton}},[e._v("添加新物品")]),t("el-dialog",{staticClass:"itemsDialog",attrs:{title:e.dialogFormVisibleTitle,visible:e.dialogFormVisibleAdd,"append-to-body":!0},on:{"update:visible":function(t){e.dialogFormVisibleAdd=t}}},[t("el-form",{ref:"items",staticClass:"demo-ruleForm",attrs:{model:e.items,rules:e.rules,"label-width":"100px"}},[t("el-form-item",{attrs:{label:"物品名称",prop:"goodsName"}},[t("el-input",{model:{value:e.items.goodsName,callback:function(t){e.$set(e.items,"goodsName",t)},expression:"items.goodsName"}})],1),t("el-form-item",{attrs:{label:"物品数量",prop:"goodsQuantity"}},[t("el-input",{model:{value:e.items.goodsQuantity,callback:function(t){e.$set(e.items,"goodsQuantity",e._n(t))},expression:"items.goodsQuantity"}})],1),t("el-form-item",{attrs:{label:"物品状态",prop:"goodsState"}},[t("el-radio-group",{model:{value:e.items.goodsState,callback:function(t){e.$set(e.items,"goodsState",t)},expression:"items.goodsState"}},[t("el-radio",{attrs:{label:"未损坏"}}),t("el-radio",{attrs:{label:"已损坏"}})],1)],1),t("el-form-item",{attrs:{label:"上传图片",prop:"goodsImage"}},[t("el-upload",{staticClass:"itemsImg",attrs:{drag:"","auto-upload":!1,limit:1,action:"null","list-type":"picture","on-change":e.changeFile}},[t("i",{staticClass:"el-icon-upload"}),t("div",{staticClass:"el-upload__text"},[e._v("将物品照片拖到此处，或"),t("em",[e._v("点击上传")])]),t("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传jpg/png文件，且不超过500kb")])])],1)],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitButton("items")}}},[e._v("确 定")]),t("el-button",{on:{click:function(t){e.dialogFormVisibleAdd=!1}}},[e._v("取 消")])],1)],1),t("el-dialog",{staticClass:"itemsDialog",attrs:{title:"上报",visible:e.dialogFormVisibleReported,"append-to-body":!0},on:{"update:visible":function(t){e.dialogFormVisibleReported=t}}},[t("el-form",{ref:"report",staticClass:"demo-ruleForm",attrs:{model:e.report,rules:e.rules}},[t("el-form-item",{attrs:{label:"上报人id",prop:"reportNameId"}},[t("el-input",{attrs:{disabled:!0},model:{value:e.report.reportNameId,callback:function(t){e.$set(e.report,"reportNameId",t)},expression:"report.reportNameId"}})],1),t("el-form-item",{attrs:{label:"上报人姓名",prop:"reportName"}},[t("el-input",{attrs:{disabled:!0},model:{value:e.report.reportName,callback:function(t){e.$set(e.report,"reportName",e._n(t))},expression:"report.reportName"}})],1),t("el-form-item",{attrs:{label:"物品id",prop:"goodsId"}},[t("el-input",{attrs:{disabled:!0},model:{value:e.report.goodsId,callback:function(t){e.$set(e.report,"goodsId",e._n(t))},expression:"report.goodsId"}})],1),t("el-form-item",{attrs:{label:"损坏描述",prop:"damageDescription"}},[t("el-input",{attrs:{type:"textarea"},model:{value:e.report.damageDescription,callback:function(t){e.$set(e.report,"damageDescription",t)},expression:"report.damageDescription"}})],1),t("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitFormReport("rules")}}},[e._v("上 报")])],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.dialogFormVisibleReported=!1}}},[e._v("关 闭")])],1)],1),t("div",{staticClass:"checkItemsInner"},[t("div",{staticClass:"checkItemsInnerHeader"},[t("div",{staticClass:"inputDiv"},[t("el-input",{attrs:{size:"mini",placeholder:"物品名搜索(回车)"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchByGoodsNameFunc.apply(null,arguments)}},model:{value:e.searchByGoodsName,callback:function(t){e.searchByGoodsName="string"===typeof t?t.trim():t},expression:"searchByGoodsName"}})],1),t("div",{staticClass:"inputDiv"},[t("el-input",{attrs:{size:"mini",placeholder:"物品id搜索(回车)"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchByGoodsIdFunc.apply(null,arguments)}},model:{value:e.searchByGoodsId,callback:function(t){e.searchByGoodsId=t},expression:"searchByGoodsId"}})],1),t("el-button",{staticClass:"seeAll",attrs:{type:"primary",round:""},on:{click:e.seeAll}},[e._v("查看全部")])],1),t("el-table",{staticClass:"itemsTable",attrs:{data:e.tableData,border:"",align:"center","header-cell-style":{"text-align":"center"}}},[t("el-table-column",{attrs:{width:"100px",prop:"goodsId",label:"物品id",align:"center"}}),t("el-table-column",{attrs:{prop:"goodsImage",label:"物品照片",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[t("img",{staticStyle:{width:"200px","max-height":"200px","object-fit":"contain"},attrs:{src:e.row.goodsImage}})]}}])}),t("el-table-column",{attrs:{width:"100px",prop:"goodsName",label:"物品名称",align:"center"}}),t("el-table-column",{attrs:{prop:"goodsState",label:"物品状态",align:"center"}}),t("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function(o){return[t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.damageReportFromItems(o.$index,o.row)}}},[e._v("损坏上报")])]}}])})],1)],1),t("div",{staticClass:"pagination"},[t("Pagination",{attrs:{total:e.total,pageSize:e.pageSize,totalPages:e.totalPages},on:{currentChange:e.currentChange}})],1)],1)},s=[function(){var e=this,t=e._self._c;return t("div",{staticClass:"itemsText"},[t("p",{staticClass:"itemsTextP"},[e._v("物品展示")])])}],r=(o(6229),o(7330),o(2062),o(4615)),i=o(4458),n=o(7814),l=o(4974),d=o(129),g=o.n(d);const p="/user/usegoods",m=({pageNum:e,pageSize:t})=>l.Z.post(p+"/getAllGoods",g().stringify({pageNum:e,pageSize:t}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}},{responseType:"arraybuffer"}),u=({goodsId:e})=>l.Z.post(p+"/selectGoodsById",g().stringify({goodsId:e}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}},{responseType:"arraybuffer"}),c=({pageNum:e,pageSize:t,goodsName:o})=>l.Z.post(p+"/selectGoodsByGoodsName",g().stringify({pageNum:e,pageSize:t,goodsName:o}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}},{responseType:"arraybuffer"});var h=o(454),f=o(7008),y={goodsName:"Content-CheckItems",components:{Pagination:i.Z},data(){return{formLabelWidth:"120px",tableData:[],dialogFormVisibleAdd:!1,dialogFormVisibleTitle:"",items:{goodsId:"",goodsName:"",goodsQuantity:"",goodsState:"",goodsImage:""},report:{reportNameId:"",reportName:"",goodsId:"",damageDescription:""},searchByGoodsName:"",searchByGoodsId:"",dialogFormVisibleReported:!1,fileList:[],rules:{goodsName:[{required:!0,message:"请输入物品名称",trigger:"blur"}],goodsQuantity:[{required:!0,message:"请输入物品数量",trigger:"blur"}],goodsState:[{required:!0,message:"请选择物品状态",trigger:"change"}],goodsImage:[{required:!0,message:"请上传图片",trigger:"change"}]},total:0,totalPages:10,pageSize:5,pageNum:1}},methods:{async getItemsList(e,t){let o=await m({pageNum:e,pageSize:t});console.log("产品列表数据-----",o),o.data&&(this.tableData=[...o.data.data.list],this.total=o.data.data.total,this.totalPages=o.data.totalPages)},async postItemsAdd(e,t){let o=await(0,h.lt)({img:e,goods:t});console.log("增加产品列表-----",o),201===o.status&&(this.$message({type:"success",message:"添加成功咯!"}),this.dialogFormVisibleAdd=!1,this.getItemsList(1,this.pageNum))},async postDamageReported(e){let t=await(0,f.K$)({items:e});console.log("上报提交-----",t),201===t.status&&(this.$message({type:"success",message:"上报成功咯!"}),this.dialogFormVisibleReported=!1,this.report.goodsId="",this.report.damageDescription="",this.getItemsList(1,this.pageSize))},async getSearchByGoodsNameFunc(e,t,o){let a=await c({pageNum:e,pageSize:t,goodsName:o});console.log("上报人搜索数据-----",a),Array.isArray(a.data.data.list)&&a.data.data.list.length&&(this.tableData=[...a.data.data.list],this.tableData.forEach(((e,t)=>{e.goodsImage="data:image/png;base64,"+a.data.responseEntityList[t].body})),this.total=a.data.data.total,this.totalPages=a.data.totalPages,this.pageNum=1)},async getSearchByGoodsIdFunc(e){let t=await u({goodsId:e});console.log("物品id搜索数据-----",t),Array.isArray(t.data.data.list)&&t.data.data.list.length&&(this.tableData=[...t.data.data.list],this.tableData.forEach(((e,o)=>{e.goodsImage="data:image/png;base64,"+t.data.responseEntityList[o].body})),this.total=1,this.totalPages=1,this.pageNum=1)},currentChange(e){console.log("更新页码-----",e),this.pageNum=e,this.getItemsList(e,this.pageSize)},damageReportFromItems(e,t){console.log("上报弹窗展开",e,t),this.dialogFormVisibleReported=!0,this.report.goodsId=t.goodsId},submitFormReport(){this.$refs.report.validate((e=>{if(!e)return console.log("error submit!!"),!1;console.log("上报提交按钮-----",this.report),this.postDamageReported(this.report)}))},itemsButton(){this.dialogFormVisibleAdd=!0,this.dialogFormVisibleTitle="添加新物品",this.items.goodsName="",this.items.goodsState="",this.items.goodsQuantity=""},submitButton(){this.$refs.items.validate((e=>{if(!e)return console.log("error submit!!"),!1;console.log("提交新物品操作-----",this.items),this.submitFormAdd()}))},changeFile(e,t){const o="image/jpg"===e.type||"image/png"===e.type,a=e.size/1024/1024<2;o||this.$message.error("上传图片只能为jpg或png格式"),a||this.$message.error("上传图片大小不能超过2MB"),this.items.goodsImage=URL.createObjectURL(e.raw),this.fileList=t},submitFormAdd(){let e=new FormData;this.items.goodsImage=this.fileList[0].raw,e.append("uploadImage",this.fileList[0].raw),e.append("goodsName",this.items.goodsName),e.append("goodsState",this.items.goodsState),e.append("goodsQuantity",this.items.goodsQuantity),console.log("formData的uploadImage",e.get("uploadImage")),this.postItemsAdd(e)},searchByGoodsNameFunc:(0,r.Z)((function(){this.searchByGoodsName&&(console.log("我要搜索咯-----",this.searchByGoodsName),this.getSearchByGoodsNameFunc(this.pageNum,this.pageSize,this.searchByGoodsName))}),300),searchByGoodsIdFunc:(0,r.Z)((function(){this.searchByGoodsId&&(console.log("我要搜索咯-----",this.searchByGoodsId),this.getSearchByGoodsIdFunc(this.searchByGoodsId))}),300),seeAll(){this.getItemsList(1,this.pageSize),this.searchByGoodsName="",this.searchByGoodsId=""}},created(){this.getItemsList(1,this.pageSize)},mounted(){(0,n.Z)(this),this.report.reportName=this.$store.state.login.name,this.report.reportNameId=Number(this.$store.state.login.id)}},b=y,I=o(1001),N=(0,I.Z)(b,a,s,!1,null,"b14b9616",null),v=N.exports},648:function(e,t,o){var a=o(1694),s=o(614),r=o(4326),i=o(5112),n=i("toStringTag"),l=Object,d="Arguments"==r(function(){return arguments}()),g=function(e,t){try{return e[t]}catch(o){}};e.exports=a?r:function(e){var t,o,a;return void 0===e?"Undefined":null===e?"Null":"string"==typeof(o=g(t=l(e),n))?o:d?r(t):"Object"==(a=r(t))&&s(t.callee)?"Arguments":a}},7045:function(e,t,o){var a=o(6339),s=o(3070);e.exports=function(e,t,o){return o.get&&a(o.get,t,{getter:!0}),o.set&&a(o.set,t,{setter:!0}),s.f(e,t,o)}},1694:function(e,t,o){var a=o(5112),s=a("toStringTag"),r={};r[s]="z",e.exports="[object z]"===String(r)},1340:function(e,t,o){var a=o(648),s=String;e.exports=function(e){if("Symbol"===a(e))throw TypeError("Cannot convert a Symbol value to a string");return s(e)}},8053:function(e){var t=TypeError;e.exports=function(e,o){if(e<o)throw t("Not enough arguments");return e}},6229:function(e,t,o){"use strict";var a=o(8052),s=o(1702),r=o(1340),i=o(8053),n=URLSearchParams,l=n.prototype,d=s(l.append),g=s(l["delete"]),p=s(l.forEach),m=s([].push),u=new n("a=1&a=2");u["delete"]("a",1),u+""!=="a=2"&&a(l,"delete",(function(e){var t=arguments.length,o=t<2?void 0:arguments[1];if(t&&void 0===o)return g(this,e);var a=[];p(this,(function(e,t){m(a,{key:t,value:e})})),i(t,1);var s,n=r(e),l=r(o),u=0,c=0,h=!1,f=a.length;while(u<f)s=a[u++],h||s.key===n?(h=!0,g(this,s.key)):c++;while(c<f)s=a[c++],s.key===n&&s.value===l||d(this,s.key,s.value)}),{enumerable:!0,unsafe:!0})},7330:function(e,t,o){"use strict";var a=o(8052),s=o(1702),r=o(1340),i=o(8053),n=URLSearchParams,l=n.prototype,d=s(l.getAll),g=s(l.has),p=new n("a=1");p.has("a",2)&&a(l,"has",(function(e){var t=arguments.length,o=t<2?void 0:arguments[1];if(t&&void 0===o)return g(this,e);var a=d(this,e);i(t,1);var s=r(o),n=0;while(n<a.length)if(a[n++]===s)return!0;return!1}),{enumerable:!0,unsafe:!0})},2062:function(e,t,o){"use strict";var a=o(9781),s=o(1702),r=o(7045),i=URLSearchParams.prototype,n=s(i.forEach);a&&!("size"in i)&&r(i,"size",{get:function(){var e=0;return n(this,(function(){e++})),e},configurable:!0,enumerable:!0})},7008:function(e,t,o){"use strict";o.d(t,{Hv:function(){return i},K$:function(){return n},nq:function(){return l},up:function(){return r}});var a=o(4974);o(129);const s="/user/useReport",r=({pageNum:e,pageSize:t})=>a.Z.get(s+"/getALLReport",{params:{pageNum:e,pageSize:t}}),i=({pageNum:e,pageSize:t,reportName:o})=>a.Z.get(s+"/selectByReportName",{params:{pageNum:e,pageSize:t,reportName:o}}),n=({items:e})=>a.Z.get(s+"/addReport",{params:{reportNameId:e.reportNameId,reportName:e.reportName,goodsId:e.goodsId,damageDescription:e.damageDescription}}),l=({sequenceId:e})=>a.Z.get(s+"/deleteReport",{params:{sequenceId:e}})},454:function(e,t,o){"use strict";o.d(t,{S_:function(){return g},aU:function(){return n},lt:function(){return l},qQ:function(){return m},xg:function(){return d},zw:function(){return p}});var a=o(4974),s=o(129),r=o.n(s);const i="/admin/admgoods",n=({pageNum:e,pageSize:t})=>a.Z.post(i+"/getAllGoods",r().stringify({pageNum:e,pageSize:t}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}},{responseType:"arraybuffer"}),l=({formData:e})=>a.Z.post(i+"/addGoods",{uploadImage:e.get("uploadImage"),goodsName:e.get("goodsName"),goodsQuantity:e.get("goodsQuantity"),goodsState:e.get("goodsState")},{headers:{"Content-type":"multipart/form-data"}}),d=({formData:e})=>a.Z.post(i+"/updateGoods",{uploadImage:e.get("uploadImage"),goodsId:e.get("goodsId"),goodsName:e.get("goodsName"),goodsState:e.get("goodsState")},{headers:{"Content-type":"multipart/form-data"}}),g=({pageNum:e,pageSize:t,goodsName:o})=>a.Z.post(i+"/selectGoodsByGoodsName",r().stringify({pageNum:e,pageSize:t,goodsName:o}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}},{responseType:"arraybuffer"}),p=({goodsId:e})=>a.Z.post(i+"/selectGoodsById",r().stringify({goodsId:e}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}},{responseType:"arraybuffer"}),m=({goodsId:e})=>a.Z.get(i+"/deleteGoods",{params:{goodsId:e}})}}]);
//# sourceMappingURL=241.aa6b156a.js.map
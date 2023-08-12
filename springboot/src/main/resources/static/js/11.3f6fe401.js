(self["webpackChunkresource"]=self["webpackChunkresource"]||[]).push([[11],{2403:function(e,t,r){"use strict";r.r(t),r.d(t,{default:function(){return h}});var a=function(){var e=this,t=e._self._c;return t("div",{staticClass:"damageReported"},[e._m(0),t("div",{staticClass:"damageReportedInner"},[[t("div",{staticClass:"damageReportedInnerHeader"},[t("el-button",{on:{click:e.clearFilter}},[e._v("重置状态筛选")]),t("el-input",{attrs:{size:"mini",placeholder:"上报人搜索(回车)"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchByReportNameFuncButton.apply(null,arguments)}},model:{value:e.searchByReportName,callback:function(t){e.searchByReportName="string"===typeof t?t.trim():t},expression:"searchByReportName"}}),t("el-button",{staticClass:"seeAll",attrs:{type:"primary",round:""},on:{click:e.seeAll}},[e._v("查看全部")])],1),t("el-table",{ref:"filterTable",staticClass:"itemsTable",staticStyle:{width:"100%"},attrs:{data:e.tableData}},[t("el-table-column",{attrs:{width:"100px",align:"center",prop:"sequenceId",label:"上报信息id"}}),t("el-table-column",{attrs:{width:"160px",align:"center",prop:"reportTime",label:"上报时间",sortable:"","column-key":"reportTime"}}),t("el-table-column",{attrs:{width:"100px",align:"center",prop:"reportName",label:"上报人"}}),t("el-table-column",{attrs:{width:"100px",align:"center",prop:"goodsId",label:"物品id"}}),t("el-table-column",{attrs:{width:"100px",align:"center",prop:"goodsName",label:"物品名称",formatter:e.formatter}}),t("el-table-column",{attrs:{align:"center",prop:"damageDescription",label:"损坏描述"}}),t("el-table-column",{attrs:{width:"100px",align:"center",prop:"goodsState",label:"状态",filters:[{text:"未处理",value:"未处理"},{text:"已处理",value:"已处理"}],"filter-method":e.filterTag,"filter-placement":"bottom-end"},scopedSlots:e._u([{key:"default",fn:function(r){return[t("el-tag",{attrs:{type:"未处理"===r.row.goodsState?"info":"success","disable-transitions":""}},[e._v(e._s(r.row.goodsState))])]}}])}),t("el-table-column",{attrs:{width:"160px",align:"center",prop:"processTime",label:"处理时间",sortable:"","column-key":"processTime"}}),t("el-table-column",{attrs:{width:"100px",align:"center",prop:"disposeName",label:"处理人"}}),e.userSearchSelf?t("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(r){return[t("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleDelete(r.$index,r.row)}}},[e._v("删除")])]}}],null,!1,3778300450)}):e._e()],1)]],2),t("el-dialog",{staticClass:"itemsDialog",attrs:{title:"上报",visible:e.dialogFormVisible,"append-to-body":!0},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[t("el-form",{ref:"items",staticClass:"demo-ruleForm",attrs:{model:e.items,rules:e.rules}},[t("el-form-item",{attrs:{label:"上报人id",prop:"reportNameId"}},[t("el-input",{attrs:{disabled:!0},model:{value:e.items.reportNameId,callback:function(t){e.$set(e.items,"reportNameId",t)},expression:"items.reportNameId"}})],1),t("el-form-item",{attrs:{label:"上报人姓名",prop:"reportName"}},[t("el-input",{attrs:{disabled:!0},model:{value:e.items.reportName,callback:function(t){e.$set(e.items,"reportName",e._n(t))},expression:"items.reportName"}})],1),t("el-form-item",{attrs:{label:"物品id",prop:"goodsId"}},[t("el-input",{model:{value:e.items.goodsId,callback:function(t){e.$set(e.items,"goodsId",e._n(t))},expression:"items.goodsId"}})],1),t("el-form-item",{attrs:{label:"损坏描述",prop:"damageDescription"}},[t("el-input",{attrs:{type:"textarea"},model:{value:e.items.damageDescription,callback:function(t){e.$set(e.items,"damageDescription",t)},expression:"items.damageDescription"}})],1),t("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("rules")}}},[e._v("上 报")])],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("关 闭")])],1)],1),t("div",{staticClass:"pagination"},[t("Pagination",{attrs:{total:e.total,totalPages:e.totalPages},on:{currentChange:e.currentChange}})],1)],1)},s=[function(){var e=this,t=e._self._c;return t("div",{staticClass:"itemsText"},[t("p",{staticClass:"itemsTextP"},[e._v("物品损坏上报")])])}],n=r(4615),i=r(4458),o=r(7008),u=r(7484),l=r.n(u),c={name:"Content-DamageReported",components:{Pagination:i.Z},data(){return{tableData:[],items:{reportNameId:"",reportName:"",goodsId:"",damageDescription:""},searchByReportName:"",total:0,totalPages:10,pageSize:10,pageNum:1,dialogFormVisible:!1,userSearchSelf:!1,rules:{goodsId:[{required:!0,message:"请输入物品id",trigger:"blur"}],goodsName:[{required:!0,message:"请输入物品名称",trigger:"blur"}],damageDescription:[{required:!0,message:"请输入损坏描述",trigger:"blur"}]}}},methods:{async getReportList(e,t){let r=await(0,o.up)({pageNum:e,pageSize:t});console.log("上报列表数据-----",r),r.data?(this.tableData=[...r.data.data.list],this.total=r.data.data.total,this.totalPages=r.data.data.pages,this.tableData.forEach((e=>{e.reportTime=l()(e.reportTime).format("YYYY-MM-DD HH:mm:ss")})),this.tableData.forEach((e=>{e.processTime=l()(e.processTime).format("YYYY-MM-DD HH:mm:ss")}))):(this.tableData=[],this.total=0,this.totalPages=0)},async getSearchByReportNameFunc(e,t,r){let a=await(0,o.Hv)({pageNum:e,pageSize:t,reportName:r});console.log("上报人搜索数据-----",a),a.data?(this.tableData=[...a.data.data.list],this.total=a.data.data.total,this.totalPages=a.data.data.pages,this.tableData.forEach((e=>{e.reportTime=l()(e.reportTime).format("YYYY-MM-DD HH:mm:ss")})),this.tableData.forEach((e=>{e.processTime=l()(e.processTime).format("YYYY-MM-DD HH:mm:ss")}))):(this.tableData=[],this.total=0,this.totalPages=0)},async getDeleteGoods(e){let t=await(0,o.nq)({sequenceId:e});console.log("删除数据-----",t),200===t.status&&(this.$message({type:"success",message:"删除成功咯!"}),this.getReportList(1,this.pageSize))},searchByReportNameFuncButton:(0,n.Z)((function(){this.searchByReportName&&(this.getSearchByReportNameFunc(this.pageNum,this.pageSize,this.searchByReportName),this.reportName===this.$store.state.login.name?this.userSearchSelf=!0:this.userSearchSelf=!1)}),300),seeAll(){this.getReportList(1,this.pageSize),this.searchByReportName="",this.searchByDisposeName=""},handleDelete(e,t){this.$confirm("此操作将删除该上报数据, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.getDeleteGoods(t.sequenceId)})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},currentChange(e){console.log("更新页码-----",e),this.pageNum=e,this.getReportList(e,this.pageSize)},formatter(e,t){return e.goodsName},filterTag(e,t){return t.goodsState===e},clearFilter(){this.$refs.filterTable.clearFilter()}},created(){this.getReportList(this.pageNum,this.pageSize)},mounted(){this.items.reportName=this.$store.state.login.name,this.items.reportNameId=Number(this.$store.state.login.id)}},d=c,m=r(1001),p=(0,m.Z)(d,a,s,!1,null,"d1d37e98",null),h=p.exports},7484:function(e){!function(t,r){e.exports=r()}(0,(function(){"use strict";var e=1e3,t=6e4,r=36e5,a="millisecond",s="second",n="minute",i="hour",o="day",u="week",l="month",c="quarter",d="year",m="date",p="Invalid Date",h=/^(\d{4})[-/]?(\d{1,2})?[-/]?(\d{0,2})[Tt\s]*(\d{1,2})?:?(\d{1,2})?:?(\d{1,2})?[.:]?(\d+)?$/,f=/\[([^\]]+)]|Y{1,4}|M{1,4}|D{1,2}|d{1,4}|H{1,2}|h{1,2}|a|A|m{1,2}|s{1,2}|Z{1,2}|SSS/g,g={name:"en",weekdays:"Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_"),months:"January_February_March_April_May_June_July_August_September_October_November_December".split("_"),ordinal:function(e){var t=["th","st","nd","rd"],r=e%100;return"["+e+(t[(r-20)%10]||t[r]||t[0])+"]"}},$=function(e,t,r){var a=String(e);return!a||a.length>=t?e:""+Array(t+1-a.length).join(r)+e},b={s:$,z:function(e){var t=-e.utcOffset(),r=Math.abs(t),a=Math.floor(r/60),s=r%60;return(t<=0?"+":"-")+$(a,2,"0")+":"+$(s,2,"0")},m:function e(t,r){if(t.date()<r.date())return-e(r,t);var a=12*(r.year()-t.year())+(r.month()-t.month()),s=t.clone().add(a,l),n=r-s<0,i=t.clone().add(a+(n?-1:1),l);return+(-(a+(r-s)/(n?s-i:i-s))||0)},a:function(e){return e<0?Math.ceil(e)||0:Math.floor(e)},p:function(e){return{M:l,y:d,w:u,d:o,D:m,h:i,m:n,s:s,ms:a,Q:c}[e]||String(e||"").toLowerCase().replace(/s$/,"")},u:function(e){return void 0===e}},y="en",D={};D[y]=g;var v=function(e){return e instanceof w},S=function e(t,r,a){var s;if(!t)return y;if("string"==typeof t){var n=t.toLowerCase();D[n]&&(s=n),r&&(D[n]=r,s=n);var i=t.split("-");if(!s&&i.length>1)return e(i[0])}else{var o=t.name;D[o]=t,s=o}return!a&&s&&(y=s),s||!a&&y},N=function(e,t){if(v(e))return e.clone();var r="object"==typeof t?t:{};return r.date=e,r.args=arguments,new w(r)},M=b;M.l=S,M.i=v,M.w=function(e,t){return N(e,{locale:t.$L,utc:t.$u,x:t.$x,$offset:t.$offset})};var w=function(){function g(e){this.$L=S(e.locale,null,!0),this.parse(e)}var $=g.prototype;return $.parse=function(e){this.$d=function(e){var t=e.date,r=e.utc;if(null===t)return new Date(NaN);if(M.u(t))return new Date;if(t instanceof Date)return new Date(t);if("string"==typeof t&&!/Z$/i.test(t)){var a=t.match(h);if(a){var s=a[2]-1||0,n=(a[7]||"0").substring(0,3);return r?new Date(Date.UTC(a[1],s,a[3]||1,a[4]||0,a[5]||0,a[6]||0,n)):new Date(a[1],s,a[3]||1,a[4]||0,a[5]||0,a[6]||0,n)}}return new Date(t)}(e),this.$x=e.x||{},this.init()},$.init=function(){var e=this.$d;this.$y=e.getFullYear(),this.$M=e.getMonth(),this.$D=e.getDate(),this.$W=e.getDay(),this.$H=e.getHours(),this.$m=e.getMinutes(),this.$s=e.getSeconds(),this.$ms=e.getMilliseconds()},$.$utils=function(){return M},$.isValid=function(){return!(this.$d.toString()===p)},$.isSame=function(e,t){var r=N(e);return this.startOf(t)<=r&&r<=this.endOf(t)},$.isAfter=function(e,t){return N(e)<this.startOf(t)},$.isBefore=function(e,t){return this.endOf(t)<N(e)},$.$g=function(e,t,r){return M.u(e)?this[t]:this.set(r,e)},$.unix=function(){return Math.floor(this.valueOf()/1e3)},$.valueOf=function(){return this.$d.getTime()},$.startOf=function(e,t){var r=this,a=!!M.u(t)||t,c=M.p(e),p=function(e,t){var s=M.w(r.$u?Date.UTC(r.$y,t,e):new Date(r.$y,t,e),r);return a?s:s.endOf(o)},h=function(e,t){return M.w(r.toDate()[e].apply(r.toDate("s"),(a?[0,0,0,0]:[23,59,59,999]).slice(t)),r)},f=this.$W,g=this.$M,$=this.$D,b="set"+(this.$u?"UTC":"");switch(c){case d:return a?p(1,0):p(31,11);case l:return a?p(1,g):p(0,g+1);case u:var y=this.$locale().weekStart||0,D=(f<y?f+7:f)-y;return p(a?$-D:$+(6-D),g);case o:case m:return h(b+"Hours",0);case i:return h(b+"Minutes",1);case n:return h(b+"Seconds",2);case s:return h(b+"Milliseconds",3);default:return this.clone()}},$.endOf=function(e){return this.startOf(e,!1)},$.$set=function(e,t){var r,u=M.p(e),c="set"+(this.$u?"UTC":""),p=(r={},r[o]=c+"Date",r[m]=c+"Date",r[l]=c+"Month",r[d]=c+"FullYear",r[i]=c+"Hours",r[n]=c+"Minutes",r[s]=c+"Seconds",r[a]=c+"Milliseconds",r)[u],h=u===o?this.$D+(t-this.$W):t;if(u===l||u===d){var f=this.clone().set(m,1);f.$d[p](h),f.init(),this.$d=f.set(m,Math.min(this.$D,f.daysInMonth())).$d}else p&&this.$d[p](h);return this.init(),this},$.set=function(e,t){return this.clone().$set(e,t)},$.get=function(e){return this[M.p(e)]()},$.add=function(a,c){var m,p=this;a=Number(a);var h=M.p(c),f=function(e){var t=N(p);return M.w(t.date(t.date()+Math.round(e*a)),p)};if(h===l)return this.set(l,this.$M+a);if(h===d)return this.set(d,this.$y+a);if(h===o)return f(1);if(h===u)return f(7);var g=(m={},m[n]=t,m[i]=r,m[s]=e,m)[h]||1,$=this.$d.getTime()+a*g;return M.w($,this)},$.subtract=function(e,t){return this.add(-1*e,t)},$.format=function(e){var t=this,r=this.$locale();if(!this.isValid())return r.invalidDate||p;var a=e||"YYYY-MM-DDTHH:mm:ssZ",s=M.z(this),n=this.$H,i=this.$m,o=this.$M,u=r.weekdays,l=r.months,c=r.meridiem,d=function(e,r,s,n){return e&&(e[r]||e(t,a))||s[r].slice(0,n)},m=function(e){return M.s(n%12||12,e,"0")},h=c||function(e,t,r){var a=e<12?"AM":"PM";return r?a.toLowerCase():a};return a.replace(f,(function(e,a){return a||function(e){switch(e){case"YY":return String(t.$y).slice(-2);case"YYYY":return M.s(t.$y,4,"0");case"M":return o+1;case"MM":return M.s(o+1,2,"0");case"MMM":return d(r.monthsShort,o,l,3);case"MMMM":return d(l,o);case"D":return t.$D;case"DD":return M.s(t.$D,2,"0");case"d":return String(t.$W);case"dd":return d(r.weekdaysMin,t.$W,u,2);case"ddd":return d(r.weekdaysShort,t.$W,u,3);case"dddd":return u[t.$W];case"H":return String(n);case"HH":return M.s(n,2,"0");case"h":return m(1);case"hh":return m(2);case"a":return h(n,i,!0);case"A":return h(n,i,!1);case"m":return String(i);case"mm":return M.s(i,2,"0");case"s":return String(t.$s);case"ss":return M.s(t.$s,2,"0");case"SSS":return M.s(t.$ms,3,"0");case"Z":return s}return null}(e)||s.replace(":","")}))},$.utcOffset=function(){return 15*-Math.round(this.$d.getTimezoneOffset()/15)},$.diff=function(a,m,p){var h,f=this,g=M.p(m),$=N(a),b=($.utcOffset()-this.utcOffset())*t,y=this-$,D=function(){return M.m(f,$)};switch(g){case d:h=D()/12;break;case l:h=D();break;case c:h=D()/3;break;case u:h=(y-b)/6048e5;break;case o:h=(y-b)/864e5;break;case i:h=y/r;break;case n:h=y/t;break;case s:h=y/e;break;default:h=y}return p?h:M.a(h)},$.daysInMonth=function(){return this.endOf(l).$D},$.$locale=function(){return D[this.$L]},$.locale=function(e,t){if(!e)return this.$L;var r=this.clone(),a=S(e,t,!0);return a&&(r.$L=a),r},$.clone=function(){return M.w(this.$d,this)},$.toDate=function(){return new Date(this.valueOf())},$.toJSON=function(){return this.isValid()?this.toISOString():null},$.toISOString=function(){return this.$d.toISOString()},$.toString=function(){return this.$d.toUTCString()},g}(),_=w.prototype;return N.prototype=_,[["$ms",a],["$s",s],["$m",n],["$H",i],["$W",o],["$M",l],["$y",d],["$D",m]].forEach((function(e){_[e[1]]=function(t){return this.$g(t,e[0],e[1])}})),N.extend=function(e,t){return e.$i||(e(t,w,N),e.$i=!0),N},N.locale=S,N.isDayjs=v,N.unix=function(e){return N(1e3*e)},N.en=D[y],N.Ls=D,N.p={},N}))},7008:function(e,t,r){"use strict";r.d(t,{Hv:function(){return i},K$:function(){return o},nq:function(){return u},up:function(){return n}});var a=r(4974);r(129);const s="/user/useReport",n=({pageNum:e,pageSize:t})=>a.Z.get(s+"/getALLReport",{params:{pageNum:e,pageSize:t}}),i=({pageNum:e,pageSize:t,reportName:r})=>a.Z.get(s+"/selectByReportName",{params:{pageNum:e,pageSize:t,reportName:r}}),o=({items:e})=>a.Z.get(s+"/addReport",{params:{reportNameId:e.reportNameId,reportName:e.reportName,goodsId:e.goodsId,damageDescription:e.damageDescription}}),u=({sequenceId:e})=>a.Z.get(s+"/deleteReport",{params:{sequenceId:e}})}}]);
//# sourceMappingURL=11.3f6fe401.js.map
(self["webpackChunkresource"]=self["webpackChunkresource"]||[]).push([[335],{3335:function(t,e,s){"use strict";s.r(e),s.d(e,{default:function(){return h}});var a=function(){var t=this,e=t._self._c;return e("div",{staticClass:"damageReported"},[t._m(0),e("div",{attrs:{id:"totalAsstes1"}},[t._v("总资产："+t._s(t.totalAssets+"￥"))]),e("div",{attrs:{id:"totalAsstes2"}},[t._v("可支配资产："+t._s(t.disposableAssets+"￥"))]),e("div",{attrs:{id:"button_search"}},[e("el-radio",{attrs:{label:"1"},model:{value:t.radio,callback:function(e){t.radio=e},expression:"radio"}},[t._v("通过id查询日志")]),e("el-radio",{attrs:{label:"2"},model:{value:t.radio,callback:function(e){t.radio=e},expression:"radio"}},[t._v("通过用户姓名查询日志")]),e("br"),e("el-input",{staticStyle:{width:"330px"},attrs:{placeholder:"请输入内容"},model:{value:t.logsFind,callback:function(e){t.logsFind=e},expression:"logsFind"}})],1),e("el-row",{staticStyle:{position:"absolute",left:"60%",top:"240px"}},[e("el-button",{attrs:{type:"danger",round:""},on:{click:t.findAllLogs}},[t._v("查询所有日志")])],1),e("div",{attrs:{id:"tabledata"}},[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.newTableData,border:""}},[e("el-table-column",{attrs:{fixed:"",prop:"assetsLogId",label:"日志id",width:"150"}}),e("el-table-column",{attrs:{prop:"userName",label:"用户姓名",width:"120"}}),e("el-table-column",{attrs:{prop:"beforeAssets",label:"已有资产",width:"120"}}),e("el-table-column",{attrs:{prop:"changeAssets",label:"消耗资产",width:"120"}}),e("el-table-column",{attrs:{prop:"afterAssets",label:"花费后资产",width:"120"}}),e("el-table-column",{attrs:{prop:"description",label:"描述",width:"300"}}),e("el-table-column",{attrs:{prop:"processTime",label:"处理时间",width:"180"}}),e("el-table-column",{attrs:{fixed:"right",label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(s){return[e("el-button",{attrs:{type:"text",size:"small"},on:{click:function(e){return t.handleClick1(s.row)}}},[t._v("删除")]),e("el-button",{attrs:{type:"text",size:"small"},on:{click:function(e){return t.handleClick2(s.row)}}},[t._v("修改")])]}}])})],1)],1)],1)},r=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"itemsText"},[e("p",{staticClass:"itemsTextP"},[t._v("资金日志")])])}],n=s(7484),i=s.n(n),o=s(6154),u={name:"Content-DamageReported",data(){return{totalAssets:"",disposableAssets:"",radio:"1",logsFind:"",newTableData:[],tableData:[]}},watch:{logsFind(t){switch(this.radio){case"1":this.newTableData=this.tableData.filter((e=>e.assetsLogId==t));break;case"2":this.newTableData=this.tableData.filter((e=>e.userName==t));break}}},methods:{handleClick1(t){console.log(t);const e=confirm("确认删除吗");e&&(0,o.Z)({url:"http://localhost:8080/admin/admassets/assetslog/{assetsLogId}",method:"delete",params:{assetsLogId:t.assetsLogId}}).then((()=>{alert("删除成功！请重新查询日志")})).catch((()=>{alert("请求失败，请稍后重试")}))},handleClick2(t){console.log(t);const e=prompt("请输入修改的日志描述");(0,o.Z)({method:"put",url:"http://localhost:8080/admin/admassets/assetslog/update",params:{id:t.assetsLogId,description:e}}).then((()=>{alert("修改成功！请重新查询日志")})).catch((()=>{alert("请求失败，请稍后重试")}))},findAllLogs(){(0,o.Z)({url:"http://localhost:8080/admin/admassets/assetslog",method:"get",params:{pageNum:1,pageSize:1e6}}).then((t=>{this.tableData=t.data.data.data.list,this.newTableData=t.data.data.data.list,this.tableData.forEach((t=>{t.processTime=i()(t.processTime).format("YYYY-MM-DD HH:mm:ss")})),this.newTableData.forEach((t=>{t.processTime=i()(t.processTime).format("YYYY-MM-DD HH:mm:ss")}))})).catch((()=>{alert("请求失败，请稍后重试")})),o.Z.get("http://localhost:8080/admin/admassets/assets/new").then((t=>{this.totalAssets=t.data.data.totalAssets,this.disposableAssets=t.data.data.disposableAssets}))}},mounted(){},created(){o.Z.get("http://localhost:8080/admin/admassets/assets/new").then((t=>{this.totalAssets=t.data.data.totalAssets,this.disposableAssets=t.data.data.disposableAssets})),(0,o.Z)({url:"http://localhost:8080/admin/admassets/assetslog",method:"get",params:{pageNum:1,pageSize:1e6}}).then((t=>{this.tableData=t.data.data.data.list,this.newTableData=t.data.data.data.list,this.tableData.forEach((t=>{t.processTime=i()(t.processTime).format("YYYY-MM-DD HH:mm:ss")})),this.newTableData.forEach((t=>{t.processTime=i()(t.processTime).format("YYYY-MM-DD HH:mm:ss")}))})).catch((()=>{alert("请求失败，请稍后重试")}))}},l=u,c=s(1001),d=(0,c.Z)(l,a,r,!1,null,"51a4e011",null),h=d.exports},7484:function(t){!function(e,s){t.exports=s()}(0,(function(){"use strict";var t=1e3,e=6e4,s=36e5,a="millisecond",r="second",n="minute",i="hour",o="day",u="week",l="month",c="quarter",d="year",h="date",f="Invalid Date",m=/^(\d{4})[-/]?(\d{1,2})?[-/]?(\d{0,2})[Tt\s]*(\d{1,2})?:?(\d{1,2})?:?(\d{1,2})?[.:]?(\d+)?$/,p=/\[([^\]]+)]|Y{1,4}|M{1,4}|D{1,2}|d{1,4}|H{1,2}|h{1,2}|a|A|m{1,2}|s{1,2}|Z{1,2}|SSS/g,$={name:"en",weekdays:"Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_"),months:"January_February_March_April_May_June_July_August_September_October_November_December".split("_"),ordinal:function(t){var e=["th","st","nd","rd"],s=t%100;return"["+t+(e[(s-20)%10]||e[s]||e[0])+"]"}},b=function(t,e,s){var a=String(t);return!a||a.length>=e?t:""+Array(e+1-a.length).join(s)+t},g={s:b,z:function(t){var e=-t.utcOffset(),s=Math.abs(e),a=Math.floor(s/60),r=s%60;return(e<=0?"+":"-")+b(a,2,"0")+":"+b(r,2,"0")},m:function t(e,s){if(e.date()<s.date())return-t(s,e);var a=12*(s.year()-e.year())+(s.month()-e.month()),r=e.clone().add(a,l),n=s-r<0,i=e.clone().add(a+(n?-1:1),l);return+(-(a+(s-r)/(n?r-i:i-r))||0)},a:function(t){return t<0?Math.ceil(t)||0:Math.floor(t)},p:function(t){return{M:l,y:d,w:u,d:o,D:h,h:i,m:n,s:r,ms:a,Q:c}[t]||String(t||"").toLowerCase().replace(/s$/,"")},u:function(t){return void 0===t}},D="en",v={};v[D]=$;var w=function(t){return t instanceof _},M=function t(e,s,a){var r;if(!e)return D;if("string"==typeof e){var n=e.toLowerCase();v[n]&&(r=n),s&&(v[n]=s,r=n);var i=e.split("-");if(!r&&i.length>1)return t(i[0])}else{var o=e.name;v[o]=e,r=o}return!a&&r&&(D=r),r||!a&&D},y=function(t,e){if(w(t))return t.clone();var s="object"==typeof e?e:{};return s.date=t,s.args=arguments,new _(s)},S=g;S.l=M,S.i=w,S.w=function(t,e){return y(t,{locale:e.$L,utc:e.$u,x:e.$x,$offset:e.$offset})};var _=function(){function $(t){this.$L=M(t.locale,null,!0),this.parse(t)}var b=$.prototype;return b.parse=function(t){this.$d=function(t){var e=t.date,s=t.utc;if(null===e)return new Date(NaN);if(S.u(e))return new Date;if(e instanceof Date)return new Date(e);if("string"==typeof e&&!/Z$/i.test(e)){var a=e.match(m);if(a){var r=a[2]-1||0,n=(a[7]||"0").substring(0,3);return s?new Date(Date.UTC(a[1],r,a[3]||1,a[4]||0,a[5]||0,a[6]||0,n)):new Date(a[1],r,a[3]||1,a[4]||0,a[5]||0,a[6]||0,n)}}return new Date(e)}(t),this.$x=t.x||{},this.init()},b.init=function(){var t=this.$d;this.$y=t.getFullYear(),this.$M=t.getMonth(),this.$D=t.getDate(),this.$W=t.getDay(),this.$H=t.getHours(),this.$m=t.getMinutes(),this.$s=t.getSeconds(),this.$ms=t.getMilliseconds()},b.$utils=function(){return S},b.isValid=function(){return!(this.$d.toString()===f)},b.isSame=function(t,e){var s=y(t);return this.startOf(e)<=s&&s<=this.endOf(e)},b.isAfter=function(t,e){return y(t)<this.startOf(e)},b.isBefore=function(t,e){return this.endOf(e)<y(t)},b.$g=function(t,e,s){return S.u(t)?this[e]:this.set(s,t)},b.unix=function(){return Math.floor(this.valueOf()/1e3)},b.valueOf=function(){return this.$d.getTime()},b.startOf=function(t,e){var s=this,a=!!S.u(e)||e,c=S.p(t),f=function(t,e){var r=S.w(s.$u?Date.UTC(s.$y,e,t):new Date(s.$y,e,t),s);return a?r:r.endOf(o)},m=function(t,e){return S.w(s.toDate()[t].apply(s.toDate("s"),(a?[0,0,0,0]:[23,59,59,999]).slice(e)),s)},p=this.$W,$=this.$M,b=this.$D,g="set"+(this.$u?"UTC":"");switch(c){case d:return a?f(1,0):f(31,11);case l:return a?f(1,$):f(0,$+1);case u:var D=this.$locale().weekStart||0,v=(p<D?p+7:p)-D;return f(a?b-v:b+(6-v),$);case o:case h:return m(g+"Hours",0);case i:return m(g+"Minutes",1);case n:return m(g+"Seconds",2);case r:return m(g+"Milliseconds",3);default:return this.clone()}},b.endOf=function(t){return this.startOf(t,!1)},b.$set=function(t,e){var s,u=S.p(t),c="set"+(this.$u?"UTC":""),f=(s={},s[o]=c+"Date",s[h]=c+"Date",s[l]=c+"Month",s[d]=c+"FullYear",s[i]=c+"Hours",s[n]=c+"Minutes",s[r]=c+"Seconds",s[a]=c+"Milliseconds",s)[u],m=u===o?this.$D+(e-this.$W):e;if(u===l||u===d){var p=this.clone().set(h,1);p.$d[f](m),p.init(),this.$d=p.set(h,Math.min(this.$D,p.daysInMonth())).$d}else f&&this.$d[f](m);return this.init(),this},b.set=function(t,e){return this.clone().$set(t,e)},b.get=function(t){return this[S.p(t)]()},b.add=function(a,c){var h,f=this;a=Number(a);var m=S.p(c),p=function(t){var e=y(f);return S.w(e.date(e.date()+Math.round(t*a)),f)};if(m===l)return this.set(l,this.$M+a);if(m===d)return this.set(d,this.$y+a);if(m===o)return p(1);if(m===u)return p(7);var $=(h={},h[n]=e,h[i]=s,h[r]=t,h)[m]||1,b=this.$d.getTime()+a*$;return S.w(b,this)},b.subtract=function(t,e){return this.add(-1*t,e)},b.format=function(t){var e=this,s=this.$locale();if(!this.isValid())return s.invalidDate||f;var a=t||"YYYY-MM-DDTHH:mm:ssZ",r=S.z(this),n=this.$H,i=this.$m,o=this.$M,u=s.weekdays,l=s.months,c=s.meridiem,d=function(t,s,r,n){return t&&(t[s]||t(e,a))||r[s].slice(0,n)},h=function(t){return S.s(n%12||12,t,"0")},m=c||function(t,e,s){var a=t<12?"AM":"PM";return s?a.toLowerCase():a};return a.replace(p,(function(t,a){return a||function(t){switch(t){case"YY":return String(e.$y).slice(-2);case"YYYY":return S.s(e.$y,4,"0");case"M":return o+1;case"MM":return S.s(o+1,2,"0");case"MMM":return d(s.monthsShort,o,l,3);case"MMMM":return d(l,o);case"D":return e.$D;case"DD":return S.s(e.$D,2,"0");case"d":return String(e.$W);case"dd":return d(s.weekdaysMin,e.$W,u,2);case"ddd":return d(s.weekdaysShort,e.$W,u,3);case"dddd":return u[e.$W];case"H":return String(n);case"HH":return S.s(n,2,"0");case"h":return h(1);case"hh":return h(2);case"a":return m(n,i,!0);case"A":return m(n,i,!1);case"m":return String(i);case"mm":return S.s(i,2,"0");case"s":return String(e.$s);case"ss":return S.s(e.$s,2,"0");case"SSS":return S.s(e.$ms,3,"0");case"Z":return r}return null}(t)||r.replace(":","")}))},b.utcOffset=function(){return 15*-Math.round(this.$d.getTimezoneOffset()/15)},b.diff=function(a,h,f){var m,p=this,$=S.p(h),b=y(a),g=(b.utcOffset()-this.utcOffset())*e,D=this-b,v=function(){return S.m(p,b)};switch($){case d:m=v()/12;break;case l:m=v();break;case c:m=v()/3;break;case u:m=(D-g)/6048e5;break;case o:m=(D-g)/864e5;break;case i:m=D/s;break;case n:m=D/e;break;case r:m=D/t;break;default:m=D}return f?m:S.a(m)},b.daysInMonth=function(){return this.endOf(l).$D},b.$locale=function(){return v[this.$L]},b.locale=function(t,e){if(!t)return this.$L;var s=this.clone(),a=M(t,e,!0);return a&&(s.$L=a),s},b.clone=function(){return S.w(this.$d,this)},b.toDate=function(){return new Date(this.valueOf())},b.toJSON=function(){return this.isValid()?this.toISOString():null},b.toISOString=function(){return this.$d.toISOString()},b.toString=function(){return this.$d.toUTCString()},$}(),k=_.prototype;return y.prototype=k,[["$ms",a],["$s",r],["$m",n],["$H",i],["$W",o],["$M",l],["$y",d],["$D",h]].forEach((function(t){k[t[1]]=function(e){return this.$g(e,t[0],t[1])}})),y.extend=function(t,e){return t.$i||(t(e,_,y),t.$i=!0),y},y.locale=M,y.isDayjs=w,y.unix=function(t){return y(1e3*t)},y.en=v[D],y.Ls=v,y.p={},y}))}}]);
//# sourceMappingURL=335.343820d4.js.map
webpackJsonp([2],{101:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n(110),i=n.n(a),s=n(111),r=n(9)(i.a,s.a,null,null,null);e.default=r.exports},110:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=function(t){return t&&t.__esModule?t:{default:t}}(n(4)),i=n(3);n(27);e.default={data:function(){return{mdNickname:null}},computed:(0,a.default)({},(0,i.mapState)({nickname:function(t){var e=t.auth;return e.user&&e.user.nickname||""}}),{newNickname:{get:function(){return null===this.mdNickname?this.nickname:this.mdNickname},set:function(t){this.mdNickname=t||""}}}),created:function(){this.nickname||this.getUserInfo()},methods:(0,a.default)({},(0,i.mapActions)(["updateUser","getUserInfo"]),{mdUser:function(){this.newNickname&&this.updateUser({nickname:this.newNickname})}})}},111:function(t,e,n){"use strict";var a={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"settings-box"},[n("div",{staticClass:"settings-container"},[n("h2",{staticClass:"title"},[t._v("设置")]),t._v(" "),n("hr"),t._v(" "),n("div",{staticClass:"profile"},[n("div",{staticClass:"control-group",attrs:{id:"settingsForm"}},[n("form",{staticClass:"settings-form",attrs:{novalidate:""},on:{submit:function(e){e.preventDefault(),t.mdUser()}}},[n("div",{staticClass:"form-group"},[n("div",{staticClass:"form-group"},[n("label",{staticClass:"control-label"},[t._v("昵称")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.newNickname,expression:"newNickname"},{name:"validate",rawName:"v-validate",value:"required|nickname|min:4|max:30",expression:"'required|nickname|min:4|max:30'"}],staticClass:"form-control",attrs:{type:"text",name:"nickname",placeholder:"2-15字符，中英文、数字和下划线"},domProps:{value:t.newNickname},on:{input:function(e){e.target.composing||(t.newNickname=e.target.value)}}})])]),t._v(" "),t._m(0)])])])])])},staticRenderFns:[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"form-group"},[n("button",{staticClass:"btn btn-block btn-lg btn-primary",attrs:{type:"submit"}},[t._v("保 存")])])}]};e.a=a}});
import{C as N}from"./CodeMng-BqjTn1CT.js";import{i as _,r as e,o as k,a as m,b as o,c as d,d as l,k as i,F as C,p as V,h as v,t as I}from"./index-DFO3MUi4.js";import"./confirm-DrgE0thk.js";const R={class:"section-area"},S={class:"article-area"},w={class:"mb-8 space-y-8 lg:flex lg:gap-x-0 lg:space-y-0"},B={class:"lg:w-5/12 h-full"},E={class:"lg:w-7/12 h-full"},L={key:0},K={__name:"CodeMngPage",setup(M){const g=_("axios");_("msg");const u=e(null),p=e(null);e(null);const n=e([]),c=e([]),f=e(!0);e("first"),e(""),e([]),e(null),k(()=>{g.get("code").then(s=>{n.value.push(s.data[0]||{cdId:null,cdNm:"전체"}),u.value.initNodeKeys()}).finally(()=>{f.value=!1})});const h=s=>c.value=s,y=()=>{const a=Array.from(p.value.querySelectorAll("input")).find(r=>!r.disabled);a&&a.focus()};return(s,a)=>{const r=m("el-divider"),b=m("el-input");return o(),d("section",R,[l("article",S,[l("div",w,[l("div",B,[l("div",null,[i(N,{data:n.value,"save-url":"/code",filter:"","show-node-key":"","node-key":"cdId","upr-node-key":"uprCdId","code-type":"CD","tree-props":{label:"cdNm",value:"cdId"},draggable:"",onNodeSelect:h,onKeyupEnter:y,ref_key:"treeRef",ref:u},null,8,["data"])])]),l("div",null,[i(r,{direction:"vertical",class:"!h-full"})]),l("div",E,[l("div",null,[f.value?v("",!0):(o(),d("div",{key:0,ref_key:"formRef",ref:p,class:"space-y-1"},[a[0]||(a[0]=l("p",{class:"text-xl"},"상세보기",-1)),(o(!0),d(C,null,V(Object.keys(n.value[0]),(t,j)=>(o(),d("div",{key:t},[t!="children"?(o(),d("div",L,[l("p",null,I(t),1),i(b,{modelValue:c.value[t],"onUpdate:modelValue":x=>c.value[t]=x,disabled:["cdId","uprCdId","parent","cd","cdOrd"].includes(t),clearable:""},null,8,["modelValue","onUpdate:modelValue","disabled"])])):v("",!0)]))),128))],512))])])])])])}}};export{K as default};

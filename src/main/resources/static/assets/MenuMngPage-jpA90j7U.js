import{C as k}from"./CodeMng-eOaynqep.js";import{q as f,r as e,b as M,s as _,o as a,c as s,a as o,i as d,x as v,F as V,j as I,t as C,d as g}from"./index-B4bRf2BI.js";import"./confirm-BHlsxUeq.js";const w={class:"article-area",style:{height:"100%"}},R={class:"mb-8 space-y-8 lg:flex lg:gap-x-4 lg:space-y-0"},S={class:"lg:w-5/12 h-full"},j={class:"lg:w-7/12 h-full"},B={key:0},K={__name:"MenuMngPage",setup(E){const h=f("axios");f("msg");const i=e(null),m=e(null);e(null);const r=e([]),c=e([]),p=e(!0);e("first"),e(""),e([]),e(null),M(()=>{h.get("menu").then(t=>{r.value.push(t.data[0]||{menuId:null,menuNm:"초기값"}),i.value.initNodeKeys()}).finally(()=>{p.value=!1})});const y=t=>c.value=t,x=()=>{const n=Array.from(m.value.querySelectorAll("input")).find(u=>!u.disabled);n&&n.focus()};return(t,n)=>{const u=_("el-card"),N=_("el-input");return a(),s("article",w,[o("div",R,[o("div",S,[d(u,null,{default:v(()=>[d(k,{data:r.value,"save-url":"/menu",filter:"","show-node-key":"","node-key":"menuId","upr-node-key":"uprMenuId","code-type":"MN","tree-props":{label:"menuNm",value:"menuId"},draggable:"",onNodeSelect:y,onKeyupEnter:x,ref_key:"treeRef",ref:i},null,8,["data"])]),_:1})]),o("div",j,[d(u,{class:"h-full"},{default:v(()=>[p.value?g("",!0):(a(),s("div",{key:0,ref_key:"formRef",ref:m},[n[0]||(n[0]=o("p",{class:"text-xl"},"코드 상세보기",-1)),(a(!0),s(V,null,I(Object.keys(r.value[0]),(l,L)=>(a(),s("div",{key:l},[l!="children"?(a(),s("div",B,[o("p",null,C(l),1),d(N,{modelValue:c.value[l],"onUpdate:modelValue":b=>c.value[l]=b,disabled:["menuId","uprMenuId","parent"].includes(l)},null,8,["modelValue","onUpdate:modelValue","disabled"])])):g("",!0)]))),128))],512))]),_:1})])])])}}};export{K as default};

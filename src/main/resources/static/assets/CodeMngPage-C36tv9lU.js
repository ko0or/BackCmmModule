import{C as k}from"./CodeMng-Cw_2zLI6.js";import{z as v,r as e,b as V,l as i,o as s,m as I,p,a as l,h as d,c,F as S,i as L,d as g,t as w}from"./index-DjHCyUli.js";const B={class:"article-area",style:{height:"100%"}},R={class:"mb-8 space-y-8 lg:flex lg:gap-x-4 lg:space-y-0"},E={class:"lg:w-5/12 h-full"},M={class:"lg:w-7/12 h-full"},j={key:0},U={__name:"CodeMngPage",setup(A){const h=v("axios");v("msg");const f=e(null),_=e(null);e(null);const r=e([]),u=e([]),m=e(!0);e("first"),e(""),e([]),e(null),V(()=>{h.get("code").then(a=>{r.value.push(a.data[0]||{cdId:null,cdNm:"초기값"}),f.value.initNodeKeys()}).finally(()=>{m.value=!1})});const y=a=>u.value=a,x=()=>{const o=Array.from(_.value.querySelectorAll("input")).find(n=>!n.disabled);o&&o.focus()};return(a,o)=>{const n=i("el-card"),C=i("el-input"),N=i("LayoutSection");return s(),I(N,{title:"코드 관리"},{default:p(()=>[l("article",B,[l("div",R,[l("div",E,[d(n,null,{default:p(()=>[d(k,{data:r.value,"save-url":"/code",filter:"","show-node-key":"","node-key":"cdId","upr-node-key":"uprCdId","code-type":"CD","tree-props":{label:"cdNm",value:"cdId"},draggable:"",onNodeSelect:y,onKeyupEnter:x,ref_key:"treeRef",ref:f},null,8,["data"])]),_:1})]),l("div",M,[d(n,{class:"h-full"},{default:p(()=>[m.value?g("",!0):(s(),c("div",{key:0,ref_key:"formRef",ref:_},[o[0]||(o[0]=l("p",{class:"text-xl"},"코드 상세보기",-1)),(s(!0),c(S,null,L(Object.keys(r.value[0]),(t,D)=>(s(),c("div",{key:t},[t!="children"?(s(),c("div",j,[l("p",null,w(t),1),d(C,{modelValue:u.value[t],"onUpdate:modelValue":b=>u.value[t]=b,disabled:["cdId","uprCdId"].includes(t)},null,8,["modelValue","onUpdate:modelValue","disabled"])])):g("",!0)]))),128))],512))]),_:1})])])])]),_:1})}}};export{U as default};
import{C as R}from"./CodeMng-Cw_2zLI6.js";import{z as v,r as e,b as V,l as i,o as s,m as I,p,a as l,h as u,c as r,F as S,i as C,d as g,t as L}from"./index-DjHCyUli.js";const w={class:"article-area",style:{height:"100%"}},B={class:"mb-8 space-y-8 lg:flex lg:gap-x-4 lg:space-y-0"},E={class:"lg:w-5/12 h-full"},M={class:"lg:w-7/12 h-full"},j={key:0},U={__name:"RouteMngPage",setup(A){const h=v("axios");v("msg");const f=e(null),_=e(null);e(null);const d=e([]),c=e([]),m=e(!0);e("first"),e(""),e([]),e(null),V(()=>{h.get("route").then(o=>{d.value.push(o.data[0]||{routeId:null,routeNm:"초기값"}),f.value.initNodeKeys()}).finally(()=>{m.value=!1})});const y=o=>c.value=o,x=()=>{const a=Array.from(_.value.querySelectorAll("input")).find(n=>!n.disabled);a&&a.focus()};return(o,a)=>{const n=i("el-card"),N=i("el-input"),b=i("LayoutSection");return s(),I(b,{title:"라우트 관리"},{default:p(()=>[l("article",w,[l("div",B,[l("div",E,[u(n,null,{default:p(()=>[u(R,{data:d.value,"save-url":"/route",filter:"","show-node-key":"","node-key":"routeId","upr-node-key":"uprRouteId","code-type":"RT","tree-props":{label:"routeNm",value:"routeId"},draggable:"",onNodeSelect:y,onKeyupEnter:x,ref_key:"treeRef",ref:f},null,8,["data"])]),_:1})]),l("div",M,[u(n,{class:"h-full"},{default:p(()=>[m.value?g("",!0):(s(),r("div",{key:0,ref_key:"formRef",ref:_},[a[0]||(a[0]=l("p",{class:"text-xl"},"코드 상세보기",-1)),(s(!0),r(S,null,C(Object.keys(d.value[0]),(t,F)=>(s(),r("div",{key:t},[t!="children"?(s(),r("div",j,[l("p",null,L(t),1),u(N,{modelValue:c.value[t],"onUpdate:modelValue":k=>c.value[t]=k,disabled:["routeId","uprRouteId","parent","menu"].includes(t)},null,8,["modelValue","onUpdate:modelValue","disabled"])])):g("",!0)]))),128))],512))]),_:1})])])])]),_:1})}}};export{U as default};

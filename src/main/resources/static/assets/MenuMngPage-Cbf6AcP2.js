import{C as k}from"./CodeMng-Djx29kfn.js";import{q as f,r as e,b as V,s as _,o as n,c as o,a as t,i as r,x as h,F as w,j as I,d as v,t as M}from"./index-CgG7z2Zf.js";const C={class:"section-area"},R={class:"article-area",style:{height:"100%"}},S={style:{display:"flex","column-gap":"1rem",width:"100%",height:"100%"}},j={class:"",style:{height:"100%"}},B={style:{width:"100%"}},E={key:0},K={__name:"MenuMngPage",setup(L){const g=f("axios");f("msg");const c=e(null),m=e(null);e(null);const u=e([]),i=e([]),p=e(!0);e("first"),e(""),e([]),e(null),V(()=>{g.get("menu").then(a=>{u.value.push(a.data[0]||{menuId:null,menuNm:"초기값"}),c.value.initNodeKeys()}).finally(()=>{p.value=!1})});const y=a=>i.value=a,x=()=>{const l=Array.from(m.value.querySelectorAll("input")).find(d=>!d.disabled);l&&l.focus()};return(a,l)=>{const d=_("el-card"),N=_("el-input");return n(),o("section",C,[l[1]||(l[1]=t("article",{class:"article-area"},[t("p",{class:"section-title"}," 메뉴 관리 "),t("div",{style:{height:"5px",background:"black",width:"50px",margin:".5em auto 2.5rem auto"}})],-1)),t("article",R,[t("div",S,[t("div",j,[r(d,{style:{width:"400px",height:"100%"}},{default:h(()=>[r(k,{data:u.value,"save-url":"/menu",filter:"","show-node-key":"","node-key":"menuId","upr-node-key":"uprRouteId","code-type":"MN","tree-props":{label:"menuNm",value:"menuId"},draggable:"",onNodeSelect:y,onKeyupEnter:x,ref_key:"treeRef",ref:c},null,8,["data"])]),_:1})]),t("div",B,[r(d,{class:"h-full"},{default:h(()=>[p.value?v("",!0):(n(),o("div",{key:0,ref_key:"formRef",ref:m},[l[0]||(l[0]=t("p",{class:"text-xl"},"코드 상세보기",-1)),(n(!0),o(w,null,I(Object.keys(u.value[0]),(s,q)=>(n(),o("div",{key:s},[s!="children"?(n(),o("div",E,[t("p",null,M(s),1),r(N,{modelValue:i.value[s],"onUpdate:modelValue":b=>i.value[s]=b,disabled:["menuId","uprMenuId","parent"].includes(s)},null,8,["modelValue","onUpdate:modelValue","disabled"])])):v("",!0)]))),128))],512))]),_:1})])])])])}}};export{K as default};

import{C}from"./CodeMng-DQ7hQLo4.js";import{q as m,r as e,b as N,s as _,o,c as d,a as t,i as r,x as h,F as V,j as w,t as I,d as v}from"./index-BXNFt6Ee.js";const R={class:"section-area"},S={class:"article-area",style:{height:"100%"}},j={style:{display:"flex","column-gap":"1rem",width:"100%",height:"100%"}},B={class:"",style:{height:"100%"}},E={style:{width:"100%"}},L={key:0},F={__name:"CodeMngPage",setup(M){const g=m("axios");m("msg");const u=e(null),p=e(null);e(null);const i=e([]),c=e([]),f=e(!0);e("first"),e(""),e([]),e(null),N(()=>{g.get("code").then(a=>{i.value.push(a.data[0]||{cdId:null,cdNm:"초기값"}),u.value.initNodeKeys()}).finally(()=>{f.value=!1})});const y=a=>c.value=a,x=()=>{const l=Array.from(p.value.querySelectorAll("input")).find(n=>!n.disabled);l&&l.focus()};return(a,l)=>{const n=_("el-card"),b=_("el-input");return o(),d("section",R,[l[1]||(l[1]=t("article",{class:"article-area"},[t("p",{class:"section-title"}," 코드 관리 "),t("div",{style:{height:"5px",background:"black",width:"50px",margin:".5em auto 2.5rem auto"}})],-1)),t("article",S,[t("div",j,[t("div",B,[r(n,{style:{width:"400px",height:"100%"}},{default:h(()=>[r(C,{data:i.value,"save-url":"/code",filter:"","show-node-key":"","node-key":"cdId","upr-node-key":"uprCdId","code-type":"CD","tree-props":{label:"cdNm",value:"cdId"},draggable:"",onNodeSelect:y,onKeyupEnter:x,ref_key:"treeRef",ref:u},null,8,["data"])]),_:1})]),t("div",E,[r(n,{class:"h-full"},{default:h(()=>[f.value?v("",!0):(o(),d("div",{key:0,ref_key:"formRef",ref:p},[l[0]||(l[0]=t("p",{class:"text-xl"},"코드 상세보기",-1)),(o(!0),d(V,null,w(Object.keys(i.value[0]),(s,q)=>(o(),d("div",{key:s},[s!="children"?(o(),d("div",L,[t("p",null,I(s),1),r(b,{modelValue:c.value[s],"onUpdate:modelValue":k=>c.value[s]=k,disabled:["cdId","uprCdId"].includes(s)},null,8,["modelValue","onUpdate:modelValue","disabled"])])):v("",!0)]))),128))],512))]),_:1})])])])])}}};export{F as default};
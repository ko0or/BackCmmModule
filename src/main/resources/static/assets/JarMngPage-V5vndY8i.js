import{i as d,s as i,x as p,a as t,b as _,c as m,d as f,k as a,f as s,u as h,X as x,g}from"./index-DFO3MUi4.js";import{e as b}from"./confirm-DrgE0thk.js";const k={class:"section-area"},B={class:"article-area"},V={__name:"JarMngPage",setup(w){const n=d("axios");i(),p();const r=e=>(console.log("파일 준비 중:",e),!0),c=({file:e})=>{console.log(e),b(`프로젝트를 재배포하시겠습니까? (선택한 파일 : ${e.name})`,"재배포").then(()=>{const o=new FormData;o.append("file",e),n.post("/admin/update-version",o,{headers:{"Content-Type":"multipart/form-data"}})})};return(e,o)=>{const l=t("el-button"),u=t("el-upload");return _(),m("section",k,[f("article",B,[a(u,{"http-request":c,"before-upload":r,"show-file-list":!1},{default:s(()=>[a(l,{icon:h(x)},{default:s(()=>o[0]||(o[0]=[g("파일 선택")])),_:1},8,["icon"])]),_:1})])])}}};export{V as default};

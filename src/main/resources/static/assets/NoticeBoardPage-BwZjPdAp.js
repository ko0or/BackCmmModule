import{S as g,B as m,a as _,b}from"./BoardSearch-Dl99joz9.js";import{r as f,s as l,o as B,c as x,a as t,i as s,x as n,h as i}from"./index-BA4-j57R.js";/* empty css                                                                   */const w={class:"section-area"},v={class:"article-area"},C={class:"article-area"},k={style:{display:"flex","justify-content":"space-between"}},S={__name:"NoticeBoardPage",setup(y){const a=f({page:0,size:1}),u=o=>{a.value.page=o},c=o=>{alert("idx : "+o)};return(o,e)=>{const r=l("el-button"),p=l("Plus"),d=l("el-icon");return B(),x("section",w,[t("article",v,[e[0]||(e[0]=t("p",{class:"section-title"}," 공지사항 ",-1)),s(g),e[1]||(e[1]=t("br",null,null,-1))]),t("article",C,[s(m),s(_,{onRowClick:c}),e[5]||(e[5]=t("br",null,null,-1)),t("div",k,[s(r,{size:"large",class:"custom"},{default:n(()=>e[2]||(e[2]=[i(" 목록 ")])),_:1}),s(r,{size:"large",class:"custom"},{default:n(()=>[s(d,null,{default:n(()=>[s(p)]),_:1}),e[3]||(e[3]=i("    ")),e[4]||(e[4]=t("p",null,"글 쓰기",-1))]),_:1})]),e[6]||(e[6]=t("br",null,null,-1)),s(b,{"cur-page-num":a.value.page,"cur-page-row-cnt":a.value.size,"total-page-cnt":33,"display-btn-cnt":5,onChange:u},null,8,["cur-page-num","cur-page-row-cnt"])])])}}};export{S as default};

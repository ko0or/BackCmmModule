import{S as c,B as b,a as d,b as p}from"./BoardSearch-CIN_SJsr.js";import{_ as m,u as g,k as N,r as _,o as f,c as y,a,t as B,l as r,i as o}from"./index-C2VD-t8e.js";/* empty css                                                                   */const v={class:"section-area"},q={class:"article-area"},k={class:"section-title"},w={class:"article-area"},x={class:"btn-wrapper"},C={__name:"BoardListPage",setup(R){const[t,l]=[g(),N()],s=_({page:0,size:1}),u=n=>{s.value.page=n},i=n=>{l.push({name:"게시글 상세"})};return(n,e)=>(f(),y("section",v,[a("article",q,[a("p",k,B(Number(r(t).query.brdNo)===0?"질문 & 답변":Number(r(t).query.brdNo)===1?"자유 게시판":Number(r(t).query.brdNo)===2?"공지사항":"미선택"),1),e[1]||(e[1]=a("br",null,null,-1)),o(c,{"route-arr":[{label:"질문 & 답변",name:"게시글 목록",query:{brdNo:0,page:0}},{label:"자유 게시판",name:"게시글 목록",query:{brdNo:1,page:0}},{label:"공지사항",name:"게시글 목록",query:{brdNo:2,page:0}}],"active-idx":Number(r(t).query.brdNo)},null,8,["active-idx"]),e[2]||(e[2]=a("br",null,null,-1))]),a("article",w,[o(b),o(d,{onRowClick:i}),e[4]||(e[4]=a("br",null,null,-1)),a("div",x,[a("button",{class:"cmm-btn cmm-btn--info",onClick:e[0]||(e[0]=S=>r(l).push({name:"게시글 작성"}))}," 글 쓰기 "),e[3]||(e[3]=a("button",{class:"cmm-btn cmm-btn--info",disabled:""}," 목록 ",-1))]),e[5]||(e[5]=a("br",null,null,-1)),o(p,{"cur-page-num":s.value.page,"cur-page-row-cnt":s.value.size,"total-page-cnt":33,"display-btn-cnt":5,onChange:u},null,8,["cur-page-num","cur-page-row-cnt"])])]))}},L=m(C,[["__scopeId","data-v-84a706b5"]]);export{L as default};

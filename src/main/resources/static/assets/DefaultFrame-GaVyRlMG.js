import{_ as y,r as g,f as R,u as N,k as q,o as t,c as o,a as e,F as m,j as h,t as k,h as u,A as V,C as $,s as A,i as f,D}from"./index-D4DEnVxf.js";const E="/assets/img/siba.png",F={style:{background:"#737373"}},I={class:"nav-top inner"},S={key:0},T={class:"nav-main inner"},B={class:"nav-main--menu-list"},j=["onClick"],G={id:"nav-main--toggle-btn"},P={class:"article-area"},Q={class:"header-desktop--menu"},Y={class:"header-desktop--parent-menu"},z=["onClick"],J={__name:"LayoutHeader",setup(p){const n=g(),c=g(),a=g(!0);R({desktopMenuVisible:setTimeout(()=>{})});const[le,d]=[N(),q()],b=[{name:"게시판",value:"게시글 목록",children:[{name:"질문 & 답변",value:"게시글 목록",query:{brdNo:0,page:0}},{name:"자유 게시판",value:"게시글 목록",query:{brdNo:1,page:0}},{name:"공지사항",value:"게시글 목록",query:{brdNo:2,page:0}}]},{name:"관련 정보",value:null,children:[{name:"자주묻는 질문",value:null},{name:"추천 라이브러리",value:null},{name:"추천 사이트",value:null},{name:"사이트 정보",value:null}]},{name:"강의 소개",value:"강의 소개",children:[{name:"프론트엔드",value:null},{name:"백엔드",value:null},{name:"SQL",value:null},{name:"기타",value:null}]},{name:"관리",value:null,children:[{name:"회원 관리",value:"회원 관리"},{name:"권한 관리",value:"권한 관리"},{name:"코드 관리",value:"코드 관리"},{name:"라우트 관리",value:"라우트 관리"},{name:"메뉴 관리",value:"메뉴 관리"},{name:"게시판 관리",value:"게시판 관리"},{name:"댓글 관리",value:"댓글 관리"},{name:"신고 관리",value:"신고 관리"}]}],r=()=>Number(window.getComputedStyle(n.value).opacity)>0,l=s=>{n.value.style.visibility=s?"visible":"hidden",n.value.style.opacity=s?"1":"0",c.value.setAttribute("checked",s)},X=()=>{a.value&&l(!0)},w=()=>{r()&&l(!1),a.value=!0},M=()=>{r()&&l(!0)},C=()=>{r()&&l(!1)},L=()=>{a.value=!1,l(!1),d.push({name:"메인"})},H=()=>{a.value=!r(),l(!r())},x=()=>{a.value=!1,l(!1),d.push({name:"로그인"})},O=s=>{a.value=!1,l(!1),s.query?d.push({name:s.value,query:s.query}):d.push({name:s.value}),$(()=>a.value=!0)};return(s,v)=>(t(),o("header",null,[e("nav",F,[e("div",I,[(t(),o("div",S,[e("button",{class:"btn-default",onClick:x}," 로그인 ")]))])]),e("nav",{style:{background:"white"},onMouseover:X,onMouseleave:w},[e("div",T,[e("div",{class:"nav-main--logo",style:{display:"flex","align-items":"center"},onClick:L},v[2]||(v[2]=[e("img",{src:E,alt:"사이트 로고",width:"34"},null,-1)])),e("div",B,[(t(),o(m,null,h(b,i=>e("div",{class:"nav-main--menu-item",onClick:_=>O(i)},k(i.name),9,j)),64))]),e("div",{class:"nav-main--bugger-btn",onClick:H},[e("div",G,[e("input",{type:"checkbox",ref_key:"buggerStateRef",ref:c},null,512),v[3]||(v[3]=e("span",null,null,-1))])])])],32),e("div",{class:"header-desktop--menu-wrapper",ref_key:"desktopMenuRef",ref:n,onMouseover:M,onMouseleave:C},[e("div",P,[e("div",Q,[(t(),o(m,null,h(b,i=>e("div",Y,[u(k(i.name)+" ",1),(t(!0),o(m,null,h(i.children,_=>(t(),o("div",{class:"header-desktop--child-menu",onClick:V(oe=>O(_),["stop"])},k(_.name),9,z))),256))])),64))])])],544)]))}},K=y(J,[["__scopeId","data-v-6fe59bd8"]]),U="/assets/img/naver_blog.png",W="/assets/img/tistory.png",Z="/assets/img/youtube.png",ee={};function ne(p,n){return t(),o("footer",null,n[0]||(n[0]=[e("div",{class:"footer-wrapper article-area"},[e("address",null,[e("span",null,"댕코딩"),u("   |   "),e("span",null,"대표자"),u(" OOO   |   "),e("span",null,"등록번호"),u(" OOO-OO-OOOOO "),e("br"),e("span",null,"TEL"),u(" 051-XXX-XXXX   |   "),e("span",null,"FAX"),u(" 051-XXX-XXXX   |   "),e("span",null,"EMAIL"),u(" XXXXX@XXXXX.com "),e("br"),e("span",null,"부산광역시 OO구 OO로 11-2 (OO동 OOOO)")]),e("div",null,[e("p",{class:"copyright"}," COPYRIGHT 2024. 김민우 All Rights Reserved. "),e("div",{class:"sns"},[e("img",{src:U,onclick:"window.open('https://blog.naver.com/taehwa10404')",alt:"네이버 블로그"}),e("img",{src:W,onclick:"window.open('https://m1nwoo.tistory.com')",alt:"티스토리"}),e("img",{src:Z,onclick:"window.open('https://www.youtube.com/@dang-coding')",alt:"유튜브 댕코딩"})])])],-1)]))}const ae=y(ee,[["render",ne],["__scopeId","data-v-ee9cce29"]]),se={__name:"LayoutMain",setup(p){return(n,c)=>{const a=A("router-view");return t(),o(m,null,[f(K),e("main",null,[f(a)]),f(ae)],64)}}},te=y(se,[["__scopeId","data-v-dd18d523"]]),re={__name:"DefaultFrame",setup(p){return(n,c)=>(t(),D(te))}};export{re as default};
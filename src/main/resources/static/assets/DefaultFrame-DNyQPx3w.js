import{_ as C,z as B,r as y,f as U,u as j,j as z,l as m,o as n,c as l,a as e,F as r,i as f,t as g,q as L,h as a,p as k,A as i,C as G,G as Q,m as P}from"./index-DjHCyUli.js";const Y="/assets/img/siba.png",J={class:"nav-main inner"},K={class:"nav-main--menu-list"},W=["onClick"],Z={id:"only-desktop"},ee={class:"flex gap-x-4"},ne={class:"flex items-center gap-x-2"},le={id:"only-mobile"},se={class:"article-area"},ae={class:"header-desktop--menu"},te={class:"header-desktop--parent-menu"},oe=["onClick"],ue={class:"p-2 my-2 w-full"},re=["onClick"],ie={__name:"LayoutHeader",setup(w){const c=B("info"),p=y();y();const t=y(!0);U({desktopMenuVisible:setTimeout(()=>{})});const[ye,v]=[j(),z()],h=y(!1),b=[{name:"게시판",value:"게시글 목록",children:[{name:"질문 & 답변",value:"게시글 목록",query:{brdNo:0,page:0}},{name:"자유 게시판",value:"게시글 목록",query:{brdNo:1,page:0}},{name:"공지사항",value:"게시글 목록",query:{brdNo:2,page:0}}]},{name:"관련 정보",value:null,children:[{name:"자주하는 질문",value:"자주하는 질문"},{name:"추천 라이브러리",value:"추천 라이브러리"},{name:"추천 사이트",value:"추천 사이트"},{name:"사이트 정보",value:"사이트 정보"}]},{name:"강의 소개",value:"강의 소개",children:[{name:"프론트엔드",value:"프론트"},{name:"백엔드",value:"백엔드"},{name:"SQL",value:"SQL"},{name:"기타",value:"기타"}]},{name:"관리",value:null,children:[{name:"회원 관리",value:"회원 관리"},{name:"권한 관리",value:"권한 관리"},{name:"코드 관리",value:"코드 관리"},{name:"라우트 관리",value:"라우트 관리"},{name:"메뉴 관리",value:"메뉴 관리"},{name:"게시판 관리",value:"게시판 관리"},{name:"댓글 관리",value:"댓글 관리"},{name:"신고 관리",value:"신고 관리"}]}],O=()=>Number(window.getComputedStyle(p.value).opacity)>0,d=o=>{if(window.getComputedStyle(document.querySelector("#only-mobile")).display==="block"){h.value=!1;return}p.value.style.visibility=o?"visible":"hidden",p.value.style.opacity=o?"1":"0"},M=()=>{t.value&&d(!0)},H=()=>{O()&&d(!1),t.value=!0},V=()=>{O()&&d(!0)},F=()=>{O()&&d(!1)},q=()=>{t.value=!1,d(!1),v.push({name:"메인"})},$=()=>{t.value=!1,d(!1),v.push({name:"로그인"})},N=()=>{c.clear()},X=o=>{t.value=!1,d(!1),o.query?v.push({name:o.value,query:o.query}):v.push({name:o.value}),Q(()=>t.value=!0)},R=()=>{h.value=!0};return(o,u)=>{const S=m("UserFilled"),x=m("el-icon"),D=m("Fold"),E=m("el-collapse-item"),I=m("el-collapse"),T=m("el-drawer");return n(),l(r,null,[e("header",null,[e("nav",{style:{background:"white"},onMouseover:M,onMouseleave:H},[e("div",J,[e("div",{class:"nav-main--logo",style:{display:"flex","align-items":"center"},onClick:q},u[2]||(u[2]=[e("img",{src:Y,alt:"사이트 로고",width:"34"},null,-1)])),e("div",K,[(n(),l(r,null,f(b,s=>e("div",{class:"nav-main--menu-item",onClick:_=>X(s)},g(s.name),9,W)),64))]),e("div",Z,[e("div",ee,[L(c).isLogin()?(n(),l(r,{key:1},[e("button",{class:"btn-default",onClick:u[0]||(u[0]=s=>L(v).push({name:"내 정보"}))}," 내 정보 "),e("button",{class:"btn-default",onClick:N}," 로그아웃 ")],64)):(n(),l("button",{key:0,class:"btn-default",onClick:$},[e("span",ne,[a(x,null,{default:k(()=>[a(S)]),_:1}),u[3]||(u[3]=i(" 로그인 "))])]))])]),e("div",le,[e("div",{onClick:R,class:"scale-150 h-full flex cursor-pointer"},[a(x,null,{default:k(()=>[a(D)]),_:1})])])])],32),e("div",{class:"header-desktop--menu-wrapper",ref_key:"desktopMenuRef",ref:p,onMouseover:V,onMouseleave:F},[e("div",se,[e("div",ae,[(n(),l(r,null,f(b,s=>e("div",te,[i(g(s.name)+" ",1),(n(!0),l(r,null,f(s.children,_=>(n(),l("div",{class:"header-desktop--child-menu",onClick:G(A=>X(_),["stop"])},g(_.name),9,oe))),256))])),64))])])],544)]),a(T,{modelValue:h.value,"onUpdate:modelValue":u[1]||(u[1]=s=>h.value=s),size:"70%",title:"전체 메뉴"},{default:k(()=>[a(I,null,{default:k(()=>[(n(),l(r,null,f(b,s=>a(E,{title:s.name},{default:k(()=>[(n(!0),l(r,null,f(s.children,_=>(n(),l("div",ue,[e("div",{onClick:A=>X(_),class:"w-full cursor-pointer"},g(_.name),9,re)]))),256))]),_:2},1032,["title"])),64))]),_:1})]),_:1},8,["modelValue"])],64)}}},ce=C(ie,[["__scopeId","data-v-e662e421"]]),de="/assets/img/naver_blog.png",me="/assets/img/tistory.png",pe="/assets/img/youtube.png",_e={};function ve(w,c){return n(),l("footer",null,c[0]||(c[0]=[e("div",{class:"footer-wrapper article-area"},[e("address",null,[e("span",null,"댕코딩"),i("   |   "),e("span",null,"대표자"),i(" OOO   |   "),e("span",null,"등록번호"),i(" OOO-OO-OOOOO "),e("br"),e("span",null,"TEL"),i(" 051-XXX-XXXX   |   "),e("span",null,"FAX"),i(" 051-XXX-XXXX   |   "),e("span",null,"EMAIL"),i(" XXXXX@XXXXX.com "),e("br"),e("span",null,"부산광역시 OO구 OO로 11-2 (OO동 OOOO)")]),e("div",null,[e("p",{class:"copyright"}," COPYRIGHT 2024. 김민우 All Rights Reserved. "),e("div",{class:"sns"},[e("img",{src:de,onclick:"window.open('https://blog.naver.com/taehwa10404')",alt:"네이버 블로그"}),e("img",{src:me,onclick:"window.open('https://m1nwoo.tistory.com')",alt:"티스토리"}),e("img",{src:pe,onclick:"window.open('https://www.youtube.com/@dang-coding')",alt:"유튜브 댕코딩"})])])],-1)]))}const fe=C(_e,[["render",ve],["__scopeId","data-v-ee9cce29"]]),ke={__name:"LayoutMain",setup(w){return(c,p)=>{const t=m("router-view");return n(),l(r,null,[a(ce),e("main",null,[a(t)]),a(fe)],64)}}},he=C(ke,[["__scopeId","data-v-dd18d523"]]),we={__name:"DefaultFrame",setup(w){return(c,p)=>(n(),P(he))}};export{we as default};
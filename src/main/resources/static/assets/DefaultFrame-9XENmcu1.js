import{_ as T,r as S,m as V,u as H,k as I,p as v,o as e,c as u,a as t,i as g,q as a,h as x,F as p,j as M,t as f,A as O,K as A,b as F,E as r,L as E,d as R,l as b,M as P}from"./index-BrMHVjQo.js";import{b as U,n as j,N as K}from"./confirm-BJ_xWtVx.js";const z="/assets/img/docker_logo.png",G={style:{background:"white"}},J={class:"nav-main inner"},Q={class:"article-area"},W={class:"header-desktop--menu"},X={class:"header-desktop--parent-menu"},Y=["onClick"],Z={__name:"LayoutHeader",setup(q){const n=S(),N=S(),l=S(!0),C=V("info"),[B,i]=[H(),I()],h=[{name:"관리",value:"게시글 목록",children:[{name:"프로젝트",value:"프로젝트 관리"},{name:"도커",value:"컨테이너 관리"}]},{name:"정보",value:"게시글 목록",children:[{name:"메모장",value:"메모장"},{name:"자료실",value:"자료실"}]},{name:"설정",value:"게시글 목록",children:[{name:"메뉴 관리",value:"메뉴 관리"},{name:"라우트 관리",value:"라우트 관리"}]}],d=()=>Number(window.getComputedStyle(n.value).opacity)>0,_=o=>{n.value.style.visibility=o?"visible":"hidden",n.value.style.opacity=o?"1":"0",N.value.setAttribute("checked",o)},m=()=>{d()&&_(!0)},k=()=>{d()&&_(!1)},$=()=>{l.value=!1,_(!1),i.push({name:"메인"})},s=()=>{U("로그아웃하시겠습니까?","로그아웃").then(()=>{C.clear(),i.push({name:"로그인"}),j("로그아웃","로그아웃되었습니다",K.SUCCESS)})},y=o=>{l.value=!1,_(!1),o.query?i.push({name:o.value,query:o.query}):i.push({name:o.value}),A(()=>l.value=!0)};return(o,c)=>{const L=v("el-button");return e(),u("header",null,[t("nav",G,[t("div",J,[t("div",{class:"nav-main--logo",style:{display:"flex","align-items":"center"},onClick:$},c[0]||(c[0]=[t("img",{src:z,alt:"사이트 로고",width:"28"},null,-1)])),c[2]||(c[2]=t("div",{class:"nav-main--menu-list"},null,-1)),t("div",null,[g(L,{onClick:s,class:"rounded !font-bold"},{default:a(()=>c[1]||(c[1]=[x(" 로그아웃 ")])),_:1})])])]),t("div",{class:"header-desktop--menu-wrapper",ref_key:"desktopMenuRef",ref:n,onMouseover:m,onMouseleave:k},[t("div",Q,[t("div",W,[(e(),u(p,null,M(h,w=>t("div",X,[x(f(w.name)+" ",1),(e(!0),u(p,null,M(w.children,D=>(e(),u("div",{class:"header-desktop--child-menu",onClick:O(ce=>y(D),["stop"])},f(D.name),9,Y))),256))])),64))])])],544)])}}},ee=T(Z,[["__scopeId","data-v-9d5aded0"]]),te={__name:"LayoutSidebar",setup(q){F(()=>{n.get("/menu").then(h=>{C.value=Object.assign([],h.data[0].children)})});const n=V("axios"),[N,l]=[H(),I()],C=S([]),B=S(["0","1","2"]),i=h=>{function d(k,$=[]){return k.forEach(s=>{$.push(s),s.children&&s.children.length&&d(s.children,$)}),$}const m=d(N.matched[0].children).find(k=>k.routeId===h.routeId);m.routeParam?.length?l.push({name:m.routeNm,query:{id:m.routeParam}}):l.push({name:m.routeNm})};return(h,d)=>{const _=v("el-icon"),m=v("el-menu-item"),k=v("el-sub-menu"),$=v("el-menu");return e(),r($,{class:"!h-full","default-openeds":B.value},{default:a(()=>[(e(!0),u(p,null,M(C.value,(s,y)=>(e(),u(p,{key:y},[s.children?(e(),r(k,{key:0,index:String(y)},{title:a(()=>[s.menuIcon?.length?(e(),r(_,{key:0},{default:a(()=>[(e(),r(E(s.menuIcon)))]),_:2},1024)):R("",!0),t("span",null,f(s.menuNm),1)]),default:a(()=>[(e(!0),u(p,null,M(s.children,(o,c)=>(e(),u(p,{key:c},[o.children?.length?(e(),r(k,{key:1,index:`${y}-${c}`},{title:a(()=>[x(f(o.menuNm),1)]),default:a(()=>[(e(!0),u(p,null,M(o.children,(L,w)=>(e(),r(m,{key:w,index:`${y}-${c}-${w}`,onClick:D=>i(L)},{default:a(()=>[x(f(L.menuNm),1)]),_:2},1032,["index","onClick"]))),128))]),_:2},1032,["index"])):(e(),r(m,{key:0,index:`${y}-${c}`,onClick:L=>i(o)},{default:a(()=>[x(f(o.menuNm),1)]),_:2},1032,["index","onClick"]))],64))),128))]),_:2},1032,["index"])):(e(),r(m,{key:1,index:String(y)},{default:a(()=>[s.menuIcon?.length?(e(),r(_,{key:0},{default:a(()=>[(e(),r(E(s.menuIcon)))]),_:2},1024)):R("",!0),t("span",null,f(s.menuNm),1)]),_:2},1032,["index"]))],64))),128))]),_:1},8,["default-openeds"])}}},ne={class:"section-area !py-5"},ae={class:"article-area flex justify-between"},se={__name:"LayoutBreadCrumb",setup(q){const[n,N]=[H(),I()],l={BD00010001:"메모장",BD00010002:"자료실"};return(C,B)=>{const i=v("el-breadcrumb-item"),h=v("el-breadcrumb");return e(),u("section",ne,[t("article",ae,[t("div",null,f(l[b(n).query.id]?l[b(n).query.id]:b(n).name),1),t("div",null,[g(h,{"separator-icon":b(P)},{default:a(()=>[b(n).query.id?.includes("BD")?(e(!0),u(p,{key:0},M(b(n).matched,(d,_)=>(e(),r(i,null,{default:a(()=>[x(f(_===2?l[b(n).query.id]:d.name),1)]),_:2},1024))),256)):(e(!0),u(p,{key:1},M(b(n).matched,d=>(e(),r(i,null,{default:a(()=>[x(f(d.name),1)]),_:2},1024))),256))]),_:1},8,["separator-icon"])])])])}}},oe={class:"flex h-full"},le={class:"w-full h-full"},re={__name:"LayoutMain",setup(q){return(n,N)=>{const l=v("el-scrollbar"),C=v("router-view");return e(),u(p,null,[g(ee),t("div",oe,[t("div",null,[g(l,{class:"el-scrollbar"},{default:a(()=>[g(te,{class:"sidebar"})]),_:1})]),t("div",le,[g(l,{class:"el-scrollbar"},{default:a(()=>[g(se),g(C)]),_:1})])])],64)}}},ue=T(re,[["__scopeId","data-v-bfedf1d4"]]),_e={__name:"DefaultFrame",setup(q){return(n,N)=>(e(),r(ue))}};export{_e as default};

import{_ as D,b as w,i as N,u as P,d as H,r as q,e as $,f as j,g as R,o as a,c as n,a as t,h as m,w as _,j as f,k as U,F as x,l as r,t as p,m as d,n as h,p as F,q as T,s as Y}from"./index-CAI6GlsR.js";import{_ as E}from"./ToastEditor-svy9_NEm.js";import{d as I,a as K}from"./confirm-Cbs6f6xJ.js";const M={class:"section-area"},S={class:"article-area pb-6"},z={class:"flex justify-between"},A={class:"article-area"},G={class:"comp-board-detail"},J={class:"comp-board-detail--title"},L={class:"comp-board-detail--info"},O={class:"comp-board-detail--author"},Q={key:0},W={class:"comp-board-detail--date"},X={key:0},Z={class:"comp-board-detail--view-cnt"},ee={key:0},te={class:"comp-board-detail--content"},oe={class:"article-area"},se={class:"comp-board-detail--nav"},ae={__name:"BoardDetailPage",setup(le){w(()=>{k()});const y=N("axios"),[l,u]=[P(),H()],o=q(),s=q(!0),k=()=>{s.value=!0,y.get(`/post/${l.query.pid}`).then(i=>{o.value=i.data,s.value=!1})},g=()=>{I().then(()=>{o.value.delYn="Y",y.post("/post",o.value).then(()=>{delete l.query.pid,u.push({name:"게시글 목록",query:l.query}),K()})})},C=()=>{u.push({name:"게시글 작성",query:l.query})},b=i=>{const e=i+"Post";o.value[e]&&u.push({name:"게시글 상세",query:{...l.query,pid:o.value[e].postUid}})},B=()=>{delete l.query.pid,u.push({name:"게시글 목록",query:l.query})};return $((i,e)=>{i.query.pid!==e.query.pid&&setTimeout(()=>k(),0)}),(i,e)=>{const c=j("el-button"),V=R("loading");return a(),n("section",M,[t("article",S,[t("div",z,[t("div",null,[m(c,{onClick:B,icon:f(F)},{default:_(()=>e[3]||(e[3]=[r(" 목록 ")])),_:1},8,["icon"])]),t("div",null,[m(c,{onClick:g,icon:f(T)},{default:_(()=>e[4]||(e[4]=[r("삭제")])),_:1},8,["icon"]),m(c,{onClick:C,icon:f(Y)},{default:_(()=>e[5]||(e[5]=[r("수정")])),_:1},8,["icon"])])])]),U((a(),n("article",A,[t("div",G,[t("div",J,[s.value?d("",!0):(a(),n(x,{key:0},[r(p(o.value?.title),1)],64))]),t("div",L,[t("div",O,[e[6]||(e[6]=t("span",null,"작성자",-1)),s.value?d("",!0):(a(),n("p",Q,p(o.value?.user?.nickname),1))]),t("div",W,[e[7]||(e[7]=t("span",null,"등록일",-1)),s.value?d("",!0):(a(),n("p",X,"1일전"))]),t("div",Z,[e[8]||(e[8]=t("span",null,"조회수",-1)),s.value?d("",!0):(a(),n("p",ee,"@"))])]),t("div",te,[s.value?d("",!0):(a(),n(x,{key:0},[o.value?.content?(a(),h(E,{key:0,modelValue:o.value.content,"onUpdate:modelValue":e[0]||(e[0]=v=>o.value.content=v),readonly:""},null,8,["modelValue"])):d("",!0)],64))])])])),[[V,s.value]]),t("article",oe,[t("nav",se,[t("ul",null,[t("li",{onClick:e[1]||(e[1]=v=>b("next"))},[e[9]||(e[9]=t("span",null,"이전글",-1)),t("p",null,p(o.value?.nextPost?.title||"게시글이 존재하지 않습니다"),1)]),t("li",{onClick:e[2]||(e[2]=v=>b("prev"))},[e[10]||(e[10]=t("span",null,"다음글",-1)),t("p",null,p(o.value?.prevPost?.title||"게시글이 존재하지 않습니다"),1)])])])]),e[11]||(e[11]=t("br",null,null,-1)),e[12]||(e[12]=t("br",null,null,-1))])}}},ue=D(ae,[["__scopeId","data-v-61dc7f3a"]]);export{ue as default};

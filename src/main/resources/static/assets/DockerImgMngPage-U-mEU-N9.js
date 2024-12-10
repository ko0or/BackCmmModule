import{_ as P,b as T,q as $,r,z as V,s as o,o as g,c as w,a as l,i as s,h as m,x as a,F as C,j as G,l as M,B as Z,t as p,A as J,C as K,E as Q}from"./index-Cb5hVYHm.js";import{c as I,n as N,a as W}from"./confirm-Cf7SoJ2X.js";import{D as X}from"./DockerService-DnvpjMsz.js";const ee={class:"article-area"},le={class:"flex justify-between items-center"},te={class:"flex gap-x-2"},oe={class:"article-area pt-4"},se={class:"flex flex-wrap w-full gap-4"},ae={class:"flex justify-between items-center"},ne={class:"pt-3 space-y-3"},ie=`
        <path class="path" d="
          M 30 15
          L 28 17
          M 25.61 25.61
          A 15 15, 0, 0, 1, 15 30
          A 15 15, 0, 1, 1, 27.99 7.5
          L 15 15
        " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
`,re={__name:"DockerImgMngPage",setup(ue){T(()=>{v()});const b=$("axios"),x=r(!0),u=r(!1),k=r([]),d=r(),f=r({imageName:""}),F=r({imageName:[{required:!0,message:"이미지명을 입력해주세요",trigger:"blur"}]}),c=r(!1),n=r({}),v=()=>{X.getImageAll().then(i=>k.value=i)},j=(i,e)=>{n.value[e.ID]=!n.value[e.ID]},Y=()=>{c.value=!0,d.value&&(d.value.clearValidate(),d.value.resetFields())},h=()=>{d.value.validate(i=>{i&&I("이미지를 다운로드하시겠습니까?","이미지").then(()=>{const e=Q.service({lock:!0,text:"다운로드중",spinner:ie,svgViewBox:"-10, -10, 50, 50",background:"rgba(0, 0, 0, 0.7)",fullscreen:!0});b.post("/docker/image/pull",f.value).then(y=>{N("이미지","이미지 다운로드 완료","success"),c.value=!1,v()}).finally(()=>{e.close()})})})},A=()=>{I("이미지를 삭제하시겠습니까?","이미지").then(async()=>{const i=Object.keys(n.value).filter(e=>n.value[e]);for(const e of i)await b.post("/docker/image/delete",{imageName:e});N("이미지","이미지 삭제 완료","success"),v()})};return V(u,()=>{v()}),V(n,()=>{x.value=!Object.keys(n.value).some(i=>n.value[i])},{deep:!0}),(i,e)=>{const y=o("el-switch"),B=o("el-text"),H=o("el-button"),D=o("el-card"),L=o("el-checkbox"),R=o("el-tag"),U=o("el-input"),S=o("el-form-item"),q=o("el-descriptions-item"),E=o("el-descriptions"),z=o("el-form"),O=o("el-dialog");return g(),w(C,null,[l("article",ee,[l("div",le,[l("div",null,[s(y,{modelValue:u.value,"onUpdate:modelValue":e[0]||(e[0]=t=>u.value=t)},null,8,["modelValue"]),e[7]||(e[7]=m("  ")),s(B,{onClick:e[1]||(e[1]=t=>u.value=!u.value),type:u.value?"primary":"info",class:"cursor-pointer"},{default:a(()=>e[6]||(e[6]=[m(" 실행중 컨테이너만 표시 ")])),_:1},8,["type"])]),l("div",te,[s(H,{onClick:A,link:"",disabled:x.value},{default:a(()=>e[8]||(e[8]=[m(" 삭제 ")])),_:1},8,["disabled"])])])]),l("article",oe,[l("div",se,[s(D,{onClick:Y,class:"card-box hover:!bg-gray-50"},{default:a(()=>e[9]||(e[9]=[l("div",{class:"w-full pb-14 h-80 max-h-80 flex flex-col justify-center items-center"},[l("p",{class:"text-gray-500 text-4xl rounded-full bg-gray-50 py-4 px-6"},"+"),l("br"),l("p",{class:"text-gray-500"},"새로운 이미지 등록")],-1)])),_:1}),(g(!0),w(C,null,G(k.value,t=>(g(),Z(D,{key:t.ID,class:"card-box",onClick:_=>j(_,t)},{default:a(()=>[l("div",ae,[s(L,{modelValue:n.value[t.ID],"onUpdate:modelValue":_=>n.value[t.ID]=_,onClick:e[2]||(e[2]=J(()=>{},["stop"]))},{default:a(()=>[m(p(t.ID),1)]),_:2},1032,["modelValue","onUpdate:modelValue"]),s(R,null,{default:a(()=>[m(p(t.Tag),1)]),_:2},1024)]),l("div",ne,[l("div",null,[e[10]||(e[10]=l("p",{class:"font-bold"},"이미지명",-1)),l("p",null,p(t.Repository),1)]),l("div",null,[e[11]||(e[11]=l("p",{class:"font-bold"},"이미지 등록일",-1)),l("p",null,p(M(K)(t.CreatedAt,"YYYY-MM-DD HH:mm:ss Z").format("YYYY.MM.DD hh:mm")),1)]),l("div",null,[e[12]||(e[12]=l("p",{class:"font-bold"},"이미지 크기",-1)),l("p",null,p(t.Size),1)])])]),_:2},1032,["onClick"]))),128))])]),s(O,{title:"이미지",modelValue:c.value,"onUpdate:modelValue":e[5]||(e[5]=t=>c.value=t),"align-center":"","before-close":function(t){M(W)().then(()=>t())}},{default:a(()=>[s(z,{ref_key:"imgFrmRef",ref:d,model:f.value,rules:F.value},{default:a(()=>[s(E,{column:2,border:""},{default:a(()=>[s(q,{label:"이미지",width:"200"},{default:a(()=>[s(S,{prop:"imageName",required:"",class:"py-2 !mb-0"},{default:a(()=>[s(U,{modelValue:f.value.imageName,"onUpdate:modelValue":e[3]||(e[3]=t=>f.value.imageName=t),placeholder:"이미지명:태그명"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])]),footer:a(()=>[l("div",{onClick:e[4]||(e[4]=t=>c.value=!1)},"취소"),l("div",{onClick:h},"저장")]),_:1},8,["modelValue","before-close"])],64)}}},pe=P(re,[["__scopeId","data-v-620533c3"]]);export{pe as default};

import{_ as z,b as O,q as P,r,z as V,s as o,o as g,c as w,a as l,i as s,h as m,x as a,F as T,j as $,B as G,t as p,A as Z,l as J,C as K,E as Q}from"./index-BXNFt6Ee.js";import{c as C,n as M}from"./confirm-BdaP8Y2Q.js";import{D as W}from"./DockerService-BFDM8HWg.js";const X={class:"section-area"},ee={class:"article-area"},le={class:"flex justify-between items-center"},te={class:"flex gap-x-2"},oe={class:"article-area pt-10"},se={class:"flex flex-wrap w-full gap-4"},ae={class:"flex justify-between items-center"},ne={class:"pt-3 space-y-3"},ie=`
        <path class="path" d="
          M 30 15
          L 28 17
          M 25.61 25.61
          A 15 15, 0, 0, 1, 15 30
          A 15 15, 0, 1, 1, 27.99 7.5
          L 15 15
        " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
`,re={__name:"DockerImgMngPage",setup(ue){O(()=>{v()});const b=P("axios"),x=r(!0),u=r(!1),k=r([]),d=r(),f=r({imageName:""}),I=r({imageName:[{required:!0,message:"이미지명을 입력해주세요",trigger:"blur"}]}),c=r(!1),n=r({}),v=()=>{W.getImageAll().then(i=>k.value=i)},N=(i,e)=>{n.value[e.ID]=!n.value[e.ID]},F=()=>{c.value=!0,d.value&&(d.value.clearValidate(),d.value.resetFields())},j=()=>{d.value.validate(i=>{i&&C("이미지를 다운로드하시겠습니까?","이미지").then(()=>{const e=Q.service({lock:!0,text:"다운로드중",spinner:ie,svgViewBox:"-10, -10, 50, 50",background:"rgba(0, 0, 0, 0.7)",fullscreen:!0});b.post("/docker/image/pull",f.value).then(y=>{M("이미지","이미지 다운로드 완료","success"),c.value=!1,v()}).finally(()=>{e.close()})})})},Y=()=>{C("이미지를 삭제하시겠습니까?","이미지").then(async()=>{const i=Object.keys(n.value).filter(e=>n.value[e]);for(const e of i)await b.post("/docker/image/delete",{imageName:e});M("이미지","이미지 삭제 완료","success"),v()})};return V(u,()=>{v()}),V(n,()=>{x.value=!Object.keys(n.value).some(i=>n.value[i])},{deep:!0}),(i,e)=>{const y=o("el-switch"),h=o("el-text"),A=o("el-button"),D=o("el-card"),B=o("el-checkbox"),H=o("el-tag"),L=o("el-input"),R=o("el-form-item"),U=o("el-descriptions-item"),S=o("el-descriptions"),q=o("el-form"),E=o("el-dialog");return g(),w("section",X,[l("article",ee,[l("div",le,[l("div",null,[s(y,{modelValue:u.value,"onUpdate:modelValue":e[0]||(e[0]=t=>u.value=t)},null,8,["modelValue"]),e[7]||(e[7]=m("  ")),s(h,{onClick:e[1]||(e[1]=t=>u.value=!u.value),type:u.value?"primary":"info",class:"cursor-pointer"},{default:a(()=>e[6]||(e[6]=[m(" 실행중 컨테이너만 표시 ")])),_:1},8,["type"])]),l("div",te,[s(A,{onClick:Y,link:"",disabled:x.value},{default:a(()=>e[8]||(e[8]=[m(" 삭제 ")])),_:1},8,["disabled"])])])]),l("article",oe,[l("div",se,[s(D,{onClick:F,class:"card-box hover:!bg-gray-50"},{default:a(()=>e[9]||(e[9]=[l("div",{class:"w-full pb-14 h-80 max-h-80 flex flex-col justify-center items-center"},[l("p",{class:"text-4xl rounded-full bg-gray-50 py-4 px-6"},"+"),l("br"),l("p",null,"새로운 이미지 등록")],-1)])),_:1}),(g(!0),w(T,null,$(k.value,t=>(g(),G(D,{key:t.ID,class:"card-box",onClick:_=>N(_,t)},{default:a(()=>[l("div",ae,[s(B,{modelValue:n.value[t.ID],"onUpdate:modelValue":_=>n.value[t.ID]=_,onClick:e[2]||(e[2]=Z(()=>{},["stop"]))},{default:a(()=>[m(p(t.ID),1)]),_:2},1032,["modelValue","onUpdate:modelValue"]),s(H,null,{default:a(()=>[m(p(t.Tag),1)]),_:2},1024)]),l("div",ne,[l("div",null,[e[10]||(e[10]=l("p",{class:"font-bold"},"이미지명",-1)),l("p",null,p(t.Repository),1)]),l("div",null,[e[11]||(e[11]=l("p",{class:"font-bold"},"이미지 등록일",-1)),l("p",null,p(J(K)(t.CreatedAt,"YYYY-MM-DD HH:mm:ss Z").format("YYYY.MM.DD hh:mm")),1)]),l("div",null,[e[12]||(e[12]=l("p",{class:"font-bold"},"이미지 크기",-1)),l("p",null,p(t.Size),1)])])]),_:2},1032,["onClick"]))),128))])]),s(E,{title:"이미지",modelValue:c.value,"onUpdate:modelValue":e[5]||(e[5]=t=>c.value=t),"align-center":""},{default:a(()=>[s(q,{ref_key:"imgFrmRef",ref:d,model:f.value,rules:I.value},{default:a(()=>[s(S,{column:2,border:""},{default:a(()=>[s(U,{label:"이미지",width:"200"},{default:a(()=>[s(R,{prop:"imageName",required:"",class:"py-2 !mb-0"},{default:a(()=>[s(L,{modelValue:f.value.imageName,"onUpdate:modelValue":e[3]||(e[3]=t=>f.value.imageName=t),placeholder:"이미지명:태그명"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])]),footer:a(()=>[l("div",{onClick:e[4]||(e[4]=t=>c.value=!1)},"취소"),l("div",{onClick:j},"저장")]),_:1},8,["modelValue"])])}}},pe=z(re,[["__scopeId","data-v-f5cb823f"]]);export{pe as default};
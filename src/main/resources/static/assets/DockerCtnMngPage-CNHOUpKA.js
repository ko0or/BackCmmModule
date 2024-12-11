import{_ as T,b as Z,q as J,r as d,z as w,s as r,o as D,c as j,a as l,i as a,h as m,x as o,F as M,j as K,l as q,B as Q,t as f,A as W,C as X}from"./index-B4bRf2BI.js";import{c as y,n as V,a as h}from"./confirm-BHlsxUeq.js";import{D as ee}from"./DockerService-Zx4H3lba.js";const te={class:"article-area"},le={class:"flex justify-between items-center"},ae={class:"flex gap-x-2"},oe={class:"article-area pt-4"},se={class:"flex gap-x-4"},ne={class:"flex justify-between items-center"},re={class:"pt-3 space-y-3"},ie={__name:"DockerCtnMngPage",setup(ue){Z(()=>{p()});const b=J("axios"),_=d(!0),c=d(!1),P=d([]),v=d(),i=d({containerName:"",imageName:"",etrPort:12e3,itrPort:8080}),F=d({containerName:[{required:!0,message:"컨테이너명을 입력해주세요",trigger:"blur"}],imageName:[{required:!0,message:"이미지명을 입력해주세요",trigger:"blur"}],etrPort:[{required:!0,message:"외부포트를 입력해주세요",trigger:"blur"}],itrPort:[{required:!0,message:"내부포트를 입력해주세요",trigger:"blur"}]}),u=d(!1),s=d({}),p=()=>{ee.getContainerAll().then(n=>P.value=n)},H=(n,e)=>{s.value[e.ID]=!s.value[e.ID]},I=()=>{u.value=!0,v.value&&(v.value.clearValidate(),v.value.resetFields())},U=()=>{v.value.validate(n=>{n&&y("선택한 이미지로 컨테이너를 실행하시겠습니까?","이미지").then(()=>{b.post("/docker/image/start",i.value).then(e=>{V("이미지","이미지 실행 완료","success"),p(),u.value=!1})})})},Y=()=>{y("컨테이너를 삭제하시겠습니까?","컨테이너").then(async()=>{const n=Object.keys(s.value).filter(e=>s.value[e]);for(const e of n)await b.post("/docker/container/delete",{containerName:e});V("컨테이너","컨테이너 삭제 완료","success"),p(),u.value=!1})},B=()=>{y("컨테이너를 재실행하시겠습니까?","이미지").then(async()=>{const n=Object.keys(s.value).filter(e=>s.value[e]);for(const e of n)await b.post("/docker/container/start",{containerName:e});V("이미지","이미지 재실행 완료","success"),p(),u.value=!1})},L=()=>{y("컨테이너를 중단하시겠습니까?","컨테이너").then(async()=>{const n=Object.keys(s.value).filter(e=>s.value[e]);for(const e of n)await b.post("/docker/container/stop",{containerName:e});V("컨테이너","컨테이너 중단 완료","success"),p(),u.value=!1})};return w(c,()=>{p()}),w(s,()=>{_.value=!Object.keys(s.value).some(n=>s.value[n])},{deep:!0}),(n,e)=>{const A=r("el-switch"),O=r("el-text"),N=r("el-button"),S=r("el-card"),R=r("el-checkbox"),$=r("el-tag"),g=r("el-input"),k=r("el-form-item"),x=r("el-descriptions-item"),z=r("el-descriptions"),E=r("el-form"),G=r("el-dialog");return D(),j(M,null,[l("article",te,[l("div",le,[l("div",null,[a(A,{modelValue:c.value,"onUpdate:modelValue":e[0]||(e[0]=t=>c.value=t)},null,8,["modelValue"]),e[10]||(e[10]=m("  ")),a(O,{onClick:e[1]||(e[1]=t=>c.value=!c.value),type:c.value?"primary":"info",class:"cursor-pointer"},{default:o(()=>e[9]||(e[9]=[m(" 실행중 컨테이너만 표시 ")])),_:1},8,["type"])]),l("div",ae,[a(N,{onClick:Y,link:"",disabled:_.value},{default:o(()=>e[11]||(e[11]=[m(" 삭제 ")])),_:1},8,["disabled"]),a(N,{onClick:L,link:"",disabled:_.value},{default:o(()=>e[12]||(e[12]=[m(" 중단 ")])),_:1},8,["disabled"]),a(N,{onClick:B,link:"",disabled:_.value},{default:o(()=>e[13]||(e[13]=[m(" 실행 ")])),_:1},8,["disabled"])])])]),l("article",oe,[l("div",se,[a(S,{onClick:I,class:"card-box hover:!bg-gray-50"},{default:o(()=>e[14]||(e[14]=[l("div",{class:"w-full pb-14 h-80 max-h-80 flex flex-col justify-center items-center"},[l("p",{class:"text-gray-500 text-4xl rounded-full bg-gray-50 py-4 px-6"},"+"),l("br"),l("p",{class:"text-gray-500"},"새로운 컨테이너 등록")],-1)])),_:1}),(D(!0),j(M,null,K(P.value,t=>(D(),Q(S,{key:t.ID,class:"card-box",onClick:C=>H(C,t)},{default:o(()=>[l("div",ne,[a(R,{modelValue:s.value[t.ID],"onUpdate:modelValue":C=>s.value[t.ID]=C,onClick:e[2]||(e[2]=W(()=>{},["stop"]))},{default:o(()=>[m(f(t.ID),1)]),_:2},1032,["modelValue","onUpdate:modelValue"]),a($,null,{default:o(()=>[m(f(t.State==="created"&&"실행전"||t.State==="running"&&"실행중"||t.State==="paused"&&"일시정지"||t.State==="restarting"&&"재시작중"||t.State==="exited"&&"종료"||t.State==="dead"&&"중단(복구불가)"||t.State==="removing"&&"삭제중"||t.State||"-"),1)]),_:2},1024)]),l("div",re,[l("div",null,[e[15]||(e[15]=l("p",{class:"font-bold"},"컨테이너명",-1)),l("p",null,f(t.Names),1)]),l("div",null,[e[16]||(e[16]=l("p",{class:"font-bold"},"컨테이너 연결포트",-1)),m(" "+f(t.Ports),1)]),l("div",null,[e[17]||(e[17]=l("p",{class:"font-bold"},"컨테이너 생성일",-1)),l("p",null,f(q(X)(t.CreatedAt,"YYYY-MM-DD HH:mm:ss Z").format("YYYY.MM.DD hh:mm")),1)]),l("div",null,[e[18]||(e[18]=l("p",{class:"font-bold"},"관련 이미지",-1)),l("p",null,f(t.Image),1)])])]),_:2},1032,["onClick"]))),128))])]),a(G,{title:"컨테이너",modelValue:u.value,"onUpdate:modelValue":e[8]||(e[8]=t=>u.value=t),"align-center":"","before-close":function(t){q(h)().then(()=>t())}},{default:o(()=>[a(E,{ref_key:"ctnFrmRef",ref:v,model:i.value,rules:F.value},{default:o(()=>[a(z,{column:2,border:""},{default:o(()=>[a(x,{label:"대상 이미지",span:"2"},{default:o(()=>[a(k,{prop:"imageName",required:"",class:"py-2 !mb-0"},{default:o(()=>[a(g,{modelValue:i.value.imageName,"onUpdate:modelValue":e[3]||(e[3]=t=>i.value.imageName=t),placeholder:"이미지명 (임시)"},null,8,["modelValue"])]),_:1})]),_:1}),a(x,{label:"컨테이너명",span:"2"},{default:o(()=>[a(k,{prop:"containerName",required:"",class:"py-2 !mb-0"},{default:o(()=>[a(g,{modelValue:i.value.containerName,"onUpdate:modelValue":e[4]||(e[4]=t=>i.value.containerName=t),placeholder:"컨테이너명"},null,8,["modelValue"])]),_:1})]),_:1}),a(x,{label:"외부포트"},{default:o(()=>[a(k,{prop:"etrPort",required:"",class:"py-2 !mb-0"},{default:o(()=>[a(g,{modelValue:i.value.etrPort,"onUpdate:modelValue":e[5]||(e[5]=t=>i.value.etrPort=t),placeholder:"외부포트",type:"number"},null,8,["modelValue"])]),_:1})]),_:1}),a(x,{label:"내부포트"},{default:o(()=>[a(k,{prop:"itrPort",required:"",class:"py-2 !mb-0"},{default:o(()=>[a(g,{modelValue:i.value.itrPort,"onUpdate:modelValue":e[6]||(e[6]=t=>i.value.itrPort=t),placeholder:"외부포트",type:"number"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])]),footer:o(()=>[l("div",{onClick:e[7]||(e[7]=t=>u.value=!1)},"취소"),l("div",{onClick:U},"저장")]),_:1},8,["modelValue","before-close"])],64)}}},pe=T(ie,[["__scopeId","data-v-c10c9fd7"]]);export{pe as default};

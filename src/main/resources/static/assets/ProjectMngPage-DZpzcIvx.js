import{b as O,m as F,u as Q,k as z,r as _,p as r,o as G,c as J,h as i,t as V,l as c,a as m,i as e,q as a,P as K,Q as W,R as X,A as g,E as Z}from"./index-D-cF6HXe.js";import{r as ee,a as le,b as ae,d as te,c as oe,n as k,N as P}from"./confirm-Dtf345b6.js";const re={class:"section-area"},ne={class:"article-area",style:{display:"flex","justify-content":"space-between","align-items":"center"}},se={style:{"text-align":"end"}},de={class:"article-area pt-4"},ue={style:{display:"flex","align-items":"center"}},ie=`
        <path class="path" d="
          M 30 15
          L 28 17
          M 25.61 25.61
          A 15 15, 0, 0, 1, 15 30
          A 15 15, 0, 1, 1, 27.99 7.5
          L 15 15
        " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
`,ge={__name:"ProjectMngPage",setup(me){O(()=>{Y()});const D=F("axios"),[R,pe]=[Q(),z()],v=_(),U=_({projectName:[{required:!0,message:"프로젝트명을 입력해주세요",trigger:"blur"}],projectUrl:[{required:!0,message:"도메인 주소를 입력해주세요",trigger:"blur"}],containerName:[{required:!0,message:"컨테이너명을 입력해주세요",trigger:"blur"}],imageName:[{required:!0,message:"이미지명을 입력해주세요",trigger:"blur"}],etrPort:[{required:!0,message:"외부포트를 입력해주세요",trigger:"blur"}],itrPort:[{required:!0,message:"내부포트를 입력해주세요",trigger:"blur"}]}),y=_([]),f=_(!1),l=_({projectUid:null,projectName:"",projectUrl:"",containerName:"",imageName:"",etrPort:"",itrPort:"",domainDateRange:[],sslDateRange:[],domainSdate:"",domainEdate:"",sslSdate:"",sslEdate:""}),Y=()=>{D.get("/docker/project").then(n=>{y.value=n.data})},E=n=>{f.value=!0,N()},S=()=>{v.value.validate(n=>{n&&(l.value.domainDateRange.length===2&&(l.value.domainSdate=g(l.value.domainDateRange[0]).format("YYYY-MM-DD"),l.value.domainEdate=g(l.value.domainDateRange[1]).format("YYYY-MM-DD")),l.value.sslDateRange.length===2&&(l.value.sslSdate=g(l.value.sslDateRange[0]).format("YYYY-MM-DD"),l.value.sslEdate=g(l.value.sslDateRange[1]).format("YYYY-MM-DD")),ae().then(()=>{D.post("/docker/project/save",l.value).then(()=>{f.value=!1,te(),Y()})}))})},x=n=>{N(),f.value=!0,l.value=Object.assign({},n),l.value.domainDateRange=[l.value.domainSdate,l.value.domainEdate],l.value.sslDateRange=[l.value.sslSdate,l.value.sslEdate]},N=()=>{v.value&&v.value.clearValidate(),l.value={projectUid:null,projectName:"",projectUrl:"",containerName:"",imageName:"",etrPort:"",itrPort:"",domainDateRange:[],sslDateRange:[],domainSdate:"",domainEdate:"",sslSdate:"",sslEdate:""}},C=()=>{Y(),ee()},h=n=>{oe(`선택하신 " ${n.projectName} " 프로젝트를 배포하시겠습니까?`,"프로젝트 배포").then(()=>{const t=Z.service({lock:!0,text:"프로젝트 배포중",spinner:ie,svgViewBox:"-10, -10, 50, 50",background:"rgba(0, 0, 0, 0.7)",fullscreen:!0});D.post("/docker/deploy",n).then(s=>{k("배포 성공",`${n.containerName} 컨테이너가 실행되었습니다`,P.SUCCESS)}).catch(()=>{k("배포 실패",`${n.containerName} 컨테이너 배포에 실패했습니다`,P.Error)}).finally(()=>{t.close()})})};return(n,t)=>{const s=r("el-input"),b=r("el-button"),q=r("el-tag"),p=r("el-table-column"),$=r("Setting"),j=r("el-icon"),A=r("VideoPlay"),H=r("el-table"),d=r("el-form-item"),u=r("el-descriptions-item"),w=r("el-date-picker"),M=r("el-row"),T=r("el-descriptions"),B=r("el-form"),I=r("el-dialog");return G(),J("section",re,[i(V(c(R).params)+" ",1),m("article",ne,[m("div",null,[e(s,{style:{width:"250px"},"suffix-icon":c(K),placeholder:"검색어를 입력해주세요"},null,8,["suffix-icon"])]),m("div",se,[m("div",null,[e(b,{onClick:C,icon:c(W),link:""},{default:a(()=>t[10]||(t[10]=[i(" 새로고침 ")])),_:1},8,["icon"]),e(b,{onClick:E,icon:c(X),link:""},{default:a(()=>t[11]||(t[11]=[i(" 추가 ")])),_:1},8,["icon"])])])]),m("article",de,[e(H,{data:y.value,border:""},{default:a(()=>[e(p,{label:"상태",align:"center",width:"100"},{default:a(o=>[e(q,null,{default:a(()=>t[12]||(t[12]=[i(" 정상 ")])),_:1})]),_:1}),e(p,{prop:"projectName",label:"프로젝트명",width:"200"}),e(p,{prop:"projectUrl",label:"사이트 주소"}),e(p,{label:"만기일",align:"center"},{default:a(()=>[e(p,{prop:"domainEdate",label:"도메인",align:"center",width:"150"},{default:a(o=>[i(V(o.row.domainEdate?"~ "+c(g)(o.row.domainEdate).format("YYYY.MM.DD"):"미등록"),1)]),_:1}),e(p,{prop:"sslEdate",label:"인증서",align:"center",width:"150"},{default:a(o=>[i(V(o.row.sslEdate?"~ "+c(g)(o.row.sslEdate).format("YYYY.MM.DD"):"미등록"),1)]),_:1})]),_:1}),e(p,{label:"작업",align:"center",width:"150"},{default:a(o=>[m("div",ue,[e(b,{class:"w-full",link:"",type:"info",onClick:L=>x(o.row)},{default:a(()=>[e(j,null,{default:a(()=>[e($)]),_:1}),t[13]||(t[13]=i(" 관리 "))]),_:2},1032,["onClick"]),e(b,{class:"w-full",link:"",type:"primary",onClick:L=>h(o.row),disabled:o.row.etrPort===0&&o.row.itrPort===0},{default:a(()=>[e(j,null,{default:a(()=>[e(A)]),_:1}),t[14]||(t[14]=i(" 배포 "))]),_:2},1032,["onClick","disabled"])])]),_:1})]),_:1},8,["data"])]),e(I,{modelValue:f.value,"onUpdate:modelValue":t[9]||(t[9]=o=>f.value=o),title:"프로젝트","align-center":"","before-close":function(o){c(le)().then(()=>o())}},{footer:a(()=>[m("div",{onClick:t[8]||(t[8]=o=>f.value=!1)},"취소"),m("div",{onClick:S},"확인")]),default:a(()=>[e(B,{model:l.value,rules:U.value,ref_key:"frmRef",ref:v,class:"pt-1"},{default:a(()=>[e(T,{column:2,border:""},{default:a(()=>[e(u,{label:"프로젝트명","min-width":"100"},{default:a(()=>[e(d,{required:"",prop:"projectName",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.projectName,"onUpdate:modelValue":t[0]||(t[0]=o=>l.value.projectName=o),placeholder:"프로젝트명"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,{label:"주소","min-width":"100"},{default:a(()=>[e(d,{required:"",prop:"projectUrl",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.projectUrl,"onUpdate:modelValue":t[1]||(t[1]=o=>l.value.projectUrl=o),placeholder:"http://www.domain.com"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,{label:"컨테이너명"},{default:a(()=>[e(d,{required:"",prop:"containerName",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.containerName,"onUpdate:modelValue":t[2]||(t[2]=o=>l.value.containerName=o),placeholder:"컨테이너명"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,{label:"이미지명"},{default:a(()=>[e(d,{required:"",prop:"imageName",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.imageName,"onUpdate:modelValue":t[3]||(t[3]=o=>l.value.imageName=o),placeholder:"이미지명:태그명"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,{label:"외부포트"},{default:a(()=>[e(d,{required:"",prop:"etrPort",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.etrPort,"onUpdate:modelValue":t[4]||(t[4]=o=>l.value.etrPort=o),placeholder:"외부 포트",type:"number"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,{label:"내부포트"},{default:a(()=>[e(d,{required:"",prop:"itrPort",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.itrPort,"onUpdate:modelValue":t[5]||(t[5]=o=>l.value.itrPort=o),placeholder:"내부 포트",type:"number"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,{label:"도메인"},{default:a(()=>[e(d,{prop:"domainDate",class:"py-2 !mb-0"},{default:a(()=>[e(M,null,{default:a(()=>[e(w,{modelValue:l.value.domainDateRange,"onUpdate:modelValue":t[6]||(t[6]=o=>l.value.domainDateRange=o),type:"daterange","start-placeholder":"도메인 등록일","end-placeholder":"도메인 만료일",format:"YYYY/MM/DD","value-format":"YYYY-MM-DD",class:"!w-full"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1}),e(u,{label:"인증서"},{default:a(()=>[e(d,{prop:"sslDate",class:"py-2 !mb-0"},{default:a(()=>[e(M,null,{default:a(()=>[e(w,{modelValue:l.value.sslDateRange,"onUpdate:modelValue":t[7]||(t[7]=o=>l.value.sslDateRange=o),type:"daterange","start-placeholder":"인증서 등록일","end-placeholder":"인증서 만료일",format:"YYYY/MM/DD","value-format":"YYYY-MM-DD",class:"!w-full"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["modelValue","before-close"])])}}};export{ge as default};

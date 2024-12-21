import{o as L,i as O,s as F,x as J,r as _,a as n,b as K,c as Q,d as u,k as e,u as f,f as a,J as z,g as p,$ as G,K as W,t as M,m as g,Q as X}from"./index-DFO3MUi4.js";import{f as Z,c as ee,r as le,a as ae,e as te,n as k,N as P}from"./confirm-DrgE0thk.js";const oe={class:"section-area"},ne={class:"article-area",style:{display:"flex","justify-content":"space-between","align-items":"center"}},re={style:{"text-align":"end"}},se={class:"article-area pt-4"},de={style:{display:"flex","align-items":"center"}},ie=`
        <path class="path" d="
          M 30 15
          L 28 17
          M 25.61 25.61
          A 15 15, 0, 0, 1, 15 30
          A 15 15, 0, 1, 1, 27.99 7.5
          L 15 15
        " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
`,ce={__name:"ProjectMngPage",setup(ue){L(()=>{Y()});const D=O("axios");F(),J();const v=_(),R=_({projectName:[{required:!0,message:"프로젝트명을 입력해주세요",trigger:"blur"}],projectUrl:[{required:!0,message:"도메인 주소를 입력해주세요",trigger:"blur"}],containerName:[{required:!0,message:"컨테이너명을 입력해주세요",trigger:"blur"}],imageName:[{required:!0,message:"이미지명을 입력해주세요",trigger:"blur"}],etrPort:[{required:!0,message:"외부포트를 입력해주세요",trigger:"blur"}],itrPort:[{required:!0,message:"내부포트를 입력해주세요",trigger:"blur"}]}),V=_([]),c=_(!1),l=_({projectUid:null,projectName:"",projectUrl:"",containerName:"",imageName:"",etrPort:"",itrPort:"",domainDateRange:[],sslDateRange:[],domainSdate:"",domainEdate:"",sslSdate:"",sslEdate:""}),Y=()=>{D.get("/docker/project").then(r=>{V.value=r.data})},U=r=>{c.value=!0,y()},E=()=>{v.value.validate(r=>{r&&(l.value.domainDateRange.length===2&&(l.value.domainSdate=g(l.value.domainDateRange[0]).format("YYYY-MM-DD"),l.value.domainEdate=g(l.value.domainDateRange[1]).format("YYYY-MM-DD")),l.value.sslDateRange.length===2&&(l.value.sslSdate=g(l.value.sslDateRange[0]).format("YYYY-MM-DD"),l.value.sslEdate=g(l.value.sslDateRange[1]).format("YYYY-MM-DD")),le().then(()=>{D.post("/docker/project/save",l.value).then(()=>{c.value=!1,ae(),Y()})}))})},S=r=>{y(),c.value=!0,l.value=Object.assign({},r),l.value.domainDateRange=[l.value.domainSdate,l.value.domainEdate],l.value.sslDateRange=[l.value.sslSdate,l.value.sslEdate]},y=()=>{v.value&&v.value.clearValidate(),l.value={projectUid:null,projectName:"",projectUrl:"",containerName:"",imageName:"",etrPort:"",itrPort:"",domainDateRange:[],sslDateRange:[],domainSdate:"",domainEdate:"",sslSdate:"",sslEdate:""}},x=()=>{Y(),Z()},C=r=>{te(`선택하신 " ${r.projectName} " 프로젝트를 배포하시겠습니까?`,"프로젝트 배포").then(()=>{const t=X.service({lock:!0,text:"프로젝트 배포중",spinner:ie,svgViewBox:"-10, -10, 50, 50",background:"rgba(0, 0, 0, 0.7)",fullscreen:!0});D.post("/docker/deploy",r).then(s=>{k("배포 성공",`${r.containerName} 컨테이너가 실행되었습니다`,P.SUCCESS)}).catch(()=>{k("배포 실패",`${r.containerName} 컨테이너 배포에 실패했습니다`,P.Error)}).finally(()=>{t.close()})})};return(r,t)=>{const s=n("el-input"),b=n("el-button"),h=n("el-tag"),m=n("el-table-column"),q=n("Setting"),N=n("el-icon"),$=n("VideoPlay"),H=n("el-table"),d=n("el-form-item"),i=n("el-descriptions-item"),j=n("el-date-picker"),w=n("el-row"),T=n("el-descriptions"),A=n("el-form"),B=n("el-dialog");return K(),Q("section",oe,[u("article",ne,[u("div",null,[e(s,{style:{width:"250px"},"suffix-icon":f(z),placeholder:"검색어를 입력해주세요"},null,8,["suffix-icon"])]),u("div",re,[u("div",null,[e(b,{onClick:x,icon:f(G),link:""},{default:a(()=>t[10]||(t[10]=[p(" 새로고침 ")])),_:1},8,["icon"]),e(b,{onClick:U,icon:f(W),link:""},{default:a(()=>t[11]||(t[11]=[p(" 추가 ")])),_:1},8,["icon"])])])]),u("article",se,[e(H,{data:V.value,border:""},{default:a(()=>[e(m,{label:"상태",align:"center",width:"100"},{default:a(o=>[e(h,null,{default:a(()=>t[12]||(t[12]=[p(" 정상 ")])),_:1})]),_:1}),e(m,{prop:"projectName",label:"프로젝트명",width:"200"}),e(m,{prop:"projectUrl",label:"사이트 주소"}),e(m,{label:"만기일",align:"center"},{default:a(()=>[e(m,{prop:"domainEdate",label:"도메인",align:"center",width:"150"},{default:a(o=>[p(M(o.row.domainEdate?"~ "+f(g)(o.row.domainEdate).format("YYYY.MM.DD"):"미등록"),1)]),_:1}),e(m,{prop:"sslEdate",label:"인증서",align:"center",width:"150"},{default:a(o=>[p(M(o.row.sslEdate?"~ "+f(g)(o.row.sslEdate).format("YYYY.MM.DD"):"미등록"),1)]),_:1})]),_:1}),e(m,{label:"작업",align:"center",width:"150"},{default:a(o=>[u("div",de,[e(b,{class:"w-full",link:"",type:"info",onClick:I=>S(o.row)},{default:a(()=>[e(N,null,{default:a(()=>[e(q)]),_:1}),t[13]||(t[13]=p(" 관리 "))]),_:2},1032,["onClick"]),e(b,{class:"w-full",link:"",type:"primary",onClick:I=>C(o.row),disabled:o.row.etrPort===0&&o.row.itrPort===0},{default:a(()=>[e(N,null,{default:a(()=>[e($)]),_:1}),t[14]||(t[14]=p(" 배포 "))]),_:2},1032,["onClick","disabled"])])]),_:1})]),_:1},8,["data"])]),e(B,{modelValue:c.value,"onUpdate:modelValue":t[9]||(t[9]=o=>c.value=o),title:"프로젝트","align-center":"","before-close":function(o){f(ee)().then(()=>o())}},{footer:a(()=>[u("div",{onClick:t[8]||(t[8]=o=>c.value=!1)},"취소"),u("div",{onClick:E},"확인")]),default:a(()=>[e(A,{model:l.value,rules:R.value,ref_key:"frmRef",ref:v,class:"pt-1"},{default:a(()=>[e(T,{column:2,border:""},{default:a(()=>[e(i,{label:"프로젝트명","min-width":"100"},{default:a(()=>[e(d,{required:"",prop:"projectName",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.projectName,"onUpdate:modelValue":t[0]||(t[0]=o=>l.value.projectName=o),placeholder:"프로젝트명"},null,8,["modelValue"])]),_:1})]),_:1}),e(i,{label:"주소","min-width":"100"},{default:a(()=>[e(d,{required:"",prop:"projectUrl",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.projectUrl,"onUpdate:modelValue":t[1]||(t[1]=o=>l.value.projectUrl=o),placeholder:"http://www.domain.com"},null,8,["modelValue"])]),_:1})]),_:1}),e(i,{label:"컨테이너명"},{default:a(()=>[e(d,{required:"",prop:"containerName",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.containerName,"onUpdate:modelValue":t[2]||(t[2]=o=>l.value.containerName=o),placeholder:"컨테이너명"},null,8,["modelValue"])]),_:1})]),_:1}),e(i,{label:"이미지명"},{default:a(()=>[e(d,{required:"",prop:"imageName",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.imageName,"onUpdate:modelValue":t[3]||(t[3]=o=>l.value.imageName=o),placeholder:"이미지명:태그명"},null,8,["modelValue"])]),_:1})]),_:1}),e(i,{label:"외부포트"},{default:a(()=>[e(d,{required:"",prop:"etrPort",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.etrPort,"onUpdate:modelValue":t[4]||(t[4]=o=>l.value.etrPort=o),placeholder:"외부 포트",type:"number"},null,8,["modelValue"])]),_:1})]),_:1}),e(i,{label:"내부포트"},{default:a(()=>[e(d,{required:"",prop:"itrPort",class:"py-2 !mb-0"},{default:a(()=>[e(s,{modelValue:l.value.itrPort,"onUpdate:modelValue":t[5]||(t[5]=o=>l.value.itrPort=o),placeholder:"내부 포트",type:"number"},null,8,["modelValue"])]),_:1})]),_:1}),e(i,{label:"도메인"},{default:a(()=>[e(d,{prop:"domainDate",class:"py-2 !mb-0"},{default:a(()=>[e(w,null,{default:a(()=>[e(j,{modelValue:l.value.domainDateRange,"onUpdate:modelValue":t[6]||(t[6]=o=>l.value.domainDateRange=o),type:"daterange","start-placeholder":"도메인 등록일","end-placeholder":"도메인 만료일",format:"YYYY/MM/DD","value-format":"YYYY-MM-DD",class:"!w-full"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1}),e(i,{label:"인증서"},{default:a(()=>[e(d,{prop:"sslDate",class:"py-2 !mb-0"},{default:a(()=>[e(w,null,{default:a(()=>[e(j,{modelValue:l.value.sslDateRange,"onUpdate:modelValue":t[7]||(t[7]=o=>l.value.sslDateRange=o),type:"daterange","start-placeholder":"인증서 등록일","end-placeholder":"인증서 만료일",format:"YYYY/MM/DD","value-format":"YYYY-MM-DD",class:"!w-full"},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["modelValue","before-close"])])}}};export{ce as default};
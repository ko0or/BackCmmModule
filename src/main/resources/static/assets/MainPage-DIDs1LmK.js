import{b as j,q as V,r as p,s,o as x,c as H,a as _,i as t,x as o,h as n,A as y,t as u,l as v,B as Y}from"./index-CV2gUhJh.js";/* empty css                                                                     */const N={class:"section-area"},k={class:"article-area"},B={__name:"MainPage",setup(A){j(()=>{g.get("/docker/image").then(r=>{console.log("res.data : ",r.data);const i=r.data.string.trim().split(/\r?\n/).map(m=>JSON.parse(m));w.value=i}).catch(r=>{console.error("Error fetching data:",r)}),g.get("/docker/container").then(r=>{const i=r.data.string.trim().split(/\r?\n/).map(m=>JSON.parse(m));b.value=i,console.log("jsonArray : ",i)}).catch(r=>{console.error("Error fetching data:",r)})});const g=V("axios"),c=p(!1),f=p("1"),b=p([]),w=p([]);return(r,e)=>{const d=s("el-collapse-item"),i=s("el-divider"),m=s("el-button"),l=s("el-table-column"),S=s("el-table"),D=s("el-collapse"),M=s("el-dialog");return x(),H("section",N,[_("article",k,[t(D,{modelValue:f.value,"onUpdate:modelValue":e[1]||(e[1]=a=>f.value=a)},{default:o(()=>[t(d,{name:"0"},{title:o(()=>e[3]||(e[3]=[_("p",null,"내 프로젝트",-1)])),default:o(()=>[e[4]||(e[4]=n(" .. 준비중 .. "))]),_:1}),t(d,{name:"1"},{title:o(()=>[e[6]||(e[6]=_("p",null,"컨테이너 목록",-1)),t(i,{direction:"vertical","border-style":"dashed"}),t(m,{link:"",onClick:e[0]||(e[0]=y(a=>c.value=!0,["stop"]))},{default:o(()=>e[5]||(e[5]=[n("테스트 버튼")])),_:1})]),default:o(()=>[t(S,{data:b.value,border:""},{default:o(()=>[t(l,{prop:"ID",label:"컨테이너 식별자"}),t(l,{prop:"Names",label:"컨테이너명"}),t(l,{prop:"Ports",label:"포트"},{default:o(a=>[n(u(a.row.Ports||"-"),1)]),_:1}),t(l,{prop:"State",label:"상태"},{default:o(a=>[n(u(a.row.State==="created"&&"실행전"||a.row.State==="running"&&"실행중"||a.row.State==="paused"&&"일시정지"||a.row.State==="restarting"&&"재시작중"||a.row.State==="exited"&&"실행 실패"||a.row.State==="dead"&&"중단(복구불가)"||a.row.State==="removing"&&"삭제중"||a.row.State||"-"),1)]),_:1}),t(l,{prop:"Image",label:"연관 이미지"}),t(l,{label:"생성일시",align:"center"},{default:o(a=>[n(u(v(Y)(a.row.CreatedAt,"YYYY-MM-DD HH:mm:ss Z").format("YYYY.MM.DD HH:mm")),1)]),_:1})]),_:1},8,["data"])]),_:1}),t(d,{name:"2"},{title:o(()=>e[7]||(e[7]=[n(" 이미지 목록 ")])),default:o(()=>[t(S,{data:w.value,border:""},{default:o(()=>[t(l,{prop:"ID",label:"이미지 식별자"}),t(l,{prop:"Repository",label:"저장소"}),t(l,{prop:"Tag",label:"태그"}),t(l,{prop:"Size",label:"크기"}),t(l,{label:"생성일시",align:"center"},{default:o(a=>[n(u(v(Y)(a.row.CreatedAt,"YYYY-MM-DD HH:mm:ss Z").format("YYYY.MM.DD HH:mm")),1)]),_:1})]),_:1},8,["data"])]),_:1})]),_:1},8,["modelValue"]),t(M,{modelValue:c.value,"onUpdate:modelValue":e[2]||(e[2]=a=>c.value=a),title:"테스트","align-center":""},{default:o(()=>e[8]||(e[8]=[n(" 테스트중입니다 ")])),_:1},8,["modelValue"])])])}}};export{B as default};

import{_ as ee,q as $,r as y,z as te,s as c,o as v,c as C,a as i,i as r,x as a,h as m,I as oe,d as E,t as F,A as ne,D as le,J as O,F as se}from"./index-BA4-j57R.js";const de={class:"space-y-2"},re={class:"text-right"},ae={key:0},ie={class:"flex items-center justify-between w-full pr-1"},ce={key:0},ue={key:0},pe={key:1},fe={__name:"CodeMng",props:{data:{type:Array,required:!0},saveUrl:{type:String,default:"code"},showNodeKey:{type:Boolean,default:!1},nodeKey:{type:String,default:"id"},uprNodeKey:{type:String,default:"uprId"},treeProps:{type:Object,default:{label:"label",value:"value"}},codeType:{type:String,default:"CD"},draggable:{type:Boolean,default:!1},filter:{type:Boolean,default:!1}},emits:["keyupEnter","nodeSelect"],setup(V,{expose:I,emit:U}){const Y=$("axios"),j=$("msg"),B=U,o=V,_={CODE:"코드",CATEGORY:"카테고리"},T=y(null),g=y(null),K=y(null),A=y(),u=y(o.data),h=y("");te(h,t=>{K.value.filter(t)});const G=t=>{w(t[o.nodeKey])},M=t=>{T.value=t[o.nodeKey],f(t)?g.value=_.CATEGORY:g.value=_.CODE,A.value.open()},q=(t,e)=>{f(t)&&(e.expanded=!e.expanded),B("nodeSelect",t)},z=t=>{const e=t.target.dataset.key;switch(t.key){case"ArrowUp":case"ArrowDown":B("nodeSelect",S(e));return;case"+":case"Insert":w(e);return;case"-":case"Delete":case"Backspace":D(e);return;case"Enter":B("keyupEnter",S(e));return}},L=(t,e,d,n)=>{const l=t.data,s=P(l[o.nodeKey]);s?l[o.uprNodeKey]=s[o.nodeKey]:l[o.uprNodeKey]=null,b()},J=()=>{Y.post(o.saveUrl,o.data[0]).then(()=>{j({message:"저장되었습니다",type:"success"})})},H=(t,e,d)=>{if(!t)return!0;const n=o.treeProps.label;return e[n].includes(t)},N=t=>{let e=null,d=null;const n=l=>{for(const s of l){if(console.debug("노드 순회중... : ",s),f(s)&&s.children.find(k=>k[o.nodeKey]==t)&&(d=s,console.debug("부모 노드 발견 : ",s)),s[o.nodeKey]==t){e=s,console.debug("대상 노드 발견 : ",s);return}f(s)&&n(s.children)}};return n(u.value),{node:e,parentNode:d}},S=t=>{const{node:e}=N(t);return e},P=t=>{const{parentNode:e}=N(t);return e},w=t=>{const{node:e,parentNode:d}=N(t);e.children.push({[o.nodeKey]:null,[o.treeProps.label]:"생성된 노드",children:[],[o.uprNodeKey]:t}),b(),u.value=[...u.value]},D=t=>{alert(t);const{node:e,parentNode:d}=N(t);if(f(d)){const n=d.children.findIndex(l=>l[o.nodeKey]==t);d.children.splice(n,1),u.value=[...u.value]}b()},f=t=>t.children&&t.children.length>0,b=()=>{const t={type:o.codeType,category:0,no:1},e=n=>n[o.uprNodeKey]==t.type+"00000001",d=n=>{for(const l of n){e(l)&&(t.category++,t.no=1);const s=t.type+String(t.category).padStart(4,"0")+String(t.no++).padStart(4,"0");l[o.nodeKey]=s,f(l)&&(l.children.forEach(k=>k[o.uprNodeKey]=s),d(l.children))}};d(u.value)},R=t=>{e(K.value.root.childNodes);function e(d){for(const n of d)t?n.expand():n.collapse(),n.childNodes&&e(n.childNodes)}};return I({initNodeKeys:b,addNodeByKey:w,removeNodeByKey:D,getNodeByKey:S,getParentNodeByKey:P,getNodeAndParentNodeByKey:N}),(t,e)=>{const d=c("RemoveFilled"),n=c("el-icon"),l=c("el-button"),s=c("CirclePlusFilled"),k=c("el-input"),Q=c("Check"),W=c("el-tree"),X=c("CmmDialog");return v(),C(se,null,[i("div",de,[i("div",re,[i("div",null,[r(l,{link:"",onClick:e[0]||(e[0]=p=>R(!1))},{default:a(()=>[r(n,null,{default:a(()=>[r(d)]),_:1}),e[6]||(e[6]=m("  ")),e[7]||(e[7]=i("p",null,"모두 접기",-1))]),_:1}),r(l,{link:"",onClick:e[1]||(e[1]=p=>R(!0))},{default:a(()=>[r(n,null,{default:a(()=>[r(s)]),_:1}),e[8]||(e[8]=m("  ")),e[9]||(e[9]=i("p",null,"모두 확장",-1))]),_:1})])]),o.filter?(v(),C("div",ae,[r(k,{modelValue:h.value,"onUpdate:modelValue":e[2]||(e[2]=p=>h.value=p),placeholder:"코드명으로 검색",onKeyup:e[3]||(e[3]=oe(p=>K.value.filter(h.value),["enter"])),clearable:""},null,8,["modelValue"])])):E("",!0),r(l,{size:"large",class:"w-full",type:"primary",onClick:J},{default:a(()=>[r(n,null,{default:a(()=>[r(Q)]),_:1}),e[10]||(e[10]=m("  저장하기 "))]),_:1}),i("div",null,[r(W,{props:o.treeProps,"node-key":o.nodeKey,data:u.value,ref_key:"treeRef",ref:K,draggable:o.draggable,"filter-node-method":H,"expand-on-click-node":!1,"default-expand-all":"",onNodeClick:q,onKeyup:z,onNodeDrop:L},{default:a(({node:p,data:x})=>[i("span",ie,[i("span",null,[m(F(p.label)+" ",1),o.showNodeKey?(v(),C("span",ce,"("+F(x[o.nodeKey])+")",1)):E("",!0)]),i("span",{class:"space-x-4",onClick:e[4]||(e[4]=ne(()=>{},["stop"]))},[x[o.uprNodeKey]?(v(),le(l,{key:0,link:"",class:"!p-0",onClick:Z=>M(x)},{default:a(()=>[O(t.$slots,"removeBtn",{},()=>[e[11]||(e[11]=m(" 삭제 "))],!0)]),_:2},1032,["onClick"])):E("",!0),r(l,{link:"",class:"!p-0",onClick:Z=>G(x)},{default:a(()=>[O(t.$slots,"addBtn",{},()=>[e[12]||(e[12]=m(" 추가 "))],!0)]),_:2},1032,["onClick"])])])]),_:3},8,["props","node-key","data","draggable"])])]),r(X,{title:`${g.value} 삭제`,ref_key:"delConfirmRef",ref:A,confirm:"",onConfirm:e[5]||(e[5]=p=>D(T.value))},{default:a(()=>[g.value==_.CODE?(v(),C("p",ue," 선택된 코드를 정말 삭제하시겠습니까? ")):g.value==_.CATEGORY?(v(),C("p",pe," 선택된 카테고리 및 하위 코드까지 함께 삭제됩니다. 정말 삭제하시겠습니까? ")):E("",!0)]),_:1},8,["title"])],64)}}},ve=ee(fe,[["__scopeId","data-v-2b35002b"]]);export{ve as C};

import{b as w,q as u,u as y,k as _,r as i,s as a,o as h,c as k,a as e,i as l,x as r,A as I,h as d,K as B}from"./index-Cb5hVYHm.js";import{n as S,N}from"./confirm-Cf7SoJ2X.js";const E={class:"section-area h-dvh"},D={class:"article-area h-full pt-20"},M={class:"flex overflow-hidden"},T={class:"w-full flex flex-col justify-center flex-1 px-4 py-12 sm:px-6 lg:flex-none lg:px-20 xl:px-24"},V={class:"w-full max-w-xl mx-auto lg:w-96"},j={class:"mt-8"},C={class:"mt-6"},O={class:"flex justify-between items-center"},H={__name:"LoginPage",setup(q){w(()=>{const s=localStorage.getItem("loginID");s?(document.getElementById("username").value=JSON.parse(s),document.getElementById("password").focus(),o.value=!0):document.getElementById("username").focus()});const c=u("info"),m=u("axios"),[A,f]=[y(),_()];i(!1);const o=i(!1),p=()=>{const s=document.getElementById("username").value,t=document.getElementById("password").value;m.post("/auth/login",{username:s,password:t}).then(n=>{o.value&&localStorage.setItem("loginID",JSON.stringify(s)),c.setToken(n.data.token),f.push({name:"메인"})}).catch(()=>{S("로그인 실패","아이디 혹은 비밀번호가 일치하지않습니다",N.Warning)})},x=()=>{B.alert("내용")};return(s,t)=>{const n=a("el-checkbox"),g=a("el-button"),b=a("el-form");return h(),k("section",E,[e("article",D,[e("div",M,[e("div",T,[e("div",V,[t[6]||(t[6]=e("div",null,[e("h2",{class:"mt-6 mb-4 text-3xl font-black text-center text-neutral-600"}," 도커 관리시스템 "),e("div",{class:"text-blue-600 text-medium text-center"}," DMS · DockerManagementService ")],-1)),e("div",j,[e("div",C,[l(b,{onSubmit:I(p,["prevent"]),class:"space-y-6"},{default:r(()=>[t[3]||(t[3]=e("div",null,[e("label",{for:"username",class:"block text-sm font-medium text-neutral-600 mb-4"}," Login ID "),e("div",{class:"mt-1"},[e("input",{id:"username",name:"username",type:"text",autocomplete:"email",required:"",placeholder:"username",class:"block w-full px-5 py-3 text-base placeholder-gray-300 transition duration-500 ease-in-out transform border border-transparent rounded-lg text-neutral-600 bg-gray-50 focus:outline-none focus:border-transparent focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-300"})])],-1)),t[4]||(t[4]=e("div",{class:"space-y-1"},[e("label",{for:"password",class:"block text-sm font-medium text-neutral-600 mb-4"}," Password "),e("div",{class:"mt-1"},[e("input",{id:"password",name:"password",type:"password",autocomplete:"current-password",required:"",placeholder:"password",class:"block w-full px-5 py-3 text-base placeholder-gray-300 transition duration-500 ease-in-out transform border border-transparent rounded-lg text-neutral-600 bg-gray-50 focus:outline-none focus:border-transparent focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-300"})])],-1)),e("div",O,[l(n,{modelValue:o.value,"onUpdate:modelValue":t[0]||(t[0]=v=>o.value=v)},{default:r(()=>t[1]||(t[1]=[d(" 아이디 저장 ")])),_:1},8,["modelValue"]),l(g,{link:"",onClick:x},{default:r(()=>t[2]||(t[2]=[d(" 비밀번호 찾기 ")])),_:1})]),t[5]||(t[5]=e("div",null,[e("button",{type:"submit",class:"flex items-center justify-center w-full px-10 py-4 text-base font-medium text-center text-white transition duration-500 ease-in-out transform bg-blue-600 rounded-xl hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"}," 로그인 ")],-1))]),_:1})])])])])])])])}}};export{H as default};

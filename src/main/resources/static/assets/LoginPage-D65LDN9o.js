import{z as d,o as _,c as k,u as f,j as h,b as m,_ as v,r as p,w as L,a as n,h as u,F as w,H as I,m as C,p as R,D as b}from"./index-DjHCyUli.js";const x="/assets/oauthBtn/oauth-naver-bg.png",$="/assets/oauthBtn/oauth-kakao-bg.png",E="/assets/oauthBtn/googleIcon.png",A={id:"G_OAuth_btn"},B="https://dangcoding.kro.kr/oauth2/google",y={__name:"GoogleLogin",emits:["update:modelValue"],setup(c,{expose:t,emit:i}){const o=d("googleApiKey");return t({handleLoginClick:()=>{window.location.href=`https://accounts.google.com/o/oauth2/v2/auth?client_id=${o}&redirect_uri=${B}&response_type=code&scope=profile`}}),(a,l)=>(_(),k("div",A))}},K={__name:"KakaoLogin",setup(c,{expose:t}){const[i,o]=[f(),h()],s=d("kakaoApiKey");m(()=>{try{a()}catch{}});const a=()=>{window.Kakao.init(s)};return t({handleLoginClick:e=>{window.Kakao.Auth.login({success:function(r){window.Kakao.API.request({url:"/v2/user/me",success:S=>{o.push({name:"카카오로그인",query:{accessToken:r.access_token}})}})}})},unlink:()=>{Kakao.API.request({url:"/v1/user/unlink",success:function(){console.debug("회원 탈퇴 성공")}})}}),(e,r)=>null}},N={id:"naverIdLogin"},G="tmYZCB0t96FTGqeQHsFF",O="http://localhost:3000/oauth2/naver",P={__name:"NaverLogin",setup(c,{expose:t}){m(()=>{o().setNaver()});const i=()=>{document.querySelector("#naverIdLogin_loginButton").click()},o=()=>{const s=new window.naver.LoginWithNaverId({clientId:G,callbackUrl:O,isPopup:!1,loginButton:{color:"green",type:3,height:60}});return{setNaver:()=>{s.init()}}};return t({handleLoginClick:i}),(s,a)=>(_(),k("div",N))}},q={class:"sns-login--btn-list"},D={__name:"OAuthLogin",setup(c){const[t,i]=[f(),h()],o=p(),s=p(),a=p(),l=g=>{sessionStorage.setItem("LoginBeforePage",t.path),g.handleLoginClick()};return(g,e)=>(_(),k(w,null,[L(n("article",null,[u(y,{ref_key:"googleRef",ref:o},null,512),u(K,{ref_key:"kakaoRef",ref:s},null,512),u(P,{ref_key:"naverRef",ref:a},null,512)],512),[[I,!1]]),n("article",q,[n("button",{onClick:e[0]||(e[0]=r=>l(a.value)),class:"sns-login--naver"},e[3]||(e[3]=[n("img",{src:x,alt:"네이버 간편 로그인",width:"24"},null,-1),n("span",null," 네이버 로그인 ",-1)])),n("button",{onClick:e[1]||(e[1]=r=>l(s.value)),class:"sns-login--kakao"},e[4]||(e[4]=[n("img",{src:$,alt:"카카오톡 간편 로그인",width:"24"},null,-1),n("span",null," 카카오 로그인 ",-1)])),n("button",{onClick:e[2]||(e[2]=r=>l(o.value)),class:"sns-login--google"},e[5]||(e[5]=[n("img",{src:E,alt:"구글 간편 로그인 버튼"},null,-1),n("span",null," 구글 로그인 ",-1)]))])],64))}},F=v(D,[["__scopeId","data-v-bb4d1321"]]),T={class:"article-area"},U={__name:"LoginPage",setup(c){return d("info"),(t,i)=>(_(),C(b,{title:"로그인",class:"flex flex-col"},{default:R(()=>[n("article",T,[u(F)])]),_:1}))}};export{U as default};
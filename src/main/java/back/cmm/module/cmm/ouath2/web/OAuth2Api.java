package back.cmm.module.cmm.ouath2.web;

import back.cmm.module.cmm.ouath2.service.OAuth2Service;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth2")
public class OAuth2Api {

    @Resource private OAuth2Service oAuth2Service;

    @GetMapping("kakao/{accessToken}")
    public ResponseEntity<Object> kakaoLogin(@PathVariable(name = "accessToken") String accessToekn) {
        return oAuth2Service.kakaoLogin(accessToekn);
    }

    @GetMapping("naver/{accessToken}")
    public ResponseEntity<Object> naverLogin(@PathVariable(name = "accessToken") String accessToekn) {
        return oAuth2Service.naverLogin(accessToekn);
    }

    @GetMapping("google")
    public ResponseEntity<Object> googleLogin(@RequestParam(name = "code") String code) {
        return oAuth2Service.googleLogin(code);
    }


/*    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String REDIRECT_URI ;

    private String GRANT_TYPE = "authorization_code";
    private String TOKEN_INFO_URI = "https://kauth.kakao.com/oauth/token";
    private String USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";


    // FIXME : 결과에서 이메일,썸넬 .. 등 특정 필드만 뽑아오기*/

/*    @GetMapping("test")
    public String test(@RequestParam(name = "code") String code) {

//        sysoutConfig();

        String token = getTokenByCode(code);
        ResponseEntity<Object> resultObj = getInfoByToekenAndCode(token, code);

        System.out.println("호출 결과 -> " + resultObj);
        return "콘솔 확인 ㄱㄱ";

    }
    



    public String getTokenByCode(String code) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", GRANT_TYPE); //고정값
        params.add("client_id", CLIENT_ID);
        params.add("redirect_uri", REDIRECT_URI); //등록한 redirect uri
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(
                TOKEN_INFO_URI,
                HttpMethod.POST,
                httpEntity,
                Map.class
        );

        System.out.println("token = " + response.getBody().get("access_token"));
        return response.getBody().get("access_token").toString();

    }
    
    public ResponseEntity<Object> getInfoByToekenAndCode(String token, String code) {

        System.out.println("카카오 로긴용 코드 : " + code);

        HttpHeaders httpHeaders2 = new HttpHeaders();
        httpHeaders2.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders2.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        HttpEntity<MultiValueMap<String, String>> httpEntity2 = new HttpEntity<>(httpHeaders2);
        RestTemplate restTemplate2 = new RestTemplate();

        return restTemplate2.exchange(
                USER_INFO_URI,
                HttpMethod.GET,
                httpEntity2,
                Object.class
        );

    }*/

}

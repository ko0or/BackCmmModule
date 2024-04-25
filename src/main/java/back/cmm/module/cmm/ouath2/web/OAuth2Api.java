package back.cmm.module.cmm.ouath2.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/ouath")
public class OAuth2Api {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String REDIRECT_URI ;

    private String GRANT_TYPE = "authorization_code";
    private String TOKEN_INFO_URI = "https://kauth.kakao.com/oauth/token";
    private String USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";


    // FIXME : 결과에서 이메일,썸넬 .. 등 특정 필드만 뽑아오기

    @GetMapping("test")
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

    }

    public void sysoutConfig() {
        System.out.println("CLIENT_ID " + CLIENT_ID);
        System.out.println("REDIRECT_URI " + REDIRECT_URI);
        System.out.println("GRANT_TYPE " + GRANT_TYPE);
        System.out.println("USER_INFO_URI " + TOKEN_INFO_URI);
        System.out.println("USER_INFO_URI " + USER_INFO_URI);
    }
}

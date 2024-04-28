package back.cmm.module.cmm.ouath2.service;

import back.cmm.module.cmm.ouath2.config.OAuth2GoogleConfig;
import back.cmm.module.cmm.ouath2.config.OAuth2KakaoConfig;
import back.cmm.module.cmm.ouath2.config.OAuth2NaverConfig;
import jakarta.annotation.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OAuth2ServiceImpl implements OAuth2Service {

    @Resource private OAuth2GoogleConfig googleConfig;
    @Resource private OAuth2KakaoConfig kakaoConfig;
    @Resource private OAuth2NaverConfig naverConfig;


    @Override
    public ResponseEntity<Object> kakaoLogin(String accessToken) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> result = restTemplate.exchange(
                kakaoConfig.getUSER_INFO_URI(),
                HttpMethod.GET,
                httpEntity,
                Object.class
        );

        System.out.println("$$$$$ 카카오 로그인 결과 -> " + result);        
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Object> naverLogin(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> result = restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                httpEntity,
                Object.class
        );

        System.out.println("$$$$$ 네이버 로그인 결과 -> " + result);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Object> googleLogin(String code) {

        RestTemplate restTemplate=new RestTemplate();
        Map<String, String> params = new HashMap<>();
        System.out.println("@#@#@# 구글 로그인 코드 -> " + code);

        params.put("code", code);
        params.put("client_id", googleConfig.getGOOGLE_CLIENT_ID());
        params.put("client_secret", googleConfig.getGOOGLE_CLIENT_SECRET());
        params.put("redirect_uri", googleConfig.getLOGIN_REDIRECT_URL());
        params.put("grant_type", "authorization_code");

        ResponseEntity<Object> result = restTemplate.postForEntity(
                googleConfig.getGOOGLE_TOKEN_URL(),
                params,
                Object.class
        );

        if(result.getStatusCode() == HttpStatus.OK){
            System.out.println("$$$$$ 구글 로그인 결과 -> " + result);
            return result;
        }

        return null;

/*        // https://oauth2.googleapis.com/token
        //  client_id, client_secret, code, grant_type, redirect_uri
        String decode = URLDecoder.decode(code, StandardCharsets.UTF_8);
        System.out.println("@#@#@# 구글 로그인 코드 -> " + decode);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

//        Map<String, String> params = new HashMap<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", decode);
        params.add("client_id", googleConfig.getGOOGLE_CLIENT_ID());
        params.add("client_secret", googleConfig.getGOOGLE_CLIENT_SECRET());
        params.add("redirect_uri", googleConfig.getLOGIN_REDIRECT_URL());
        params.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> result = restTemplate.exchange(
                "https://oauth2.googleapis.com/token",
                HttpMethod.POST,
                httpEntity,
                Object.class
        );

        System.out.println("$$$$$ 구글 로그인 결과 -> " + result);
        return ResponseEntity.ok(result);*/
    }

}
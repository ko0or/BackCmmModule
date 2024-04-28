package back.cmm.module.cmm.ouath2.service;

import back.cmm.module.cmm.ouath2.config.OAuth2GoogleConfig;
import back.cmm.module.cmm.ouath2.config.OAuth2KakaoConfig;
import back.cmm.module.cmm.ouath2.config.OAuth2NaverConfig;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OAuth2ServiceImpl implements OAuth2Service {

    @Resource private OAuth2GoogleConfig googleConfig;
    @Resource private OAuth2KakaoConfig kakaoConfig;
    @Resource private OAuth2NaverConfig naverConfig;


    @Override
    public ResponseEntity<Object> kakaoLogin(String accessToken) {

        System.out.println("@$@$@$ 카카오 로그인 엑세스 토큰 -> " + accessToken);

        /*
         * 1. 카카오 로그인 성공후 코드 -> 엑세스 토큰 요청
         * */

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", kakaoConfig.getGRANT_TYPE()); //고정값
//        params.add("client_id", kakaoConfig.getCLIENT_ID());
//        params.add("redirect_uri", kakaoConfig.getREDIRECT_URI());
//        params.add("code", loginCode);
//
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, httpHeaders);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Map> response = restTemplate.exchange(
//                kakaoConfig.getTOKEN_INFO_URI(),
//                HttpMethod.POST,
//                httpEntity,
//                Map.class
//        );
//
//        System.out.println("token = " + response.getBody().get("access_token"));
//        String accessToken = response.getBody().get("access_token").toString();

        /*
         * 2. 엑세스 토큰으로 사용자 정보 요청
         * */

        HttpHeaders httpHeaders2 = new HttpHeaders();
        httpHeaders2.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders2.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity2 = new HttpEntity<>(httpHeaders2);
        RestTemplate restTemplate2 = new RestTemplate();
        ResponseEntity<Object> result = restTemplate2.exchange(
                kakaoConfig.getUSER_INFO_URI(),
                HttpMethod.GET,
                httpEntity2,
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
    public ResponseEntity<Object> googleLogin(String accessToken) {
        return null;
    }

}
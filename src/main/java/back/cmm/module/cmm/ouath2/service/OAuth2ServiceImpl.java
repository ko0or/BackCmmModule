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
    public ResponseEntity<Object> googleLogin(String accessToken) {
        return null;
    }

}
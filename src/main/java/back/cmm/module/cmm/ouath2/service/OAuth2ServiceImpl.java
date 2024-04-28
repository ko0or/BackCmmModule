package back.cmm.module.cmm.ouath2.service;

import back.cmm.module.cmm.ouath2.config.OAuth2GoogleConfig;
import back.cmm.module.cmm.ouath2.config.OAuth2KakaoConfig;
import back.cmm.module.cmm.ouath2.config.OAuth2NaverConfig;
import back.cmm.module.cmm.ouath2.dto.OAuth2GoogleDto;
import back.cmm.module.cmm.ouath2.dto.OAuth2KakaoDto;
import back.cmm.module.cmm.ouath2.dto.OAuth2NaverDto;
import back.cmm.module.cmm.security.dao.UserAuthorityRepository;
import back.cmm.module.cmm.security.dao.UserRepository;
import back.cmm.module.cmm.security.domain.AuthorityBean;
import back.cmm.module.cmm.security.domain.UserAuthorityBean;
import back.cmm.module.cmm.security.domain.UserAuthorityPKBean;
import back.cmm.module.cmm.security.domain.UserBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.impl.Base64UrlCodec;
import jakarta.annotation.Resource;
import org.springframework.http.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class OAuth2ServiceImpl implements OAuth2Service {

    public enum LOGIN_TYPE {
        GOOGLE,
        KAKAO,
        NAVER
    }
    public enum ROLE {
        ROLE_USER,
        ROLE_MANAGER,
        ROLE_ADMIN
    }

    @Resource private OAuth2GoogleConfig googleConfig;
    @Resource private OAuth2KakaoConfig kakaoConfig;
    @Resource private OAuth2NaverConfig naverConfig;
    @Resource private UserRepository userRepository;
    @Resource private UserAuthorityRepository userAuthorityRepository;



    @Override
    public ResponseEntity<Object> kakaoLogin(String accessToken) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OAuth2KakaoDto> result = restTemplate.exchange(
                kakaoConfig.getUSER_INFO_URI(),
                HttpMethod.GET,
                httpEntity,
                OAuth2KakaoDto.class
        );

        if(result.getStatusCode() == HttpStatus.OK){
            System.out.println("$$$$$ 카카오 로그인 결과 -> " + result.getBody());
            System.out.println("$$$$$ 카카오 로그인 결과 [nickname] -> " + result.getBody().getKakao_account().getProfile().getNickname());
            System.out.println("$$$$$ 카카오 로그인 결과 [image] -> " + result.getBody().getKakao_account().getProfile().getProfile_image_url());
            System.out.println("$$$$$ 카카오 로그인 결과 [thumb] -> " + result.getBody().getKakao_account().getProfile().getThumbnail_image_url());
            System.out.println("$$$$$ 카카오 로그인 결과 [email] -> " + result.getBody().getKakao_account().getEmail());
            /**/
            Optional<UserBean> userBean = userRepository.findOneWithAuthoritiesByUsername(result.getBody().getKakao_account().getEmail());
            if (userBean.isEmpty()) {
                UserBean saved = userRepository.save(
                        new UserBean(
                                null,
                                result.getBody().getKakao_account().getEmail(),
                                null,
                                result.getBody().getKakao_account().getProfile().getNickname(),
                                "Y",
                                result.getBody().getKakao_account().getProfile().getProfile_image_url(),
                                null
                        )
                );
                userAuthorityRepository.save(
                        new UserAuthorityBean(
                                new UserAuthorityPKBean(saved.getUserId(), ROLE.ROLE_USER.toString())
                        )
                );
            }
            /**/
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("로그인 실패");
    }

    @Override
    public ResponseEntity<Object> naverLogin(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OAuth2NaverDto> result = restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                httpEntity,
                OAuth2NaverDto.class
        );

        if(result.getStatusCode() == HttpStatus.OK){
            System.out.println("$$$$$ 네이버 로그인 결과 -> " + result.getBody());
            System.out.println("$$$$$ 네이버 로그인 결과 [id] -> " + result.getBody().getResponse().getId());
            System.out.println("$$$$$ 네이버 로그인 결과 [name] -> " + result.getBody().getResponse().getName());
            System.out.println("$$$$$ 네이버 로그인 결과 [profile] -> " + result.getBody().getResponse().getProfile_image());
            /**/
            Optional<UserBean> userBean = userRepository.findOneWithAuthoritiesByUsername(result.getBody().getResponse().getId());
            if (userBean.isEmpty()) {
                UserBean saved = userRepository.save(
                        new UserBean(
                                null,
                                result.getBody().getResponse().getId(),
                                null,
                                result.getBody().getResponse().getName(),
                                "Y",
                                result.getBody().getResponse().getProfile_image(),
                                null
                        )
                );
                userAuthorityRepository.save(
                        new UserAuthorityBean(
                                new UserAuthorityPKBean(saved.getUserId(), ROLE.ROLE_USER.toString())
                        )
                );
            }
            /**/
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("로그인 실패");
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

        ResponseEntity<OAuth2GoogleDto> result = restTemplate.postForEntity(
                googleConfig.getGOOGLE_TOKEN_URL(),
                params,
                OAuth2GoogleDto.class
        );

        if(result.getStatusCode() == HttpStatus.OK){

            byte[] decode = new Base64UrlCodec().decode(result.getBody().getId_token().split("\\.")[1]);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, String> resultMap = objectMapper.readValue(decode, Map.class);
                System.out.println("$$$$$ 구글 로그인 결과 [json : name] -> " + resultMap.get("name"));
                System.out.println("$$$$$ 구글 로그인 결과 [json : picture] -> " + resultMap.get("picture"));
                System.out.println("$$$$$ 구글 로그인 결과 [json : sub] -> " + resultMap.get("sub"));

                result.getBody().setName(resultMap.get("name"));
                result.getBody().setPicture(resultMap.get("picture"));
                result.getBody().setSub(resultMap.get("sub"));

                System.out.println("$$$$$ 구글 로그인 결과 [dto] -> " + result.getBody());
                /**/
                Optional<UserBean> userBean = userRepository.findOneWithAuthoritiesByUsername(result.getBody().getSub());
                if (userBean.isEmpty()) {
                    UserBean saved = userRepository.save(
                            new UserBean(
                                    null,
                                    result.getBody().getSub(),
                                    null,
                                    result.getBody().getName(),
                                    "Y",
                                    result.getBody().getPicture(),
                                    null
                            )
                    );
                    userAuthorityRepository.save(
                            new UserAuthorityBean(
                                    new UserAuthorityPKBean(saved.getUserId(), ROLE.ROLE_USER.toString())
                            )
                    );
                }
                /**/

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("로그인 실패");

    }

}
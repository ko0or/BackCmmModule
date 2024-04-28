package back.cmm.module.cmm.ouath2.service;

import org.springframework.http.ResponseEntity;

public interface OAuth2Service {

    ResponseEntity<Object> kakaoLogin(String accessToken);
    ResponseEntity<Object> naverLogin(String accessToken);
    ResponseEntity<Object> googleLogin(String accessToken);

}

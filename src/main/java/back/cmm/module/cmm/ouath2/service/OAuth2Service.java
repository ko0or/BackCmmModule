package back.cmm.module.cmm.ouath2.service;

import back.cmm.module.cmm.security.dto.TokenDto;
import org.springframework.http.ResponseEntity;

public interface OAuth2Service {

    ResponseEntity<TokenDto> kakaoLogin(String accessToken);
    ResponseEntity<TokenDto> naverLogin(String accessToken);
    ResponseEntity<TokenDto> googleLogin(String code);

}

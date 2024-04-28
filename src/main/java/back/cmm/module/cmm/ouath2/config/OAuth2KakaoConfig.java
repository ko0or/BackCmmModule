package back.cmm.module.cmm.ouath2.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class OAuth2KakaoConfig {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String REDIRECT_URI ;

    private String GRANT_TYPE = "authorization_code";
    private String TOKEN_INFO_URI = "https://kauth.kakao.com/oauth/token";
    private String USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";

}

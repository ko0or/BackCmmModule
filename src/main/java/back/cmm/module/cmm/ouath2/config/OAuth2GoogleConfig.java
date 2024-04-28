package back.cmm.module.cmm.ouath2.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OAuth2GoogleConfig {

    private final String GOOGLE_TOKEN_URL = "https://oauth2.googleapis.com/token";

    @Value("${rest-api.oauth2.access-token.google.client-id}")
    private String GOOGLE_CLIENT_ID;
    @Value("${rest-api.oauth2.access-token.google.client-secret}")
    private String GOOGLE_CLIENT_SECRET;
    @Value("${rest-api.oauth2.access-token.google.redirect-uri}")
    private String LOGIN_REDIRECT_URL;


}

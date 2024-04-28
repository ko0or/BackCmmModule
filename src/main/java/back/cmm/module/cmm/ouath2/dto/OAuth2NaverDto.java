package back.cmm.module.cmm.ouath2.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OAuth2NaverDto {

    private LoginResponse response;

    @Getter
    public class LoginResponse {
        private String id; // // 네이버에서 제공하는 사용자 고유 식별자
        private String profile_image;
        private String name;
    }

}

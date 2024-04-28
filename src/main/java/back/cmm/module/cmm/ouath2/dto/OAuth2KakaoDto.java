package back.cmm.module.cmm.ouath2.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OAuth2KakaoDto {

    private Long id;
    private String connected_at;
    private KakaoAccount kakao_account;

    @Getter
    @ToString
    public class KakaoAccount {
        private String email;
        private String profile_nickname_needs_agreement;
        private String profile_image_needs_agreement;
        private KakaoProfile profile;
        private Boolean has_email;
        private Boolean email_needs_agreement;
        private Boolean is_email_valid;
        private Boolean is_email_verified;
        @Getter
        @ToString
        public class KakaoProfile {
            private String nickname;
            private String thumbnail_image_url;
            private String profile_image_url;
            private Boolean is_default_image;
            private Boolean is_default_nickname;
        }
    }

}
package back.cmm.module.cmm.ouath2.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OAuth2GoogleDto {

    /* 로그인 성공시 */
    private String token_type;
    private String access_token;
    private String id_token;

    /* 로그인 성공후 id_token으로 사용자 정보 조회시 */
    private String name;
    private String picture;
    private String sub; // 구글에서 제공하는 사용자 고유 식별자

    public void setName(String name) {
        this.name = name;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setSub(String sub) {
        this.sub = sub;
    }

}

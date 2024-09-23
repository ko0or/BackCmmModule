package back.cmm.module.cmm.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSelfDto {

    private String username;
    private String nickname;
    private String imgLogicalNm;
    private Set<AuthorityDto> authorities;

}

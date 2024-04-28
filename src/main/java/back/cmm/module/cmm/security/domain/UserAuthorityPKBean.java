package back.cmm.module.cmm.security.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorityPKBean {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "authority_name")
    private String authorityName;

}

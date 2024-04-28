package back.cmm.module.cmm.security.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_authority")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthorityBean {

    @EmbeddedId
    private UserAuthorityPKBean id;

}

package back.cmm.module.cmm.security.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

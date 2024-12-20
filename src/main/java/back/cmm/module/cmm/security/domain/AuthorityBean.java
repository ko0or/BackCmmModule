package back.cmm.module.cmm.security.domain;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authority")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityBean {

   @Id
   @Column(name = "authority_name", length = 50)
   private String authorityName;

}

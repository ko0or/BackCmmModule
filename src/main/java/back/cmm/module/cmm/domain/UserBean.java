package back.cmm.module.cmm.domain;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@SequenceGenerator(
//        name="USER_SEQ_GEN", //시퀀스 제너레이터 이름
//        sequenceName="USER_SEQ", //시퀀스 이름
//        initialValue=1, //시작값
//        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
//        )
public class UserBean {

   @Id
   @Column(name = "user_id")
   @GeneratedValue
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//@GeneratedValue(
//           strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
//           generator="USER_SEQ_GEN" //식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
//           )
   private Long userId;

   @Column(name = "username", length = 50, unique = true)
   private String username;

   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "nickname", length = 50)
   private String nickname;

   @Column(name = "active_yn", length = 1)
   @ColumnDefault("'Y'")
   private String activeYn;

   @ManyToMany
   @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<AuthorityBean> authorities;
}

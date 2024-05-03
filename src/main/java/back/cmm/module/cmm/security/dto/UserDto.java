package back.cmm.module.cmm.security.dto;

import back.cmm.module.cmm.security.domain.UserBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   @NotNull
   @Size(min = 3, max = 50)
   private String username;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 100)
   private String password;

   @NotNull
   @Size(min = 3, max = 50)
   private String nickname;

   private String imgLogicalNm;

   private Set<AuthorityDto> authorities;

   public static UserDto from(UserBean user) {
      if(user == null) return null;

      return UserDto.builder()
              .username(user.getUsername())
              .password(user.getPassword())
              .nickname(user.getNickname())
              .imgLogicalNm(user.getImgLogicalNm())
              .authorities(user.getAuthorities().stream()
                      .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                      .collect(Collectors.toSet()))
              .build();
   }
}
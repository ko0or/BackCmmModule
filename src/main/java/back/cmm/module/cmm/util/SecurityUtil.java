package back.cmm.module.cmm.util;

import back.cmm.module.cmm.dto.UserDto;
import back.cmm.module.cmm.exception.NotFoundMemberException;
import back.cmm.module.cmm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
/*

   1. getCurrentUsername(): 현재 로그인된 유저의 로그인 ID 리턴
   2. getUserWithAuthorities(): 현재 로그인된 유저의 로그인 ID & 닉네임 & 권한 목록 리턴
   3. getUserWithAuthorities(String username): 매개변수로 받은 로그인 ID로 유저를 조회 +  로그인 ID & 닉네임 & 권한 리턴

*/
public class SecurityUtil {
   private final UserRepository userRepository;

   public static Optional<String> getCurrentUsername() {
      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication == null) {
         log.debug("Security Context에 인증 정보가 없습니다.");
         return Optional.empty();
      }
      String username = null;
      if (authentication.getPrincipal() instanceof UserDetails) {
         UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
         username = springSecurityUser.getUsername();
      } else if (authentication.getPrincipal() instanceof String) {
         username = (String) authentication.getPrincipal();
      }
      return Optional.ofNullable(username);
   }

   @Transactional(readOnly = true)
   public UserDto getUserDtoWithAuthorities(String username) {
      return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
   }

   @Transactional(readOnly = true)
   public UserDto getUserDtoWithAuthorities() {
      return UserDto.from(
              SecurityUtil.getCurrentUsername()
                      .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                      .orElseThrow(() -> new NotFoundMemberException("Member not found"))
      );
   }

}

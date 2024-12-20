package back.cmm.module.cmm.security.service;

import back.cmm.module.cmm.security.domain.UserBean;
import back.cmm.module.cmm.security.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
/* 스프링 시큐리티 로그인 로직 오버라이딩 */
public class SecurityUserDetailsServiceImpl implements UserDetailsService {
   private final UserRepository userRepository;

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String username) {
      Optional<UserBean> userBean = userRepository.findOneWithAuthoritiesByUsername(username);
      return userRepository.findOneWithAuthoritiesByUsername(username)
         .map(user -> createUser(username, user))
         .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
   }

   private org.springframework.security.core.userdetails.User createUser(String username, UserBean user) {
      if (user.getActiveYn().equals("N")) {
         throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
      }

      List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
              .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
              .collect(Collectors.toList());

      return new org.springframework.security.core.userdetails.User(
              user.getUsername(),
              user.getPassword(),
              grantedAuthorities
      );
   }
}

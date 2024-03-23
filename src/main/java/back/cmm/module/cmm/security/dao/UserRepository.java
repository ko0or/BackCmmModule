package back.cmm.module.cmm.security.dao;

import back.cmm.module.cmm.security.domain.UserBean;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserBean, Long> {
   @EntityGraph(attributePaths = "authorities")
   Optional<UserBean> findOneWithAuthoritiesByUsername(String username);
}

package back.cmm.module.cmm.security.dao;

import back.cmm.module.cmm.security.domain.AuthorityBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityBean, String> {
}

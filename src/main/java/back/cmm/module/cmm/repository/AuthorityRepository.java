package back.cmm.module.cmm.repository;

import back.cmm.module.cmm.domain.AuthorityBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityBean, String> {
}

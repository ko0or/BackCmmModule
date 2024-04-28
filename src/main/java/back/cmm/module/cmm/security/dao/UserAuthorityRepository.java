package back.cmm.module.cmm.security.dao;

import back.cmm.module.cmm.security.domain.UserAuthorityBean;
import back.cmm.module.cmm.security.domain.UserAuthorityPKBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorityRepository extends JpaRepository<UserAuthorityBean, UserAuthorityPKBean> {

}

package back.cmm.module.cmm.repository;

import back.cmm.module.cmm.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}

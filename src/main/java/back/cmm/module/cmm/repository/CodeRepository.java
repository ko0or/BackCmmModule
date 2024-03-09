package back.cmm.module.cmm.repository;

import back.cmm.module.cmm.domain.CodeBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeRepository extends JpaRepository<CodeBean, String> {

    List<CodeBean> findAllByUprCdIdIsNull();
    List<CodeBean> findAllByUprCdId(String uprCdId);
    CodeBean findByCdId(String cdId);

}

package back.cmm.module.cmm.repository;

import back.cmm.module.cmm.domain.CodeBean;
import back.cmm.module.cmm.domain.CodeListBean;
import back.cmm.module.cmm.dto.CodeDto;
import back.cmm.module.cmm.dto.CodeListDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeRepository extends JpaRepository<CodeListBean, String> {

    List<CodeListBean> findAllByUprCdIdIsNull();
    List<CodeListBean> findAllByUprCdId(String uprCdId);
    CodeListBean findByCdId(String cdId);

}

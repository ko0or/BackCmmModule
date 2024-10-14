package back.cmm.module.cmm.cmmMenu.dao;

import back.cmm.module.cmm.cmmMenu.domain.CmmMenuBean;
import back.cmm.module.cmm.code.domain.CodeBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmmMenuRepository extends JpaRepository<CmmMenuBean, String> {

    List<CmmMenuBean> findAllByUprMenuIdIsNull();
    List<CmmMenuBean> findAllByUprMenuId(String uprMenuId);
    CmmMenuBean findByMenuId(String menuId);

}

package back.cmm.module.cmm.cmmRoute.dao;

import back.cmm.module.cmm.cmmRoute.domain.CmmRouteBean;
import back.cmm.module.cmm.code.domain.CodeBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmmRouteRepository extends JpaRepository<CmmRouteBean, String> {

    List<CmmRouteBean> findAllByUprRouteIdIsNull();
    List<CmmRouteBean> findAllByUprRouteId(String uprRouteId);
    CmmRouteBean findByRouteId(String routeId);

}

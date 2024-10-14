package back.cmm.module.cmm.cmmRoute.service;

import back.cmm.module.cmm.cmmRoute.dto.CmmRouteDto;
import back.cmm.module.cmm.cmmRoute.dto.CmmRouteListDto;

import java.util.List;

public interface CmmRouteService {
    CmmRouteDto readByCdId(String cdId);
    List<CmmRouteListDto> readAllByUprCdId(String uprCdId);
    List<CmmRouteListDto> readAll();
    void save(CmmRouteListDto dto);
}

package back.cmm.module.cmm.cmmMenu.service;

import back.cmm.module.cmm.cmmMenu.dto.CmmMenuDto;
import back.cmm.module.cmm.cmmMenu.dto.CmmMenuListDto;

import java.util.List;

public interface CmmMenuService {
    CmmMenuDto readByMenudId(String cdId);
    List<CmmMenuListDto> readAllByUprMenuId(String uprCdId);
    List<CmmMenuListDto> readAll();
    void save(CmmMenuListDto dto);
}

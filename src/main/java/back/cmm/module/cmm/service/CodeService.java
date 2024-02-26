package back.cmm.module.cmm.service;

import back.cmm.module.cmm.domain.CodeListBean;
import back.cmm.module.cmm.dto.CodeDto;
import back.cmm.module.cmm.dto.CodeListDto;

import java.util.List;

public interface CodeService {
    CodeDto readByCdId(String cdId);
    List<CodeListDto> readAllByUprCdId(String uprCdId);
    List<CodeListDto> readAll();
    void save(CodeDto dto);
    void saveAll(CodeDto dto);
}

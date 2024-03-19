package back.cmm.module.cmm.code.service;

import back.cmm.module.cmm.code.dto.CodeDto;
import back.cmm.module.cmm.code.dto.CodeListDto;

import java.util.List;

public interface CodeService {
    CodeDto readByCdId(String cdId);
    List<CodeListDto> readAllByUprCdId(String uprCdId);
    List<CodeListDto> readAll();
    void save(CodeListDto dto);
}

package back.cmm.module.cmm.service;

import back.cmm.module.cmm.domain.CodeListBean;
import back.cmm.module.cmm.dto.CodeDto;
import back.cmm.module.cmm.dto.CodeListDto;

import java.util.List;

public interface CodeService {
    List<CodeListDto> readAll();

    void save(CodeDto dto);

    List<CodeListDto> readAllByUprCdId(String uprCdId);

    void saveAll(List<CodeDto> dtos);

//    CodeListDto readByCdId(String cdId);
}

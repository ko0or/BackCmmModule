package back.cmm.module.cmm.code.service;

import back.cmm.module.cmm.code.domain.CodeBean;
import back.cmm.module.cmm.code.dto.CodeDto;
import back.cmm.module.cmm.code.dto.CodeListDto;
import back.cmm.module.cmm.code.dao.CodeRepository;
import back.cmm.module.cmm.base.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;
    private final MapperUtil mapperUtil;
/*
    private final QFileBean file = QFileBean.fileBean;
    private final QueryFactory queryFactory;
*/


    @Override
    public List<CodeListDto> readAll() {
        List<CodeListDto> dtos = mapperUtil.map(codeRepository.findAllByUprCdIdIsNull(), CodeListDto.class);
        return setOrder(dtos);
    }

    @Override
    public List<CodeListDto> readAllByUprCdId(String uprCdId) {
        return mapperUtil.map(codeRepository.findAllByUprCdId(uprCdId), CodeListDto.class);
    }

    @Override
    public void save(CodeListDto dto) {
        codeRepository.deleteAll();
        codeRepository.save(mapperUtil.map(dto, CodeBean.class));
    }

    @Override
    public CodeDto readByCdId(String cdId) {
        return mapperUtil.map(codeRepository.findByCdId(cdId), CodeDto.class);
    }

    public List<CodeListDto> setOrder(List<CodeListDto> dtos) {
            Collections.sort(dtos, Comparator.comparing(CodeListDto::getCdId));
            for(CodeListDto dto : dtos) {
                if (dto.getChildren() != null) {
                    setOrder(dto.getChildren());
                }
        }
        return dtos;
    }
}

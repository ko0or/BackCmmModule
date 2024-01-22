package back.cmm.module.cmm.service;

import back.cmm.module.cmm.domain.CodeListBean;
import back.cmm.module.cmm.dto.CodeDto;
import back.cmm.module.cmm.dto.CodeListDto;
import back.cmm.module.cmm.repository.CodeRepository;
import back.cmm.module.cmm.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;
    private final MapperUtil mapperUtil;


    @Override
    public List<CodeListDto> readAll() {
        return mapperUtil.map(codeRepository.findAllByUprCdIdIsNull(), CodeListDto.class);
    }

    @Override
    public List<CodeListDto> readAllByUprCdId(String uprCdId) {
        return mapperUtil.map(codeRepository.findAllByUprCdId(uprCdId), CodeListDto.class);
    }

    @Override
    public void save(CodeDto dto) {
        codeRepository.save(mapperUtil.map(dto, CodeListBean.class));
    }

    @Override
    public void saveAll(List<CodeDto> dtos) {
        codeRepository.saveAll(mapperUtil.map(dtos, CodeListBean.class));
    }

    @Override
    public CodeDto readByCdId(String cdId) {
        return mapperUtil.map(codeRepository.findByCdId(cdId), CodeDto.class);
    }

}

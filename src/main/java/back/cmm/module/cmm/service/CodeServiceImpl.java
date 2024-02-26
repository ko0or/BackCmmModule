package back.cmm.module.cmm.service;

import back.cmm.module.cmm.domain.CodeListBean;
import back.cmm.module.cmm.domain.QFileBean;
import back.cmm.module.cmm.dto.CodeDto;
import back.cmm.module.cmm.dto.CodeListDto;
import back.cmm.module.cmm.repository.CodeRepository;
import back.cmm.module.cmm.util.MapperUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.JPQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void saveAll(CodeDto dto) {
        codeRepository.save(mapperUtil.map(dto, CodeListBean.class));
    }

    @Override
    public CodeDto readByCdId(String cdId) {
        return mapperUtil.map(codeRepository.findByCdId(cdId), CodeDto.class);
    }

}

package back.cmm.module.cmm.cmmRoute.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.cmmRoute.dao.CmmRouteRepository;
import back.cmm.module.cmm.cmmRoute.domain.CmmRouteBean;
import back.cmm.module.cmm.cmmRoute.dto.CmmRouteDto;
import back.cmm.module.cmm.cmmRoute.dto.CmmRouteListDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CmmRouteServiceImpl implements CmmRouteService {
    private final CmmRouteRepository cmmRouteRepository;
    private final MapperUtil mapperUtil;


    @Override
    public List<CmmRouteListDto> readAll() {
        List<CmmRouteListDto> dtos = mapperUtil.map(cmmRouteRepository.findAllByUprRouteIdIsNull(), CmmRouteListDto.class);
        return setOrder(dtos);
    }

    @Override
    public List<CmmRouteListDto> readAllByUprCdId(String uprCdId) {
        return mapperUtil.map(cmmRouteRepository.findAllByUprRouteId(uprCdId), CmmRouteListDto.class);
    }

    @Override
    @Transactional
    public void save(CmmRouteListDto dto) {
        cmmRouteRepository.deleteAll();
        CmmRouteBean mapped = mapperUtil.map(dto, CmmRouteBean.class);
        cmmRouteRepository.save(mapped);
    }

    @Override
    public CmmRouteDto readByCdId(String cdId) {
        return mapperUtil.map(cmmRouteRepository.findByRouteId(cdId), CmmRouteDto.class);
    }

    public List<CmmRouteListDto> setOrder(List<CmmRouteListDto> dtos) {
        Collections.sort(dtos, Comparator.comparing(CmmRouteListDto::getRouteId));
        for (CmmRouteListDto dto : dtos) {
            if (dto.getChildren() != null) {
                setOrder(dto.getChildren());
            }
        }
        return dtos;
    }

}

package back.cmm.module.cmm.cmmMenu.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.cmmMenu.dao.CmmMenuRepository;
import back.cmm.module.cmm.cmmMenu.domain.CmmMenuBean;
import back.cmm.module.cmm.cmmMenu.dto.CmmMenuDto;
import back.cmm.module.cmm.cmmMenu.dto.CmmMenuListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CmmMenuServiceImpl implements  CmmMenuService {
    private final CmmMenuRepository cmmMenuRepository;
    private final MapperUtil mapperUtil;


    @Override
    public List<CmmMenuListDto> readAll() {
        List<CmmMenuListDto> dtos = mapperUtil.map(cmmMenuRepository.findAllByUprMenuIdIsNull(), CmmMenuListDto.class);
        return setOrder(dtos);
    }

    @Override
    public List<CmmMenuListDto> readAllByUprMenuId(String uprCdId) {
        return mapperUtil.map(cmmMenuRepository.findAllByUprMenuId(uprCdId), CmmMenuListDto.class);
    }

    @Override
    public void save(CmmMenuListDto dto) {
        System.out.println("@#@#@# dto : ' " + dto);
        cmmMenuRepository.deleteAll();
        CmmMenuBean mapped = mapperUtil.map(dto, CmmMenuBean.class);
        System.out.println("@#@#@# mapped Bean : " + mapped);
        cmmMenuRepository.save(mapped);
    }

    @Override
    public CmmMenuDto readByMenudId(String cdId) {
        return mapperUtil.map(cmmMenuRepository.findById(cdId), CmmMenuDto.class);
    }

    public List<CmmMenuListDto> setOrder(List<CmmMenuListDto> dtos) {
        Collections.sort(dtos, Comparator.comparing(CmmMenuListDto::getMenuId));
        for (CmmMenuListDto dto : dtos) {
            if (dto.getChildren() != null) {
                setOrder(dto.getChildren());
            }
        }
        return dtos;
    }
}

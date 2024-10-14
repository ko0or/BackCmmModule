package back.cmm.module.cmm.cmmMenu.web;

import back.cmm.module.cmm.cmmMenu.dto.CmmMenuDto;
import back.cmm.module.cmm.cmmMenu.dto.CmmMenuListDto;
import back.cmm.module.cmm.cmmMenu.service.CmmMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Menu API", description = "메뉴 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class CmmMenuApi {
    private final CmmMenuService cmmMenuService;

    @GetMapping("cd/{cd_id}")
    @Operation(summary = "코드 단일 조회")
    public CmmMenuDto readByCdId(@PathVariable("cd_id") String cdId) {
        return cmmMenuService.readByMenudId(cdId);
    }

    @GetMapping
    @Operation(summary = "코드 목록 조회")
    public List<CmmMenuListDto> readAll() {
        return cmmMenuService.readAll();
    }

    @GetMapping("upr/{upr_cd_id}")
    @Operation(summary = "코드 하위 목록만 조회")
    public List<CmmMenuListDto> readAllByUprCdId(@PathVariable("upr_cd_id") String uprCdId) {
        return cmmMenuService.readAllByUprMenuId(uprCdId);
    }

    @PostMapping
    @Operation(summary = "코드 저장")
    public void save(@Valid @RequestBody CmmMenuListDto dto) {
        cmmMenuService.save(dto);
    }

}
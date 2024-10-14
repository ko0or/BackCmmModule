package back.cmm.module.cmm.cmmRoute.web;

import back.cmm.module.cmm.cmmRoute.dto.CmmRouteDto;
import back.cmm.module.cmm.cmmRoute.dto.CmmRouteListDto;
import back.cmm.module.cmm.cmmRoute.service.CmmRouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Route API", description = "라우트 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class CmmRouteApi {
    private final CmmRouteService cmmRouteService;

    @GetMapping("cd/{cd_id}")
    @Operation(summary = "코드 단일 조회")
    public CmmRouteDto readByCdId(@PathVariable("cd_id") String cdId) {
        return cmmRouteService.readByCdId(cdId);
    }

    @GetMapping
    @Operation(summary = "코드 목록 조회")
    public List<CmmRouteListDto> readAll() {
        return cmmRouteService.readAll();
    }

    @GetMapping("upr/{upr_cd_id}")
    @Operation(summary = "코드 하위 목록만 조회")
    public List<CmmRouteListDto> readAllByUprCdId(@PathVariable("upr_cd_id") String uprCdId) {
        return cmmRouteService.readAllByUprCdId(uprCdId);
    }

    @PostMapping
    @Operation(summary = "코드 저장")
    public void save(@Valid @RequestBody CmmRouteListDto dto) {
        cmmRouteService.save(dto);
    }

}

package back.cmm.module.cmm.web;

import back.cmm.module.cmm.dto.CodeDto;
import back.cmm.module.cmm.dto.CodeListDto;
import back.cmm.module.cmm.service.CodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Code API", description = "코드 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeApi {
    private final CodeService codeService;

    @GetMapping("cd/{cd_id}")
    @Operation(summary = "코드 단일 조회")
    public CodeDto readByCdId(@PathVariable("cd_id") String cdId) {
        return codeService.readByCdId(cdId);
    }

    @GetMapping
    @Operation(summary = "코드 목록 조회")
    public List<CodeListDto> readAll() {
        return codeService.readAll();
    }

    @GetMapping("upr/{upr_cd_id}")
    @Operation(summary = "코드 하위 목록만 조회")
    public List<CodeListDto> readAllByUprCdId(@PathVariable("upr_cd_id") String uprCdId) {
        return codeService.readAllByUprCdId(uprCdId);
    }

    @PostMapping
    @Operation(summary = "코드 저장")
    public void save(@Valid @RequestBody CodeListDto dto) {
        codeService.save(dto);
    }

}

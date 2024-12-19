package back.cmm.module.admin.web;

import back.cmm.module.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Docker API", description = "도커 컨테이너, 이미지 관리")
@RestController
@RequestMapping("/admin")
public class AdminApi {

    @Resource private AdminService adminService;

    @Operation(summary = "프로젝트 배포")
    @PostMapping("update-version")
    public void deploy(@RequestParam("file") MultipartFile file) {
        adminService.updateProject(file);
    }

}

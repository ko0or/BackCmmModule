package back.cmm.module.docker.web;

import back.cmm.module.docker.dto.DockerDto;
import back.cmm.module.docker.service.DockerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "Docker API", description = "도커 컨테이너, 이미지 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("docker")
public class DockerApi {

    private final DockerService dockerService;

    @Operation(summary = "프로젝트 배포")
    @GetMapping("deploy")
    public Map<String, Object> deploy(@RequestBody DockerDto dto) {
        return dockerService.deploy(dto);
    }

    /* ====================================================================== */

    @Operation(summary = "컨테이너 목록")
    @GetMapping("container")
    public Map<String, Object> containerList() {
        return dockerService.containers();
    }

    @Operation(summary = "컨테이너 실행")
    @PostMapping("container/start")
    public Map<String, Object> startContainer(@RequestBody DockerDto dto) {
        return dockerService.start(dto);
    }

    @Operation(summary = "컨테이너 중단")
    @PostMapping("container/stop")
    public Map<String, Object> stopContainer(@RequestBody DockerDto dto) {
        return dockerService.stop(dto);
    }

    @Operation(summary = "컨테이너 삭제")
    @PostMapping("container/delete")
    public Map<String, Object> deleteContainer(@RequestBody DockerDto dto) {
        return dockerService.rmContainer(dto, true);
    }

    /* ====================================================================== */

    @Operation(summary = "이미지 목록")
    @GetMapping("image")
    public Map<String, Object> imageList() {
        return dockerService.images();
    }

    @Operation(summary = "이미지 다운로드")
    @PostMapping("image/pull")
    public Map<String, Object> pullImage(@RequestBody DockerDto dto) {
        return dockerService.pullImg(dto);
    }

    @Operation(summary = "이미지 실행")
    @PostMapping("image/start")
    public Map<String, Object> startImage(@RequestBody DockerDto dto) {
        return dockerService.run(dto);
    }

    @Operation(summary = "이미지 삭제")
    @PostMapping("image/delete")
    public Map<String, Object> deleteImage(@RequestBody DockerDto dto) {
        System.out.println("@#@#@# dto -> " + dto.toString());
        return dockerService.rmImg(dto, true);
    }

}

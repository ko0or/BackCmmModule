package back.cmm.module.docker.web;

import back.cmm.module.docker.dto.DockerProjectDto;
import back.cmm.module.docker.service.DockerProjectService;
import back.cmm.module.docker.service.DockerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Docker Project API", description = "도커 기반 프로젝트 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("docker/project")
public class DockerProjectApi {

    private final DockerService dockerService;
    private final DockerProjectService dockerProjectService;

    @GetMapping
    public List<DockerProjectDto> list() {
        return dockerProjectService.list();
    }

//    public void detail(@RequestBody DockerProjectDto dto) {
//
//    }

    @PostMapping("save")
    public void save(@RequestBody DockerProjectDto dto) {
        dockerProjectService.save(dto);
    }

    @PostMapping("delete")
    public void delete(@RequestBody DockerProjectDto dto) {
        dockerProjectService.delete(dto);
    }

}

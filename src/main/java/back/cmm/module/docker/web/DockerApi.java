package back.cmm.module.docker.web;

import back.cmm.module.docker.service.DockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("docker")
public class DockerApi {

    private final DockerService dockerService;

    @GetMapping("container")
    public Map<String, Object> containerList() {
        return dockerService.containers();
    }

    @GetMapping("image")
    public Map<String, Object> imageList() {
        return dockerService.images();
    }

}

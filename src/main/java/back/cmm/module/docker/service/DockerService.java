package back.cmm.module.docker.service;

import back.cmm.module.docker.dto.DockerDto;

import java.util.Map;

public interface DockerService {

    Map<String, Object> login();
    Map<String, Object> images();
    Map<String, Object> containers();
    Map<String, Object> pullImg(DockerDto dto);
    Map<String, Object> run(DockerDto dto);
    Map<String, Object> start(DockerDto dto);
    Map<String, Object> stop(DockerDto dto);
    Map<String, Object> rmContainer(DockerDto dto, Boolean force);
    Map<String, Object> rmImg(DockerDto dto, Boolean force);
    Map<String, Object> deploy(DockerDto dto);

}

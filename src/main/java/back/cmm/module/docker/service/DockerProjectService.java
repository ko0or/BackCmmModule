package back.cmm.module.docker.service;

import back.cmm.module.docker.dto.DockerProjectDto;

import java.util.List;

public interface DockerProjectService {

    List<DockerProjectDto> list();
    void save(DockerProjectDto dto);
    void delete(DockerProjectDto dto);

}

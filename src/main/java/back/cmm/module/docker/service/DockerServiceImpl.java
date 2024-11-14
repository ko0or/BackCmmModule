package back.cmm.module.docker.service;

import back.cmm.module.cmm.base.util.ExecUtil;
import back.cmm.module.docker.dto.DockerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DockerServiceImpl implements DockerService {

    private final ExecUtil execUtil;
    private static final String DOCKER_LOGIN_ID = "dockerID";
    private static final String DOCKER_LOGIN_PW = "dockerPWD";

    @Override
    public Map<String, Object> login() {
        return execUtil.execCmd("docker", "login", "-u", DOCKER_LOGIN_ID, "-p", DOCKER_LOGIN_PW);
    }

    @Override
    public Map<String, Object> images() {
        return execUtil.execCmd("docker", "images", "--format", "\"{{json .}}\"");
    }

    @Override
    public Map<String, Object> containers() {
        return execUtil.execCmd("docker", "ps", "-a", "--format", "\"{{json .}}\"");
    }

    @Override
    public Map<String, Object> pullImg(DockerDto dto) {
//        return execUtil.execCmd("docker login -u m1nwoo --password-stdin < docker-token.txt", "&&", "docker", "pull", dto.getImageName());
        return execUtil.execCmd("docker login -u m1nwoo --password-stdin < docker-token.txt && docker pull " + dto.getImageName());

    }

    @Override
    public Map<String, Object> run(DockerDto dto) {
        return execUtil.execCmd("docker", "run", "-d", "--name", dto.getContainerName(), "-p", dto.getEtrPort() + ":" + dto.getItrPort(), dto.getImageName());
    }

    @Override
    public Map<String, Object> start(DockerDto dto) {
        return execUtil.execCmd("docker", "start", dto.getContainerName());
    }

    @Override
    public Map<String, Object> stop(DockerDto dto) {
        return execUtil.execCmd("docker", "stop", dto.getContainerName());
    }

    @Override
    public Map<String, Object> rmContainer(DockerDto dto, Boolean force) {
        return force ? execUtil.execCmd("docker", "rm", "-f", dto.getContainerName())
                : execUtil.execCmd("docker", "rm", dto.getContainerName());
    }

    @Override
    public Map<String, Object> rmImg(DockerDto dto, Boolean force) {
        return force ? execUtil.execCmd("docker", "rmi", "-f", dto.getImageName())
                : execUtil.execCmd("docker", "rmi", dto.getImageName());
    }

    @Override
    public Map<String, Object> deploy(DockerDto dto) {
        rmContainer(dto, true);
        rmImg(dto, true);
        pullImg(dto);
        return run(dto);
    }

}

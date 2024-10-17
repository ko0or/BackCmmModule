package back.cmm.module.docker.service;

import back.cmm.module.cmm.base.util.ExecUtil;
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
        return execUtil.execCmd("docker", "images", "--format", "'{{json .}}'");
    }

    @Override
    public Map<String, Object> containers() {
        return execUtil.execCmd("docker", "ps", "-a", "--format", "'{{json .}}'");
    }

    @Override
    public Map<String, Object> pullImg(String imgName) {
        return execUtil.execCmd("docker", "pull", imgName);
    }

    @Override
    public Map<String, Object> run(String containerName, int etrPort, int itrPort, String imageName) {
        return execUtil.execCmd("docker", "run", "-d", "--name", containerName, "-p", etrPort + ":" + itrPort, imageName);
    }

    @Override
    public Map<String, Object> start(String containerName) {
        return execUtil.execCmd("docker", "start", containerName);
    }

    @Override
    public Map<String, Object> stop(String containerName) {
        return execUtil.execCmd("docker", "stop", containerName);
    }

    @Override
    public Map<String, Object> rmContainer(String containerName, Boolean force) {
        return force ? execUtil.execCmd("docker", "rm", "-f", containerName)
                : execUtil.execCmd("docker", "rm", containerName);
    }

    @Override
    public Map<String, Object> rmImg(String imageName, Boolean force) {
        return force ? execUtil.execCmd("docker", "rmi", "-f", imageName)
                : execUtil.execCmd("docker", "rmi", imageName);
    }

    @Override
    public Map<String, Object> deploy(String containerName, int etrPort, int itrPort, String imageName) {

        rmContainer(containerName, true);
        rmImg(imageName, true);
        pullImg(imageName);
        return run(containerName, etrPort, itrPort, imageName);

    }

}

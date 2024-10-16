package back.cmm.module.docker.service;

import java.util.Map;

public interface DockerService {

    Map<String, Object> login();
    Map<String, Object> images();
    Map<String, Object> containers();
    Map<String, Object> pullImg(String imgName);
    Map<String, Object> run(String containerName, int etrPort, int itrPort, String imageName);
    Map<String, Object> start(String containerName);
    Map<String, Object> stop(String containerName);
    Map<String, Object> rmContainer(String containerName, Boolean force);
    Map<String, Object> rmImg(String imageName, Boolean force);
    Map<String, Object> deploy(String containerName, int etrPort, int itrPort, String imageName);

}

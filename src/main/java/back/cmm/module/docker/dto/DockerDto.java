package back.cmm.module.docker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DockerDto {
    private String containerName;
    private int etrPort;
    private int itrPort;
    private String imageName;
}

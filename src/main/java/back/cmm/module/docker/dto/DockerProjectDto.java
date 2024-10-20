package back.cmm.module.docker.dto;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DockerProjectDto extends RegBasicBean {

    private Long projectUid;
    private String projectName;
    private String projectUrl;
    private String containerName;
    private String imageName;
    private int etrPort;
    private int itrPort;
    private Date domainSdate;
    private Date domainEdate;
    private Date sslSdate;
    private Date sslEdate;

}
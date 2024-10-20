package back.cmm.module.docker.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "docker_project")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DockerProjectBean extends RegBasicBean {

    @Id
    @Column(name = "project_uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectUid;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_url")
    private String projectUrl;

    @Column(name = "container_name")
    private String containerName;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "etr_port")
    private int etrPort;

    @Column(name = "itr_port")
    private int itrPort;

    @Column(name = "domain_sdate")
    private Date domainSdate;

    @Column(name = "domain_edate")
    private Date domainEdate;

    @Column(name = "ssl_sdate")
    private Date sslSdate;

    @Column(name = "ssl_edate")
    private Date sslEdate;

}

package back.cmm.module.docker.dao;

import back.cmm.module.docker.domain.DockerProjectBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DockerProjectRepository extends JpaRepository<DockerProjectBean, Long> {



}

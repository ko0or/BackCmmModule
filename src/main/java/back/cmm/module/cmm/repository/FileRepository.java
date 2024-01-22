package back.cmm.module.cmm.repository;

import back.cmm.module.cmm.domain.FileBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileBean, Long> {

    void deleteByLogicalNm(String logicalNm);

    Optional<FileBean> findByLogicalNm(String logicalNm);
}

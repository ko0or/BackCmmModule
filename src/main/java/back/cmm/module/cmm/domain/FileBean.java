package back.cmm.module.cmm.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`file`")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileBean extends RegOnlyBean {

    @Id
    @Column(name = "file_uid")
    @GeneratedValue
    private Long fileUid;

    @Column(name = "logical_nm")
    private String logicalNm;
    @Column(name = "physical_nm")
    private String physicalNm;
    @Column(name = "path")
    private String path;

}

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name = "logical_nm")
    private String logicalNm;
    @Column(name = "physical_nm")
    private String physicalNm;
    @Column(name = "path")
    private String path;

}

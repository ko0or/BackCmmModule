package back.cmm.module.cmm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`code`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeBean {

    @Id @Column(name = "cd_id", length = 10)
    private String cdId;

    @Column(name = "cd_nm", nullable = false)
    private String cdNm;

    @Column(name = "cd_des", length = 255)
    private String cdDes;

    @Column(name = "cd_ord", nullable = false)
    private Integer cdOrd;

    @Column(name = "upr_cd_id")
    private String uprCdId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upr_cd_id", insertable = false, updatable = false)
    private CodeBean code;

}

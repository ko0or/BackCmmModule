package back.cmm.module.cmm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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

    @Column(name = "cd_nm")
    private String cdNm;

    @Column(name = "cd_des", length = 255)
    private String cdDes;

    @Column(name = "cd_ord")
    private Integer cdOrd;

    @Column(name = "upr_cd_id")
    private String uprCdId;

    @Column(name = "active_yn")
    @ColumnDefault("'Y'")
    private String activeYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upr_cd_id", insertable = false, updatable = false)
    private CodeBean code;

}

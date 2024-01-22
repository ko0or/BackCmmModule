package back.cmm.module.cmm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`code_list`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeListBean {

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

    @Column(name = "active_yn")
    @ColumnDefault("'Y'")
    private String activeYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upr_cd_id", insertable = false, updatable = false)
    private CodeListBean code;

    @OneToMany(mappedBy = "code", fetch = FetchType.EAGER)
    private List<CodeListBean> children = new ArrayList<>();

}

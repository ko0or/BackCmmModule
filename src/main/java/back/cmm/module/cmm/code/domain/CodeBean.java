package back.cmm.module.cmm.code.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "`code`")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeBean extends RegBasicBean {

    @Id
    @Column(name = "cd_id", length = 10)
    private String cdId;

    @Column(name = "cd_nm")
    private String cdNm;

    @Column(name = "cd_des", length = 255)
    private String cdDes;

    @Column(name = "cd_ord")
    private Integer cdOrd;

    @Column(name = "upr_cd_id")
    private String uprCdId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upr_cd_id", referencedColumnName = "cd_id", insertable = false, updatable = false)
    private CodeBean parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<CodeBean> children;

    @Column(name = "active_yn")
    private String activeYn = "Y"; // 기본값 설정

}

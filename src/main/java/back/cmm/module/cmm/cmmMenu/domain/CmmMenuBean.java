package back.cmm.module.cmm.cmmMenu.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import back.cmm.module.cmm.cmmRoute.domain.CmmRouteBean;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "`cmm_menu`")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CmmMenuBean extends RegBasicBean {

    @Id
    @Column(name = "menu_id", length = 10)
    private String menuId;

    @Column(name = "menu_nm")
    private String menuNm;

    @Column(name = "menu_des", length = 255)
    private String menuDes;

    @Column(name = "menu_ord")
    private Integer menuOrd;

    @Column(name = "upr_menu_id")
    private String uprMenuId;

    @Column(name = "route_id", length = 10)
    private String routeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upr_menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false)
    private CmmMenuBean parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<CmmMenuBean> children;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "route_id", referencedColumnName = "route_id", insertable = false, updatable = false)
//    private CmmRouteBean route;

    @Column(name = "use_yn")
    private String useYn = "Y"; // 기본값 설정

}

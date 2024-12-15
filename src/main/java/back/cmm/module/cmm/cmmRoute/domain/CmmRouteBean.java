package back.cmm.module.cmm.cmmRoute.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import back.cmm.module.cmm.cmmMenu.domain.CmmMenuBean;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "`cmm_route`")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CmmRouteBean extends RegBasicBean {

    @Id
    @Column(name = "route_id", length = 10)
    private String routeId;

    @Column(name = "route_nm")
    private String routeNm;

    @Column(name = "route_des", length = 255)
    private String routeDes;

    @Column(name = "route_param")
    private String routeParam;

    @Column(name = "upr_route_id")
    private String uprRouteId;

    @Column(name = "route_path")
    private String routePath;

    @Column(name = "redirect_path")
    private String redirectPath;

    @Column(name = "component")
    private String component;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upr_route_id", referencedColumnName = "route_id", insertable = false, updatable = false)
    private CmmRouteBean parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<CmmRouteBean> children;

    @Column(name = "use_yn")
    private String useYn = "Y"; // 기본값 설정

//    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
//    private List<CmmMenuBean> menu;

}
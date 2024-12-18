package back.cmm.module.cmm.cmmMenu.dto;

import back.cmm.module.cmm.cmmRoute.dto.CmmRouteDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CmmMenuListDto {

    private String menuId;
    private String menuNm;
    private String menuDes;
    private Integer menuOrd;
    private String menuIcon;
    private String uprMenuId;
    private List<CmmMenuListDto> children;
    private String routeId;
    private String routeParam;
//    private CmmRouteDto route;
    private String useYn;

}
package back.cmm.module.cmm.cmmMenu.dto;

import back.cmm.module.cmm.cmmMenu.domain.CmmMenuBean;
import back.cmm.module.cmm.cmmRoute.domain.CmmRouteBean;
import back.cmm.module.cmm.cmmRoute.dto.CmmRouteDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CmmMenuDto {

    private String menuId;
    private String menuNm;
    private String menuDes;
    private Integer menuOrd;
    private String uprMenuId;
    private CmmRouteDto route;
    private String useYn;

}
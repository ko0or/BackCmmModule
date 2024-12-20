package back.cmm.module.cmm.cmmRoute.dto;

import back.cmm.module.cmm.cmmMenu.dto.CmmMenuDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CmmRouteListDto {

    private String routeId;
    private String routeNm;
    private String routeDes;
    private Integer routeOrd;
    private String uprRouteId;
    private String routePath;
    private String redirectPath;
    private String component;
    private List<CmmRouteListDto> children;
    private List<CmmMenuDto> menu;
    private String useYn;

}

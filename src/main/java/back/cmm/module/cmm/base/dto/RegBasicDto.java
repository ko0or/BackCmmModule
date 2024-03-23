package back.cmm.module.cmm.base.dto;

import back.cmm.module.cmm.security.dto.ModOnlyDto;
import lombok.Getter;

@Getter
public class RegBasicDto extends ModOnlyDto {
    private String delYn;
}
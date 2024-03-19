package back.cmm.module.cmm.security.dto;

import back.cmm.module.cmm.base.dto.RegOnlyDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ModOnlyDto extends RegOnlyDto {
    private Date modDttm;
    private String modId;
}

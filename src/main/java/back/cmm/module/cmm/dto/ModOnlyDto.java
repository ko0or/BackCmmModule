package back.cmm.module.cmm.dto;

import back.cmm.module.cmm.util.SecurityUtil;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ModOnlyDto extends RegOnlyDto {
    private Date modDttm;
    private String modId;
}

package back.cmm.module.cmm.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
public class RegBasicDto extends ModOnlyDto {
    private String delYn;
}
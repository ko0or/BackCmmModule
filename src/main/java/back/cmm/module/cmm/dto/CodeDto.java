package back.cmm.module.cmm.dto;

import back.cmm.module.cmm.domain.CodeBean;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CodeDto {

    private String cdId;
    private String cdNm;
    private String cdDes;
    private Integer cdOrd;
    private String uprCdId;
    private String activeYn;
    private List<CodeDto> children;

}

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

    @NotNull
    private String cdId;
    @NotNull
    private String cdNm;
    private String cdDes;
    @NotNull
    private Integer cdOrd;
    private String uprCdId;
    private String activeYn;
}

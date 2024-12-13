package back.cmm.module.cmm.code.dto;

import lombok.*;

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
    private String useYn;

}

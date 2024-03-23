package back.cmm.module.cmm.code.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CodeListDto {

    private String cdId;
    private String cdNm;
    private String cdDes;
    private Integer cdOrd;
    private String uprCdId;
    private String activeYn;
    private List<CodeListDto> children;

}

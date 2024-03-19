package back.cmm.module.cmm.file.dto;

import back.cmm.module.cmm.base.dto.RegOnlyDto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileDto extends RegOnlyDto {

    private Long fileUid;
    private String logicalNm;
    private String physicalNm;
    private String path;

}

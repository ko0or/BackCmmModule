package back.cmm.module.cmm.dto;

import jakarta.persistence.Column;
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

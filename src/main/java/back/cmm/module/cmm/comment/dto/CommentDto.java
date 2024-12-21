package back.cmm.module.cmm.comment.dto;

import back.cmm.module.cmm.base.dto.RegBasicDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentDto extends RegBasicDto {

    private Long cmmtUid;
    private String content;
    private Long postUid;

    private UserBasicDto user;
    /*private CommentDto parent;*/
    private List<CommentDto> children;

}

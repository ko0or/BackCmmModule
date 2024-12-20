package back.cmm.module.cmm.comment.dto;

import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long cmmtUid;
    private String content;
    private Long postUid;

    private UserBasicDto user;
    /*private CommentDto parent;*/
    private List<CommentDto> children;

}

package back.cmm.module.cmm.comment.dto;

import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentFormDto {

    private Long cmmtUid;
    private String content;
    private Long postUid;
    private Long parentCmmtUid;

}

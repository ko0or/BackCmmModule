package back.cmm.module.cmm.post.dto;

import back.cmm.module.cmm.base.dto.RegBasicDto;
import back.cmm.module.cmm.board.dto.BoardDto;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostFormDto extends RegBasicDto {

    private Long postUid;

    @NotNull private String title;
    @NotNull private String content;
    @NotNull private String boardId;

    private String thumbImg;
    private String thumbContent;

}

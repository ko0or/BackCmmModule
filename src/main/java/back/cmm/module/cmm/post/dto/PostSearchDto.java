package back.cmm.module.cmm.post.dto;

import back.cmm.module.cmm.board.dto.BoardDto;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.Data;

import java.util.List;

@Data
public class PostSearchDto {

    private String keyword;

    private String title;
    private String content;
    private String boardId;
    private String userId;

}

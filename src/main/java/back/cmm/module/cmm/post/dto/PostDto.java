package back.cmm.module.cmm.post.dto;

import back.cmm.module.cmm.board.domain.BoardBean;
import back.cmm.module.cmm.board.dto.BoardDto;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDto {

    private Long postUid;
    private String title;
    private String content;
    private String thumbImg;
    private String thumbContent;
    private String boardId;

    private String authorNm;
    private Date regDttm;
    private Long cmmtCnt;

}

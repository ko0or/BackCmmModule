package back.cmm.module.cmm.post.dto;

import back.cmm.module.cmm.base.dto.RegBasicDto;
import back.cmm.module.cmm.board.dto.BoardDto;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostDtlDto extends RegBasicDto {

    private Long postUid;
    private String title;
    private String content;
    private String thumbImg;
    private String thumbContent;
    private String boardId;
    private BoardDto board;
    private UserBasicDto user;
    private List<CommentDto> comments;

    private PostNavDto prevPost;
    private PostNavDto nextPost;

}

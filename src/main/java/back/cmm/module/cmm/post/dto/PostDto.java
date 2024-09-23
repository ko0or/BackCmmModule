package back.cmm.module.cmm.post.dto;

import back.cmm.module.cmm.board.domain.BoardBean;
import back.cmm.module.cmm.board.dto.BoardDto;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.Data;

@Data
public class PostDto {

    private Long postUid;
    private String title;
    private String content;
    private String thumbImg;
    private String thumbContent;
    /*private Long boardUid;*/
    private BoardDto board;
    private UserBasicDto user;

}

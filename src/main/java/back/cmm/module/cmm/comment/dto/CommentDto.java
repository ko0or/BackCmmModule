package back.cmm.module.cmm.comment.dto;

import back.cmm.module.cmm.security.domain.UserBean;
import back.cmm.module.cmm.security.dto.UserBasicDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long cmmtUid;
    private String content;
    private Long boardUid;
    private UserBasicDto user;

}

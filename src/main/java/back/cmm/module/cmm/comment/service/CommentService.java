package back.cmm.module.cmm.comment.service;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.comment.dto.CommentFormDto;
import back.cmm.module.cmm.post.dto.PostNavDto;

public interface CommentService {
    QueryDslPaging<CommentDto> getList(PostNavDto dto);

    CommentDto save(CommentFormDto formDto);
    void delete(Long cmmtUid);

}

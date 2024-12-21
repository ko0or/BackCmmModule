package back.cmm.module.cmm.post.dao;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.post.dto.PostDtlDto;
import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostSearchDto;
import org.springframework.data.domain.Pageable;

public interface CustomPostRepository {

    QueryDslPaging<PostDto> list(Pageable pageable, PostSearchDto dto);
    void getSiblingPost(PostDtlDto postDtlDto);

}

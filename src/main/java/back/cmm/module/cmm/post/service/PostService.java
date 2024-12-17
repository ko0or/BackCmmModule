package back.cmm.module.cmm.post.service;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.post.dto.PostDtlDto;
import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostFormDto;
import back.cmm.module.cmm.post.dto.PostSearchDto;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PostDto save(PostFormDto formDto);
    QueryDslPaging<PostDto> list(Pageable pageable, PostSearchDto dto);
    PostDtlDto detail(Long postUid);

}

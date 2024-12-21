package back.cmm.module.cmm.post.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.post.dao.PostRepository;
import back.cmm.module.cmm.post.domain.PostBean;
import back.cmm.module.cmm.post.dto.PostDtlDto;
import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostFormDto;
import back.cmm.module.cmm.post.dto.PostSearchDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MapperUtil mapperUtil;

    @Override
    @Transactional
    public PostDto save(PostFormDto formDto) {
        PostBean postBean = postRepository.save(mapperUtil.map(formDto, PostBean.class));
        return mapperUtil.map(postRepository.save(postBean), PostDto.class);
    }

    @Override
    public QueryDslPaging<PostDto> list(Pageable pageable, PostSearchDto dto) {
        return postRepository.list(pageable, dto);
    }

    @Override
    @SneakyThrows
    public PostDtlDto detail(Long postUid) {
        PostBean postBean = postRepository.findById(postUid).orElseThrow(() -> new Exception("해당 게시글 정보를 찾을 수 없습니다"));
        PostDtlDto postDtlDto = mapperUtil.map(postBean, PostDtlDto.class);
        postRepository.getSiblingPost(postDtlDto);
        return postDtlDto;
    }

}

package back.cmm.module.cmm.post.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.post.dao.PostRepository;
import back.cmm.module.cmm.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<PostDto> getList() {
        return mapperUtil.map(postRepository.findAll(), PostDto.class);
    }

}

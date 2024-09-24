package back.cmm.module.cmm.post.service;

import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostFormDto;

import java.util.List;

public interface PostService {
    List<PostDto> getList();

    PostDto save(PostFormDto formDto);
}

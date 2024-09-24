package back.cmm.module.cmm.post.web;

import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostFormDto;
import back.cmm.module.cmm.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Post API", description = "게시글")
@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostApi {

    private final PostService postService;

    @GetMapping
    @Operation(summary = "게시글 목록 조회")
    public List<PostDto> getList() {
        return postService.getList();
    }

    @PostMapping
    @Operation(summary = "게시글 등록 및 수정")
    public PostDto save(@RequestBody PostFormDto formDto) {
        return postService.save(formDto);
    }

}

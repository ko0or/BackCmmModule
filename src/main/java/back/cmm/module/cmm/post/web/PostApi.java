package back.cmm.module.cmm.post.web;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.post.dto.PostDtlDto;
import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostFormDto;
import back.cmm.module.cmm.post.dto.PostSearchDto;
import back.cmm.module.cmm.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Post API", description = "게시글")
@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostApi {

    private final PostService postService;

    @GetMapping
    @Operation(summary = "게시글 목록 조회")
    public QueryDslPaging<PostDto> list(Pageable pageable, PostSearchDto dto) {
        return postService.list(pageable, dto);
    }

    @GetMapping("{postUid}")
    @Operation(summary = "게시글 상세 조회")
    public PostDtlDto detail(@PathVariable("postUid") Long postUid) {
        return postService.detail(postUid);
    }

    @PostMapping
    @Operation(summary = "게시글 등록 및 수정")
    public PostDto save(@RequestBody @Valid PostFormDto formDto) {
        return postService.save(formDto);
    }

}

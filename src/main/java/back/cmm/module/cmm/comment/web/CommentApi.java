package back.cmm.module.cmm.comment.web;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.comment.dto.CommentFormDto;
import back.cmm.module.cmm.comment.service.CommentService;
import back.cmm.module.cmm.post.dto.PostNavDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Comment API", description = "댓글")
@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentApi {

    private final CommentService commentService;

    @GetMapping
    @Operation(summary = "댓글 목록 조회")
    public QueryDslPaging<CommentDto> getList(PostNavDto dto) {
        return commentService.getList(dto);
    }

    @PostMapping
    @Operation(summary = "댓글 등록")
    public CommentDto save(@RequestBody CommentFormDto formDto) {
        return commentService.save(formDto);
    }

    @DeleteMapping("{cmmtUid}")
    @Operation(summary = "댓글 삭제")
    public void delete(@PathVariable(name = "cmmtUid") Long cmmtUid) {
        commentService.delete(cmmtUid);
    }

}

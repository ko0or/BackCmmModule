package back.cmm.module.cmm.comment.web;

import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Comment API", description = "댓글")
@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentApi {

    private final CommentService commentService;

    @GetMapping
    @Operation(summary = "댓글 목록 조회")
    public List<CommentDto> getList() {
        return commentService.getList();
    }

}

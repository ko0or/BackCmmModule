package back.cmm.module.cmm.board.web;

import back.cmm.module.cmm.board.dto.BoardDto;
import back.cmm.module.cmm.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Board API", description = "게시판")
@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardApi {

    private final BoardService boardService;

    @GetMapping
    @Operation(summary = "게시판 목록 조회")
    public List<BoardDto> getList() {
        return boardService.getList();
    }

    @PostMapping
    @Operation(summary = "게시판 등록 및 수정")
    public BoardDto save(@RequestBody BoardDto boardDto) {
        return boardService.save(boardDto);
    }

}

package back.cmm.module.cmm.board.service;

import back.cmm.module.cmm.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> getList();

    BoardDto save(BoardDto boardDto);
}

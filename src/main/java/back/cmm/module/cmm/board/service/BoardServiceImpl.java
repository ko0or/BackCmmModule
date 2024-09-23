package back.cmm.module.cmm.board.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.board.dao.BoardRepository;
import back.cmm.module.cmm.board.domain.BoardBean;
import back.cmm.module.cmm.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<BoardDto> getList() {
        return mapperUtil.map(boardRepository.findAll(), BoardDto.class);
    }

    @Override
    public BoardDto reg(BoardDto boardDto) {
        BoardBean saved = boardRepository.save(mapperUtil.map(boardDto, BoardBean.class));
        return mapperUtil.map(saved, BoardDto.class);
    }

}

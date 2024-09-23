package back.cmm.module.cmm.board.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.board.dao.BoardRepository;
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

}

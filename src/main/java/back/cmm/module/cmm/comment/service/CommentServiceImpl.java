package back.cmm.module.cmm.comment.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.comment.dao.CommentRepository;
import back.cmm.module.cmm.comment.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<CommentDto> getList() {
        return mapperUtil.map(commentRepository.findAll(), CommentDto.class);
    }

}

package back.cmm.module.cmm.comment.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.comment.dao.CommentRepository;
import back.cmm.module.cmm.comment.domain.CommentBean;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.comment.dto.CommentFormDto;
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
        // TODO : queryDSL 전환 여부,  대댓글 포함 페이징 처리 여부 .. ?
        return mapperUtil.map(commentRepository.findAllByParentCmmtUidIsNull(), CommentDto.class);
    }

    @Override
    public CommentDto save(CommentFormDto formDto) {
        CommentBean comment = commentRepository.save(mapperUtil.map(formDto, CommentBean.class));
        return mapperUtil.map(comment, CommentDto.class);
    }

}

package back.cmm.module.cmm.comment.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.comment.dao.CommentRepository;
import back.cmm.module.cmm.comment.domain.CommentBean;
import back.cmm.module.cmm.comment.dto.CommentDto;
import back.cmm.module.cmm.comment.dto.CommentFormDto;
import back.cmm.module.cmm.post.dto.PostNavDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MapperUtil mapperUtil;

    @Override
    public QueryDslPaging<CommentDto> getList(PostNavDto dto) {
        // TODO : queryDSL 전환 여부,  대댓글 포함 페이징 처리 여부 .. ? => 대댓글 포함 페이징 처리가 맞음 !
        QueryDslPaging<CommentDto> paging = new QueryDslPaging<>();
        List<CommentDto> list = mapperUtil.map(commentRepository.findAllByParentCmmtUidIsNullAndPostUidEqualsAndDelYnEquals(dto.getPostUid(), "N", Sort.by(Sort.Order.asc("regDttm"))), CommentDto.class);
        Long totalCount = commentRepository.countByPostUidAndDelYnEquals(dto.getPostUid(), "N");
        paging.setList(list);
        paging.setTotalCount(totalCount);

        return paging;
    }

    @Override
    @Transactional
    public CommentDto save(CommentFormDto formDto) {
        CommentBean comment = commentRepository.save(mapperUtil.map(formDto, CommentBean.class));
        return mapperUtil.map(comment, CommentDto.class);
    }

    @Override
    @Transactional
    public void delete(Long cmmtUid) {
        CommentBean commentBean = commentRepository.findById(cmmtUid).orElse(null);
        if (commentBean != null) {
            commentBean.delete();
            if (!commentBean.getChildren().isEmpty()) {
                deleteChildren(commentBean.getChildren());
            }
        }
    }

    public void deleteChildren (List<CommentBean> list) {
        list.forEach(commentBean -> {
            commentBean.delete();
            if (!commentBean.getChildren().isEmpty()) {
                deleteChildren(commentBean.getChildren());
            }
        });
    }

}

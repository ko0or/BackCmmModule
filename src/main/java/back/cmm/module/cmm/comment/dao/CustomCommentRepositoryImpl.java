package back.cmm.module.cmm.comment.dao;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.comment.domain.CommentBean;
import back.cmm.module.cmm.comment.domain.QCommentBean;
import back.cmm.module.cmm.comment.dto.CommentDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomCommentRepositoryImpl implements CustomCommentRepository {

    private final JPAQueryFactory queryFactory;
    private final MapperUtil mapperUtil;
    QCommentBean qComment = QCommentBean.commentBean;

}

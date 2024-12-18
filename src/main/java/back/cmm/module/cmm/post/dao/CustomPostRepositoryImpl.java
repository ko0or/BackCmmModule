package back.cmm.module.cmm.post.dao;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.board.domain.QBoardBean;
import back.cmm.module.cmm.comment.domain.QCommentBean;
import back.cmm.module.cmm.post.domain.PostBean;
import back.cmm.module.cmm.post.domain.QPostBean;
import back.cmm.module.cmm.post.dto.PostDto;
import back.cmm.module.cmm.post.dto.PostSearchDto;
import back.cmm.module.cmm.security.domain.QUserBean;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomPostRepositoryImpl implements CustomPostRepository {

    @Resource JPAQueryFactory query;
    @Resource MapperUtil mapperUtil;

    private final QPostBean postBean = QPostBean.postBean;
    private final QBoardBean boardBean = QBoardBean.boardBean;
    private final QCommentBean commentBean = QCommentBean.commentBean;
    private final QUserBean userBean = QUserBean.userBean;

    @Override
    public QueryDslPaging<PostDto> list(Pageable pageable, PostSearchDto dto) {

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(postBean.delYn.ne("Y"));
        if (StringUtils.isNotEmpty(dto.getBoardId())) {
            builder.and(postBean.boardId.eq(dto.getBoardId()));
        }
        if (StringUtils.isNotEmpty(dto.getType()) && StringUtils.isNotEmpty(dto.getKeyword())) {
            switch (dto.getType()) {
                case "title":
                    builder.and(postBean.title.contains(dto.getKeyword()));
                    break;
                case "content":
                    builder.and(postBean.content.contains(dto.getKeyword()));
                    break;
                default:
                    builder.and(postBean.title.contains(dto.getKeyword()).or(postBean.content.contains(dto.getKeyword())));
            }
        }

        QBean<PostDto> fields = Projections.fields(PostDto.class,
                postBean.postUid,
                postBean.title,
                postBean.thumbContent,
                postBean.thumbImg,
                postBean.boardId,
                postBean.regDttm,
                ExpressionUtils.as(
                    JPAExpressions.select(userBean.nickname).from(userBean).where(userBean.username.eq(postBean.regId))
                    , "authorNm"
                ),
                ExpressionUtils.as(
                    JPAExpressions.select(commentBean.cmmtUid.count()).from(commentBean).where(commentBean.postUid.eq(postBean.postUid))
                    , "cmmtCnt"
                )
        );
        JPAQuery<PostDto> jpaQuery = query.select(fields).from(postBean).where(builder);

        for (Sort.Order order : pageable.getSort()) {
            PathBuilder<Object> path = new PathBuilder<>(PostBean.class, "postBean").get(order.getProperty());
            Order ord = Order.valueOf(order.getDirection().name());
            jpaQuery.orderBy(new OrderSpecifier(ord, path));
        }

        QueryDslPaging<PostDto> paging = new QueryDslPaging<>();
        List<PostDto> fetched = jpaQuery.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        paging.setList(fetched);
        paging.setTotalCount(jpaQuery.fetchCount());
        paging.setTotalPages((long) Math.ceil((float) paging.getTotalCount() / (float) pageable.getPageSize()));

        return paging;
    }

}

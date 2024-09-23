package back.cmm.module.cmm.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardBean is a Querydsl query type for BoardBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardBean extends EntityPathBase<BoardBean> {

    private static final long serialVersionUID = -83260145L;

    public static final QBoardBean boardBean = new QBoardBean("boardBean");

    public final StringPath boardDescription = createString("boardDescription");

    public final StringPath boardNm = createString("boardNm");

    public final NumberPath<Long> boardUid = createNumber("boardUid", Long.class);

    public final ComparablePath<Character> useBoardYn = createComparable("useBoardYn", Character.class);

    public final ComparablePath<Character> useCommentYn = createComparable("useCommentYn", Character.class);

    public final ComparablePath<Character> useRecommendYn = createComparable("useRecommendYn", Character.class);

    public final ComparablePath<Character> useReportYn = createComparable("useReportYn", Character.class);

    public QBoardBean(String variable) {
        super(BoardBean.class, forVariable(variable));
    }

    public QBoardBean(Path<? extends BoardBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardBean(PathMetadata metadata) {
        super(BoardBean.class, metadata);
    }

}


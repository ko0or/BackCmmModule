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

    public final StringPath boardDes = createString("boardDes");

    public final StringPath boardId = createString("boardId");

    public final StringPath boardNm = createString("boardNm");

    public final ComparablePath<Character> boardUseYn = createComparable("boardUseYn", Character.class);

    public final ComparablePath<Character> cmmtUseYn = createComparable("cmmtUseYn", Character.class);

    public final ComparablePath<Character> rcmdUseYn = createComparable("rcmdUseYn", Character.class);

    public final ComparablePath<Character> reportUseYn = createComparable("reportUseYn", Character.class);

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


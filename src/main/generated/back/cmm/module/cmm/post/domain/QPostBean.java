package back.cmm.module.cmm.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostBean is a Querydsl query type for PostBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostBean extends EntityPathBase<PostBean> {

    private static final long serialVersionUID = 77326343L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostBean postBean = new QPostBean("postBean");

    public final back.cmm.module.cmm.base.domain.QRegBasicBean _super = new back.cmm.module.cmm.base.domain.QRegBasicBean(this);

    public final back.cmm.module.cmm.board.domain.QBoardBean board;

    public final StringPath content = createString("content");

    //inherited
    public final StringPath delYn = _super.delYn;

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    public final NumberPath<Long> postUid = createNumber("postUid", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public final StringPath thumbContent = createString("thumbContent");

    public final StringPath thumbImg = createString("thumbImg");

    public final StringPath title = createString("title");

    public final back.cmm.module.cmm.security.domain.QUserBean user;

    public QPostBean(String variable) {
        this(PostBean.class, forVariable(variable), INITS);
    }

    public QPostBean(Path<? extends PostBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostBean(PathMetadata metadata, PathInits inits) {
        this(PostBean.class, metadata, inits);
    }

    public QPostBean(Class<? extends PostBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new back.cmm.module.cmm.board.domain.QBoardBean(forProperty("board")) : null;
        this.user = inits.isInitialized("user") ? new back.cmm.module.cmm.security.domain.QUserBean(forProperty("user")) : null;
    }

}


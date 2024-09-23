package back.cmm.module.cmm.comment.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentBean is a Querydsl query type for CommentBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentBean extends EntityPathBase<CommentBean> {

    private static final long serialVersionUID = 1592278767L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentBean commentBean = new QCommentBean("commentBean");

    public final back.cmm.module.cmm.base.domain.QRegBasicBean _super = new back.cmm.module.cmm.base.domain.QRegBasicBean(this);

    public final NumberPath<Long> cmmtGrpUid = createNumber("cmmtGrpUid", Long.class);

    public final NumberPath<Long> cmmtUid = createNumber("cmmtUid", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath delYn = _super.delYn;

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public final back.cmm.module.cmm.security.domain.QUserBean user;

    public QCommentBean(String variable) {
        this(CommentBean.class, forVariable(variable), INITS);
    }

    public QCommentBean(Path<? extends CommentBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentBean(PathMetadata metadata, PathInits inits) {
        this(CommentBean.class, metadata, inits);
    }

    public QCommentBean(Class<? extends CommentBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new back.cmm.module.cmm.security.domain.QUserBean(forProperty("user")) : null;
    }

}


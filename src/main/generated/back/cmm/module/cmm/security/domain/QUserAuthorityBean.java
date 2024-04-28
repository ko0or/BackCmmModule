package back.cmm.module.cmm.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAuthorityBean is a Querydsl query type for UserAuthorityBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAuthorityBean extends EntityPathBase<UserAuthorityBean> {

    private static final long serialVersionUID = 1409304753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAuthorityBean userAuthorityBean = new QUserAuthorityBean("userAuthorityBean");

    public final QUserAuthorityPKBean id;

    public QUserAuthorityBean(String variable) {
        this(UserAuthorityBean.class, forVariable(variable), INITS);
    }

    public QUserAuthorityBean(Path<? extends UserAuthorityBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAuthorityBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAuthorityBean(PathMetadata metadata, PathInits inits) {
        this(UserAuthorityBean.class, metadata, inits);
    }

    public QUserAuthorityBean(Class<? extends UserAuthorityBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QUserAuthorityPKBean(forProperty("id")) : null;
    }

}


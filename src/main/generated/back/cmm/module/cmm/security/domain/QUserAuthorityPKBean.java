package back.cmm.module.cmm.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAuthorityPKBean is a Querydsl query type for UserAuthorityPKBean
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUserAuthorityPKBean extends BeanPath<UserAuthorityPKBean> {

    private static final long serialVersionUID = 1803036908L;

    public static final QUserAuthorityPKBean userAuthorityPKBean = new QUserAuthorityPKBean("userAuthorityPKBean");

    public final StringPath authorityName = createString("authorityName");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserAuthorityPKBean(String variable) {
        super(UserAuthorityPKBean.class, forVariable(variable));
    }

    public QUserAuthorityPKBean(Path<? extends UserAuthorityPKBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAuthorityPKBean(PathMetadata metadata) {
        super(UserAuthorityPKBean.class, metadata);
    }

}


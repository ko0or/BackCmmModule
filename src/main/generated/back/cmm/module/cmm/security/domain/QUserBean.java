package back.cmm.module.cmm.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserBean is a Querydsl query type for UserBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserBean extends EntityPathBase<UserBean> {

    private static final long serialVersionUID = 449078994L;

    public static final QUserBean userBean = new QUserBean("userBean");

    public final StringPath activeYn = createString("activeYn");

    public final SetPath<AuthorityBean, QAuthorityBean> authorities = this.<AuthorityBean, QAuthorityBean>createSet("authorities", AuthorityBean.class, QAuthorityBean.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath username = createString("username");

    public QUserBean(String variable) {
        super(UserBean.class, forVariable(variable));
    }

    public QUserBean(Path<? extends UserBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserBean(PathMetadata metadata) {
        super(UserBean.class, metadata);
    }

}


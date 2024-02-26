package back.cmm.module.cmm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthorityBean is a Querydsl query type for AuthorityBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthorityBean extends EntityPathBase<AuthorityBean> {

    private static final long serialVersionUID = 875827364L;

    public static final QAuthorityBean authorityBean = new QAuthorityBean("authorityBean");

    public final StringPath authorityName = createString("authorityName");

    public QAuthorityBean(String variable) {
        super(AuthorityBean.class, forVariable(variable));
    }

    public QAuthorityBean(Path<? extends AuthorityBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthorityBean(PathMetadata metadata) {
        super(AuthorityBean.class, metadata);
    }

}


package back.cmm.module.docker.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDockerProjectBean is a Querydsl query type for DockerProjectBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDockerProjectBean extends EntityPathBase<DockerProjectBean> {

    private static final long serialVersionUID = -1470718883L;

    public static final QDockerProjectBean dockerProjectBean = new QDockerProjectBean("dockerProjectBean");

    public final back.cmm.module.cmm.base.domain.QRegBasicBean _super = new back.cmm.module.cmm.base.domain.QRegBasicBean(this);

    public final StringPath containerName = createString("containerName");

    //inherited
    public final StringPath delYn = _super.delYn;

    public final DateTimePath<java.util.Date> domainEdate = createDateTime("domainEdate", java.util.Date.class);

    public final DateTimePath<java.util.Date> domainSdate = createDateTime("domainSdate", java.util.Date.class);

    public final NumberPath<Integer> etrPort = createNumber("etrPort", Integer.class);

    public final StringPath imageName = createString("imageName");

    public final NumberPath<Integer> itrPort = createNumber("itrPort", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    public final StringPath projectName = createString("projectName");

    public final NumberPath<Long> projectUid = createNumber("projectUid", Long.class);

    public final StringPath projectUrl = createString("projectUrl");

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public final DateTimePath<java.util.Date> sslEdate = createDateTime("sslEdate", java.util.Date.class);

    public final DateTimePath<java.util.Date> sslSdate = createDateTime("sslSdate", java.util.Date.class);

    public QDockerProjectBean(String variable) {
        super(DockerProjectBean.class, forVariable(variable));
    }

    public QDockerProjectBean(Path<? extends DockerProjectBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDockerProjectBean(PathMetadata metadata) {
        super(DockerProjectBean.class, metadata);
    }

}


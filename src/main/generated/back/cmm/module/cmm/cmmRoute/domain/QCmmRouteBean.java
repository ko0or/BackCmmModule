package back.cmm.module.cmm.cmmRoute.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCmmRouteBean is a Querydsl query type for CmmRouteBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCmmRouteBean extends EntityPathBase<CmmRouteBean> {

    private static final long serialVersionUID = -867172013L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCmmRouteBean cmmRouteBean = new QCmmRouteBean("cmmRouteBean");

    public final back.cmm.module.cmm.base.domain.QRegBasicBean _super = new back.cmm.module.cmm.base.domain.QRegBasicBean(this);

    public final ListPath<CmmRouteBean, QCmmRouteBean> children = this.<CmmRouteBean, QCmmRouteBean>createList("children", CmmRouteBean.class, QCmmRouteBean.class, PathInits.DIRECT2);

    public final StringPath component = createString("component");

    //inherited
    public final StringPath delYn = _super.delYn;

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    public final QCmmRouteBean parent;

    public final StringPath redirectPath = createString("redirectPath");

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public final StringPath routeDes = createString("routeDes");

    public final StringPath routeId = createString("routeId");

    public final StringPath routeNm = createString("routeNm");

    public final StringPath routePath = createString("routePath");

    public final StringPath uprRouteId = createString("uprRouteId");

    public final StringPath useYn = createString("useYn");

    public QCmmRouteBean(String variable) {
        this(CmmRouteBean.class, forVariable(variable), INITS);
    }

    public QCmmRouteBean(Path<? extends CmmRouteBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCmmRouteBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCmmRouteBean(PathMetadata metadata, PathInits inits) {
        this(CmmRouteBean.class, metadata, inits);
    }

    public QCmmRouteBean(Class<? extends CmmRouteBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QCmmRouteBean(forProperty("parent"), inits.get("parent")) : null;
    }

}


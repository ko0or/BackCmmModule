package back.cmm.module.cmm.cmmMenu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCmmMenuBean is a Querydsl query type for CmmMenuBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCmmMenuBean extends EntityPathBase<CmmMenuBean> {

    private static final long serialVersionUID = 323742863L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCmmMenuBean cmmMenuBean = new QCmmMenuBean("cmmMenuBean");

    public final back.cmm.module.cmm.base.domain.QRegBasicBean _super = new back.cmm.module.cmm.base.domain.QRegBasicBean(this);

    public final ListPath<CmmMenuBean, QCmmMenuBean> children = this.<CmmMenuBean, QCmmMenuBean>createList("children", CmmMenuBean.class, QCmmMenuBean.class, PathInits.DIRECT2);

    //inherited
    public final StringPath delYn = _super.delYn;

    public final StringPath menuDes = createString("menuDes");

    public final StringPath menuIcon = createString("menuIcon");

    public final StringPath menuId = createString("menuId");

    public final StringPath menuNm = createString("menuNm");

    public final NumberPath<Integer> menuOrd = createNumber("menuOrd", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    public final QCmmMenuBean parent;

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public final StringPath routeId = createString("routeId");

    public final StringPath routeParam = createString("routeParam");

    public final StringPath uprMenuId = createString("uprMenuId");

    public final StringPath useYn = createString("useYn");

    public QCmmMenuBean(String variable) {
        this(CmmMenuBean.class, forVariable(variable), INITS);
    }

    public QCmmMenuBean(Path<? extends CmmMenuBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCmmMenuBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCmmMenuBean(PathMetadata metadata, PathInits inits) {
        this(CmmMenuBean.class, metadata, inits);
    }

    public QCmmMenuBean(Class<? extends CmmMenuBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QCmmMenuBean(forProperty("parent"), inits.get("parent")) : null;
    }

}


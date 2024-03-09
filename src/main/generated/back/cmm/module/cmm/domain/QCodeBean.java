package back.cmm.module.cmm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeBean is a Querydsl query type for CodeBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeBean extends EntityPathBase<CodeBean> {

    private static final long serialVersionUID = 1973761420L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCodeBean codeBean = new QCodeBean("codeBean");

    public final QModOnlyBean _super = new QModOnlyBean(this);

    public final StringPath activeYn = createString("activeYn");

    public final StringPath cdDes = createString("cdDes");

    public final StringPath cdId = createString("cdId");

    public final StringPath cdNm = createString("cdNm");

    public final NumberPath<Integer> cdOrd = createNumber("cdOrd", Integer.class);

    public final ListPath<CodeBean, QCodeBean> children = this.<CodeBean, QCodeBean>createList("children", CodeBean.class, QCodeBean.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    public final QCodeBean parent;

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public final StringPath uprCdId = createString("uprCdId");

    public QCodeBean(String variable) {
        this(CodeBean.class, forVariable(variable), INITS);
    }

    public QCodeBean(Path<? extends CodeBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCodeBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCodeBean(PathMetadata metadata, PathInits inits) {
        this(CodeBean.class, metadata, inits);
    }

    public QCodeBean(Class<? extends CodeBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QCodeBean(forProperty("parent"), inits.get("parent")) : null;
    }

}


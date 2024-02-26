package back.cmm.module.cmm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeListBean is a Querydsl query type for CodeListBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeListBean extends EntityPathBase<CodeListBean> {

    private static final long serialVersionUID = 256347466L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCodeListBean codeListBean = new QCodeListBean("codeListBean");

    public final StringPath activeYn = createString("activeYn");

    public final StringPath cdDes = createString("cdDes");

    public final StringPath cdId = createString("cdId");

    public final StringPath cdNm = createString("cdNm");

    public final NumberPath<Integer> cdOrd = createNumber("cdOrd", Integer.class);

    public final ListPath<CodeListBean, QCodeListBean> children = this.<CodeListBean, QCodeListBean>createList("children", CodeListBean.class, QCodeListBean.class, PathInits.DIRECT2);

    public final QCodeListBean parent;

    public final StringPath uprCdId = createString("uprCdId");

    public QCodeListBean(String variable) {
        this(CodeListBean.class, forVariable(variable), INITS);
    }

    public QCodeListBean(Path<? extends CodeListBean> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCodeListBean(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCodeListBean(PathMetadata metadata, PathInits inits) {
        this(CodeListBean.class, metadata, inits);
    }

    public QCodeListBean(Class<? extends CodeListBean> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QCodeListBean(forProperty("parent"), inits.get("parent")) : null;
    }

}


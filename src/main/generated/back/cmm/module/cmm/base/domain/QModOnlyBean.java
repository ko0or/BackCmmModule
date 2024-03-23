package back.cmm.module.cmm.base.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QModOnlyBean is a Querydsl query type for ModOnlyBean
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QModOnlyBean extends EntityPathBase<ModOnlyBean> {

    private static final long serialVersionUID = 285467094L;

    public static final QModOnlyBean modOnlyBean = new QModOnlyBean("modOnlyBean");

    public final QRegOnlyBean _super = new QRegOnlyBean(this);

    public final DateTimePath<java.util.Date> modDttm = createDateTime("modDttm", java.util.Date.class);

    public final StringPath modId = createString("modId");

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public QModOnlyBean(String variable) {
        super(ModOnlyBean.class, forVariable(variable));
    }

    public QModOnlyBean(Path<? extends ModOnlyBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModOnlyBean(PathMetadata metadata) {
        super(ModOnlyBean.class, metadata);
    }

}


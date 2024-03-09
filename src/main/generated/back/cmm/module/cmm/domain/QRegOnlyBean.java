package back.cmm.module.cmm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegOnlyBean is a Querydsl query type for RegOnlyBean
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QRegOnlyBean extends EntityPathBase<RegOnlyBean> {

    private static final long serialVersionUID = -1487821439L;

    public static final QRegOnlyBean regOnlyBean = new QRegOnlyBean("regOnlyBean");

    public final DateTimePath<java.util.Date> regDttm = createDateTime("regDttm", java.util.Date.class);

    public final StringPath regId = createString("regId");

    public QRegOnlyBean(String variable) {
        super(RegOnlyBean.class, forVariable(variable));
    }

    public QRegOnlyBean(Path<? extends RegOnlyBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegOnlyBean(PathMetadata metadata) {
        super(RegOnlyBean.class, metadata);
    }

}


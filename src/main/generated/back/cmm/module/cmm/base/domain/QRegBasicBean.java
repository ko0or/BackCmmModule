package back.cmm.module.cmm.base.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegBasicBean is a Querydsl query type for RegBasicBean
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QRegBasicBean extends EntityPathBase<RegBasicBean> {

    private static final long serialVersionUID = -860601710L;

    public static final QRegBasicBean regBasicBean = new QRegBasicBean("regBasicBean");

    public final QModOnlyBean _super = new QModOnlyBean(this);

    public final StringPath delYn = createString("delYn");

    //inherited
    public final DateTimePath<java.util.Date> modDttm = _super.modDttm;

    //inherited
    public final StringPath modId = _super.modId;

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public QRegBasicBean(String variable) {
        super(RegBasicBean.class, forVariable(variable));
    }

    public QRegBasicBean(Path<? extends RegBasicBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegBasicBean(PathMetadata metadata) {
        super(RegBasicBean.class, metadata);
    }

}


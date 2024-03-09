package back.cmm.module.cmm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFileBean is a Querydsl query type for FileBean
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileBean extends EntityPathBase<FileBean> {

    private static final long serialVersionUID = 2106203547L;

    public static final QFileBean fileBean = new QFileBean("fileBean");

    public final QRegOnlyBean _super = new QRegOnlyBean(this);

    public final NumberPath<Long> fileUid = createNumber("fileUid", Long.class);

    public final StringPath logicalNm = createString("logicalNm");

    public final StringPath path = createString("path");

    public final StringPath physicalNm = createString("physicalNm");

    //inherited
    public final DateTimePath<java.util.Date> regDttm = _super.regDttm;

    //inherited
    public final StringPath regId = _super.regId;

    public QFileBean(String variable) {
        super(FileBean.class, forVariable(variable));
    }

    public QFileBean(Path<? extends FileBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileBean(PathMetadata metadata) {
        super(FileBean.class, metadata);
    }

}


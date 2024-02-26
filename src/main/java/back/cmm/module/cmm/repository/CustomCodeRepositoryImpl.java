package back.cmm.module.cmm.repository;

import back.cmm.module.cmm.domain.QCodeBean;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.JPAQueryMixin;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomCodeRepositoryImpl implements CustomCodeRepository {

    private final CodeRepository codeRepository;
    private final QCodeBean code = QCodeBean.codeBean;


    @Override
    public void save() {
        JPAQueryFactory qcb = null;
        qcb.update(code).set(code.cdOrd, 2).where(code.uprCdId.gt("2"));


    }
}

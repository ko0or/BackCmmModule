package back.cmm.module.cmm.code.dao;

import back.cmm.module.cmm.code.domain.QCodeBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
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

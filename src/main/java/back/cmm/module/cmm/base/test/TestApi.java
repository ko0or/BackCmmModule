package back.cmm.module.cmm.base.test;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.security.domain.QUserBean;
import back.cmm.module.cmm.security.domain.UserBean;
import back.cmm.module.cmm.security.dto.UserDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestApi {
    @Resource JPAQueryFactory queryFactory;
    private final QUserBean userBean = QUserBean.userBean;


    @GetMapping
    public QueryDslPaging<UserDto> test(Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();
        JPAQuery<UserBean> query = queryFactory.selectFrom(userBean).where(builder);
        return new QueryDslPaging<>(pageable, query, UserBean.class, UserDto.class);

    }
}


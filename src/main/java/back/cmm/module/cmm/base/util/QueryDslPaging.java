package back.cmm.module.cmm.base.util;

import back.cmm.module.cmm.post.domain.PostBean;
import back.cmm.module.cmm.post.dto.PostDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class QueryDslPaging<T> {

    private List<T> list;
    private Long totalCount;
    private Long totalPages;

    /**
     * 페이징 및 정렬, 그리고 Entity → Dto 매핑
     * @param fromClazz : ~Bean 파일.class
     * @param toClazz : ~Dto 파일.class
     * */
    public QueryDslPaging(Pageable pageable, JPAQuery<?> query, Class<?> fromClazz, Class<?> toClazz) {
        ModelMapper mapper = new ModelMapper();
        String[] splitClassNm = fromClazz.getName().split("\\.");
        String classNm = StringUtils.uncapitalize(splitClassNm[splitClassNm.length - 1]);

        for (Sort.Order order : pageable.getSort()) {
            PathBuilder<Object> path = new PathBuilder<>(fromClazz, classNm).get(order.getProperty());
            Order ord = Order.valueOf(order.getDirection().name());
            query.orderBy(new OrderSpecifier(ord, path));
        }

        List<?> fetch = query.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        this.list = (List<T>) fetch.stream().map((bean)-> mapper.map(bean, toClazz)).collect(Collectors.toList());
        this.totalCount = query.fetchCount();
        this.totalPages = (long) Math.ceil((float) this.totalCount / (float) pageable.getPageSize());
    }

    public QueryDslPaging() {

    }

}

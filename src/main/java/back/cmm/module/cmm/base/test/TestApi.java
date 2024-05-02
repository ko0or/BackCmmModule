package back.cmm.module.cmm.base.test;

import back.cmm.module.cmm.security.dao.UserRepository;
import back.cmm.module.cmm.security.domain.UserBean;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestApi {

    @Resource private UserRepository userRepository;

    @GetMapping
    public Map<String, Object> test(Pageable pageable) {

//        조회되기 전에는 많은 정보를 알 수가 없다.
        log.info("pageable.getOffset() : " + pageable.getOffset());
        log.info("pageable.hasPrevious() : " + pageable.hasPrevious());
        log.info("pageable.getSort() : " + pageable.getSort());
        log.info("pageable.getPageNumber() : " + pageable.getPageNumber());
        log.info("pageable.getPageSize() : " + pageable.getPageSize());

//        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.desc("userId")));
//        위 코드 대신 클라이언트측에서 다음과 같이 쿼리 파라미터를 받을 수도 있다 : http://localhost:8080/test?page=0&size=3&sort=userId,asc

        Page<UserBean> beans = userRepository.findAll(pageable);

//        대신 조회된 후에는 많은 정보를 알 수 있다.
        log.info("");
        log.info("beans.getTotalElements() : " + beans.getTotalElements()); // 총 개수
        log.info("beans.getTotalPages() : " + beans.getTotalPages()); // 총 페이지 수
        log.info("beans.getContent() : " + beans.getContent()); // 검색된 내용들
        log.info("beans.getNumber() : " + beans.getNumber()); // 현재 페이지 번호
        log.info("beans.getNumberOfElements() : " + beans.getNumberOfElements());
        log.info("beans.getPageable() : " + beans.getPageable()); // 페이지번호, 페이지당 보여줄 개수, 정렬 형태(정렬 대상필드 : 정렬 방향) -> Page request [number: 0, size 3, sort: userId: ASC]
        log.info("beans.getSort() : " + beans.getSort()); // 정렬 대상 필드 : 정렬 방향  ->  userId: ASC
        log.info("beans.hasPrevious() : " + beans.hasPrevious()); // 이전 페이지 존재 여부
        log.info("beans.hasContent() : " + beans.hasContent()); // 해당 페이지에 보여줄 내용이 존재하는지
        log.info("beans.hasNext() : " + beans.hasNext()); // 다음 페이지 존재 여부


        Map<String, Object> map = new HashMap<>();
        map.put("list", beans.getContent());
        map.put("totalCount", beans.getTotalElements());

        return map;
    }
}

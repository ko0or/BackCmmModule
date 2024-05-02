package back.cmm.module.cmm.base.test;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.base.util.PageResponse;
import back.cmm.module.cmm.security.dao.UserRepository;
import back.cmm.module.cmm.security.domain.UserBean;
import back.cmm.module.cmm.security.dto.UserDto;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public PageResponse test(Pageable pageable) {
        // http://localhost:8080/test?page=0&size=3&sort=userId,desc
        Page<UserBean> beans = userRepository.findAll(pageable);
        return new PageResponse(beans, UserDto.class);
    }

}

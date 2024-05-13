package back.cmm.module.cmm.security.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.security.domain.QUserBean;
import back.cmm.module.cmm.security.dto.LoginDto;
import back.cmm.module.cmm.security.dto.TokenDto;
import back.cmm.module.cmm.security.dto.UserDto;
import back.cmm.module.cmm.security.domain.AuthorityBean;
import back.cmm.module.cmm.security.domain.UserBean;
import back.cmm.module.cmm.security.exception.DuplicateMemberException;
import back.cmm.module.cmm.security.jwt.JwtFilter;
import back.cmm.module.cmm.security.jwt.TokenProvider;
import back.cmm.module.cmm.security.dao.UserRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
/* 로그인 및 회원가입 */
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MapperUtil mapperUtil;

    private final JPAQueryFactory queryFactory;
    private final QUserBean qUserBean = QUserBean.userBean;

    public ResponseEntity<TokenDto> login(LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        AuthorityBean authority = AuthorityBean.builder()
                .authorityName("ROLE_USER")
                .build();

        UserBean user = UserBean.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activeYn("Y")
                .build();

        return mapperUtil.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public QueryDslPaging<UserDto> list(Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        JPAQuery<UserBean> query = queryFactory.selectFrom(qUserBean).where(builder);
        return new QueryDslPaging<>(pageable, query, UserBean.class, UserDto.class);
    }

}

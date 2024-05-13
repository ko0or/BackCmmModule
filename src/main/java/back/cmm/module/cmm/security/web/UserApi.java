package back.cmm.module.cmm.security.web;

import back.cmm.module.cmm.base.util.QueryDslPaging;
import back.cmm.module.cmm.security.domain.UserBean;
import back.cmm.module.cmm.security.dto.UserDto;
import back.cmm.module.cmm.security.service.UserService;
import back.cmm.module.cmm.security.util.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API", description = "유저 정보 조회")
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserApi {
    private final SecurityUtil securityUtil;
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @Operation(summary = "현재 로그인된 나의 권한 조회")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(securityUtil.getUserDtoWithAuthorities());
    }

    @GetMapping("{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(summary = "유저명으로 권한 조회")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "username") String username) {
        return ResponseEntity.ok(securityUtil.getUserDtoWithAuthorities(username));
    }

    @GetMapping("list")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(summary = "모든 유저 조회")
    public QueryDslPaging<UserDto> getUsers(Pageable pageable) {
        return userService.list(pageable);
    }

}

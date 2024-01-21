package back.cmm.module.cmm.web;

import back.cmm.module.cmm.dto.UserDto;
import back.cmm.module.cmm.util.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "UserController", description = "유저 정보 조회")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SecurityUtil securityUtil;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @Operation(summary = "현재 로그인된 나의 권한 조회")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(securityUtil.getMyUserWithAuthorities());
    }

    @GetMapping("{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(summary = "유저명으로 권한 조회 (운영자 기능)")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(securityUtil.getUserWithAuthorities(username));
    }

}

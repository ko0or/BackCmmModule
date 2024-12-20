package back.cmm.module.cmm.security.web;

import back.cmm.module.cmm.security.dto.LoginDto;
import back.cmm.module.cmm.security.dto.TokenDto;
import back.cmm.module.cmm.security.dto.UserDto;
import back.cmm.module.cmm.security.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth API", description = "로그인 및 회원가입")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthApi {
    private final UserServiceImpl userService;

    @PostMapping("login")
    @Operation(summary = "로그인 성공시 JWT 토큰 리턴", description = "Login ID: admin, PW: admin")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @PostMapping("signup")
    @Operation(summary = "username, password 값을 받아 회원 등록")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

}

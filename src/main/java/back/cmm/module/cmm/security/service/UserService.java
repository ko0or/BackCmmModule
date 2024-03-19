package back.cmm.module.cmm.security.service;

import back.cmm.module.cmm.security.dto.LoginDto;
import back.cmm.module.cmm.security.dto.TokenDto;
import back.cmm.module.cmm.security.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<TokenDto> login(LoginDto loginDto);
    public UserDto signup(UserDto userDto);
}
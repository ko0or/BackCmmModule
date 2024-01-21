package back.cmm.module.cmm.service;

import back.cmm.module.cmm.dto.LoginDto;
import back.cmm.module.cmm.dto.TokenDto;
import back.cmm.module.cmm.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<TokenDto> login(LoginDto loginDto);
    public UserDto signup(UserDto userDto);
}

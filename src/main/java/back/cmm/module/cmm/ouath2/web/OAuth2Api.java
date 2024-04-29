package back.cmm.module.cmm.ouath2.web;

import back.cmm.module.cmm.ouath2.service.OAuth2Service;
import back.cmm.module.cmm.security.dto.TokenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "OAuth2 API", description = "RestTemplate 기반으로 소셜 로그인 진행")
@RestController
@RequestMapping("/oauth2")
public class OAuth2Api {

    @Resource private OAuth2Service oAuth2Service;

    @Operation(summary = "카카오 로그인후 발급된 AccessToken을 이용한 로그인 방식")
    @GetMapping("kakao")
    public ResponseEntity<TokenDto> kakaoLogin(@RequestParam(name = "accessToken") String accessToekn) {
        return oAuth2Service.kakaoLogin(accessToekn);
    }

    @Operation(summary = "네이버 로그인후 발급된 AccessToken을 이용한 로그인 방식")
    @GetMapping("naver")
    public ResponseEntity<TokenDto> naverLogin(@RequestParam(name = "accessToken") String accessToekn) {
        return oAuth2Service.naverLogin(accessToekn);
    }

    @Operation(summary = "구글 로그인후 발급된 code를 이용한 로그인 방식")
    @GetMapping("google")
    public ResponseEntity<TokenDto> googleLogin(@RequestParam(name = "code") String code) {
        return oAuth2Service.googleLogin(code);
    }

}

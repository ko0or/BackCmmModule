package back.cmm.module.cmm.ouath2.web;

import back.cmm.module.cmm.ouath2.service.OAuth2Service;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth2")
public class OAuth2Api {

    @Resource private OAuth2Service oAuth2Service;

    @GetMapping("kakao")
    public ResponseEntity<Object> kakaoLogin(@RequestParam(name = "accessToken") String accessToekn) {
        return oAuth2Service.kakaoLogin(accessToekn);
    }

    @GetMapping("naver")
    public ResponseEntity<Object> naverLogin(@RequestParam(name = "accessToken") String accessToekn) {
        return oAuth2Service.naverLogin(accessToekn);
    }

    @GetMapping("google")
    public ResponseEntity<Object> googleLogin(@RequestParam(name = "code") String code) {
        return oAuth2Service.googleLogin(code);
    }

}

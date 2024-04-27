package back.cmm.module.cmm.ouath2.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ouath")
public class OAuth2Api2 {



    // FIXME : 결과에서 이메일,썸넬 .. 등 특정 필드만 뽑아오기

    @GetMapping("naver")
    public ResponseEntity<Object> test(@RequestParam(name = "access_token") String token) {
        System.out.println(" naver access token :" + token);
        ResponseEntity<Object> resultObj = getInfoByToeken(token);

        System.out.println("호출 결과 -> " + resultObj);
        return ResponseEntity.ok().body(resultObj);

    }

    
    public ResponseEntity<Object> getInfoByToeken(String token) {

        HttpHeaders httpHeaders2 = new HttpHeaders();
        httpHeaders2.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders2.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        HttpEntity<MultiValueMap<String, String>> httpEntity2 = new HttpEntity<>(httpHeaders2);
        RestTemplate restTemplate2 = new RestTemplate();

        return restTemplate2.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                httpEntity2,
                Object.class
        );

    }


}

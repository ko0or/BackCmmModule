package back.cmm.module.nginx.web;

import back.cmm.module.nginx.service.NginxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("nginx")
public class NginxApi {

    private final NginxService nginxService;

    @PostMapping("reg")
    public Map<String, Object> regNginx(@RequestParam("domainNm") String domainNm, @RequestParam("itrPort") int itrPort) {
        return nginxService.regAll(domainNm, itrPort);
    }

}

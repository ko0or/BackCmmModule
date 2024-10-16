package back.cmm.module.nginx.service;

import java.util.Map;

public interface NginxService {

    Map<String, Object> regAll(String domainNm, int itrPort);
    void regDomain(String domainNm, int itrPort);
    Map<String, Object> regLink(String domainNm);
    Map<String, Object> regSSL(String domain);
    Map<String, Object> reStart();

}

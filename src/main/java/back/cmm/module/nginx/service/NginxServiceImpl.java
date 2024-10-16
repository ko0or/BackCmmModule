package back.cmm.module.nginx.service;

import back.cmm.module.cmm.base.util.ExecUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NginxServiceImpl implements NginxService {

    private final ExecUtil execUtil;
    private final static String EMAIL = "taehwa10404@naver.com";
    private final static String NGINX_FILE_PATH = "/etc/nginx/sites-available/"; /*private final static String NGINX_FILE_PATH = "/Users/mw/Desktop/";*/
    private final static String LINK_FILE_PATH = "/etc/nginx/sites-enabled/";
    private final static String SERVER_IP_ADDR = "http://43.203.33.40";

    @Override
    public Map<String, Object> regAll(String domainNm, int itrPort) {
        regDomain(domainNm, itrPort);
        regLink(domainNm);
        regSSL(domainNm);
        return reStart();
    }

    @Override
    public void regDomain(String domainNm, int itrPort) {
        StringBuffer sb = new StringBuffer();
        sb.append("server {");
        sb.append("\n     listen 80;");
        sb.append("\n     server_name " + domainNm + ";");
        sb.append("\n ");
        sb.append("\n     location / {");
        sb.append("\n         proxy_pass " + SERVER_IP_ADDR + ":" + itrPort + ";");
        sb.append("\n         proxy_set_header Host $host;");
        sb.append("\n         proxy_set_header X-Real-IP $remote_addr;");
        sb.append("\n         proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;");
        sb.append("\n         proxy_set_header X-Forwarded-Proto $scheme;");
        sb.append("\n    }");
        sb.append("\n}");
        String command = sb.toString();

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(NGINX_FILE_PATH + domainNm, false));
            fw.write(command);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, Object> regLink(String domainNm) {
        return execUtil.execCmd("sudo", "ln", "-s", NGINX_FILE_PATH + domainNm + LINK_FILE_PATH);
    }

    @Override
    public Map<String, Object> regSSL(String domain) {
        return execUtil.execCmd("sudo", "certbot", "--nginx", "-d", domain, "--email", EMAIL, "--agree-tos", "--no-eff-email", "--non-interactive");
    }

    @Override
    public Map<String, Object> reStart() {
        return execUtil.execCmd("sudo", "systemctl", "restart", "nginx");
    }

}

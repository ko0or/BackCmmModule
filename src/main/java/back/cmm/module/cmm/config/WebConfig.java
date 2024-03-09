package back.cmm.module.cmm.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WebConfig extends CommonsRequestLoggingFilter {

    public WebConfig() {
        this.setIncludePayload(true);
        this.setIncludeQueryString(true);

        this.setIncludeHeaders(false);
        this.setIncludeClientInfo(false);
        this.setMaxPayloadLength(2_147_483_647);
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n" + "================================================ HTTP REQUEST LOG [ " + request.getRequestURL() + " : " + request.getMethod() + " ] ==============================================================\n");
//        sb.append("METHOD : " + request.getMethod() + "\n"); // POST
//        sb.append("getQueryString : " + request.getQueryString() + "\n"); // null
//        sb.append("getServletPath : " + request.getServletPath() + "\n"); // URI와 동일
//        sb.append("getCharacterEncoding : " + request.getCharacterEncoding() + "\n");
//        sb.append("getProtocol : " + request.getProtocol() + "\n"); // HTTP/1.1
//        sb.append("getContentType : " + request.getContentType() + "\n"); // application/json
//        sb.append("getRequestURL : " + request.getRequestURL() + "\n"); // http://localhost:8080/auth/login
//        sb.append(".getCharacterEncoding : " + request.getCharacterEncoding() + "\n"); // UTF-8
//        sb.append(".getContentType : " + request.getContentType() + "\n");  // application/json
//        sb.append(".getLocalAddr : " + request.getLocalAddr() + "\n"); // 0:0:0:0:0:0:0:1
//        sb.append(message);

        super.beforeRequest(request, sb.toString());
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        String suffix = "]\n\n====================================================================================================================================================================\n";
        super.afterRequest(request, message + suffix);
    }

    private String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd(E요일) HH시 mm분 ss초").format(new Date());
    }

}
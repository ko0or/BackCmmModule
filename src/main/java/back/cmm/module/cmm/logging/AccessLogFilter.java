package back.cmm.module.cmm.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class AccessLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        CustomRequestWrapper customRequestWrapper = new CustomRequestWrapper((HttpServletRequest) request);
        String accessLog = buildAccessLog(customRequestWrapper);

        log.debug(
                "\n\n=============================================================== [ HTTP REQUEST : " + getDateTime() +" ] ===============================================================\n\n"
                + accessLog
        );

        try {
            chain.doFilter(customRequestWrapper, response);
            log.debug("\n\n==============================================================================================================================================================================");
        } finally {
            customRequestWrapper.setBody(null);
        }
    }

    private String buildAccessLog(CustomRequestWrapper customRequestWrapper) {
        StringBuilder sb = new StringBuilder();

        appendKeyValue(sb, "METHOD", getMethod(customRequestWrapper));
        appendKeyValue(sb, "URL", getRequestURL(customRequestWrapper));
        appendKeyValue(sb, "QUERY_STRING", getQueryString(customRequestWrapper));
        appendKeyValue(sb, "BODY", getRequestBody(customRequestWrapper));
        appendKeyValue(sb, "REMOTE_ADDR", getRemoteAddr(customRequestWrapper));

        return sb.toString();
    }

    private void appendKeyValue(StringBuilder sb, String key, String value) {
        if (value != null && !value.isEmpty()) {
            sb.append(key).append(" : ").append(value).append("\n");
        }
    }

    private String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd(E요일) HH시 mm분 ss초").format(new Date());
    }

    private String getRequestBody(CustomRequestWrapper customRequestWrapper) {
        String content = null;
        String method = customRequestWrapper.getMethod().toLowerCase();

        // POST, PUT + application/json
        if (method.startsWith("p")) {
            if (customRequestWrapper.getContentType().toLowerCase().indexOf("json") > 0) {
                try {
                    content = new String(customRequestWrapper.getBody(), customRequestWrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return content;
    }

    private String getQueryString(CustomRequestWrapper customRequestWrapper) {
        String queryString = null;
        if (customRequestWrapper.getQueryString() != null) {
            queryString = customRequestWrapper.getQueryString();
        }
        return queryString;
    }

    private String getMethod(CustomRequestWrapper customRequestWrapper) {
        return customRequestWrapper.getMethod();
    }

    private String getRemoteAddr(CustomRequestWrapper customRequestWrapper) {
        return customRequestWrapper.getRemoteAddr();
    }

    private String getRequestURL(CustomRequestWrapper customRequestWrapper) {
        return customRequestWrapper.getRequestURL().toString();
    }

}
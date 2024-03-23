package back.cmm.module.cmm.base.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

@Slf4j
@Component
public class AccessLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        boolean isBodyLoggable = isBodyLoggable(httpRequest);

        ServletRequest req = isBodyLoggable ? new CustomRequestWrapper(httpRequest) : httpRequest;
        logRequestDetails(req);

        try {
            chain.doFilter(req, res);
        } finally {
            logRequestDetailsEnd(req);
        }
    }

    private boolean isBodyLoggable(HttpServletRequest request) {
        String contentType = request.getContentType();
        String requestUrl = request.getRequestURL().toString();
        boolean isMultipart = contentType != null && contentType.contains("multipart/form-data");
        boolean isSwagger = Stream.of("swagger-ui", "v3/api-docs").anyMatch(requestUrl::contains);

        return !(isMultipart || isSwagger); // body 본문은 읽을 수 있는 타입 : 첨부파일 or 스웨거 주소가 아닌경우에만
    }


    private void logRequestDetails(ServletRequest request) {
        log.debug("\n\n" +
                "=============================================================== [ HTTP REQUEST : " + getDateTime() + " ] ===============================================================\n\n" +
                buildAccessLog(request)
        );
    }

    private String buildAccessLog(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        StringBuilder sb = new StringBuilder();

        appendKeyValue(sb, "METHOD", httpRequest.getMethod());
        appendKeyValue(sb, "URL", httpRequest.getRequestURL().toString());
        appendKeyValue(sb, "QUERY_STRING", httpRequest.getQueryString());
        appendKeyValue(sb, "REMOTE_ADDR", httpRequest.getRemoteAddr());

        // 요청 받은 body를 파싱 가능하경우 (= isBodyLoggable)
        if (request instanceof CustomRequestWrapper) {
            appendKeyValue(sb, "BODY", getRequestBody((CustomRequestWrapper)request));
        }

        return sb.toString();
    }


    private String getRequestBody(CustomRequestWrapper request) {
        try {
            String content = new String(request.getBody(), request.getCharacterEncoding());
            return request.getContentType() != null && request.getContentType().toLowerCase().contains("json") && !content.isEmpty() ? content : null;
        } catch (IOException e) {
            log.error("[!] 바디 본문을 읽을 수 없는 사유 발생 : ", e);
            return null;
        }
    }

    private void appendKeyValue(StringBuilder sb, String key, String value) {
        if (value != null && !value.isEmpty()) {
            sb.append(key).append(" : ").append(value).append("\n");
        }
    }

    private String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd(E요일) HH시 mm분 ss초").format(new Date());
    }

    private void logRequestDetailsEnd(ServletRequest request) {
        if (request instanceof CustomRequestWrapper) {
            ((CustomRequestWrapper) request).setBody(null);
        }
        log.debug("\n\n==============================================================================================================================================================================");
    }
}

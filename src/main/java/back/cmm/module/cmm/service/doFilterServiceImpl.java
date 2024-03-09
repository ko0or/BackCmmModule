package back.cmm.module.cmm.service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

@Slf4j
@Component
public class doFilterServiceImpl extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/*
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpRequest);
        wrappedRequest.getParameterMap(); // 이렇게 호출하면 request body를 읽어와 캐싱합니다.
        String body = new String(wrappedRequest.getContentAsByteArray());

        log.info("========================================== doFilter ======================================================");
        log.info("요청 시간 : " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

        log.info("URI : " + httpRequest.getRequestURI()); // /auth/login

        log.info("Request body: {}", new String(wrappedRequest.getContentAsString()));
        log.info("BODY : " + body); //

        log.info("METHOD : " + httpRequest.getMethod()); // POST
        log.info("getQueryString : " + httpRequest.getQueryString()); // null
        log.info("getServletPath : " + httpRequest.getServletPath()); // URI와 동일
        log.info("getCharacterEncoding : " + httpRequest.getCharacterEncoding());
        log.info("getProtocol : " + httpRequest.getProtocol()); // HTTP/1.1
        log.info("getContentType : " + httpRequest.getContentType()); // application/json
        log.info("getRequestURL : " + httpRequest.getRequestURL()); // http://localhost:8080/auth/login
        log.info(".getCharacterEncoding : " + httpRequest.getCharacterEncoding()); // UTF-8
        log.info(".getContentType : " + httpRequest.getContentType());  // application/json
        log.info(".getLocalAddr : " + httpRequest.getLocalAddr()); // 0:0:0:0:0:0:0:1


*/
/*
        log.info("getParameterNames : " + httpRequest.getParameterNames());
        log.info("getAttributeNames : " + httpRequest.getAttributeNames());
        log.info("getHeaderNames : " + httpRequest.getHeaderNames());
        log.info("getParameterMap : " + httpRequest.getParameterMap());
*//*




//        log.info(".getCharacterEncoding : " + request.getCharacterEncoding()); // UTF-8
//        log.info(".getContentType : " + request.getContentType());  // application/json
//        log.info(".getLocalAddr : " + request.getLocalAddr()); // 0:0:0:0:0:0:0:1
        log.info("==========================================================================================================");

*/
        chain.doFilter(request, response);
    }
}

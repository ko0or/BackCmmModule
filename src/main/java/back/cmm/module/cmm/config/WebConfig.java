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
        String prefix = "\n\n" +
                "================================================== HTTP REQUEST LOG [ " + getDateTime() +  " ] ================================================================\n\n" +
                getDateTime() + " : [";
        super.beforeRequest(request, prefix + message);
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
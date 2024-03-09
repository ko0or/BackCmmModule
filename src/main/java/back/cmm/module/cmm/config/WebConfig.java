package back.cmm.module.cmm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class WebConfig {

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {

        CommonsRequestLoggingFilter c = new CommonsRequestLoggingFilter();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd(E요일) HH시 mm분 ss초").format(new Date());
        String prefix = "\n\n" + "================================================== HTTP REQUEST LOG [ " + dateFormat +  " ] ================================================================\n\n" +
                dateFormat + " : [";

        c.setIncludePayload(true);
        c.setIncludeQueryString(true);

        c.setIncludeHeaders(false);
        c.setIncludeClientInfo(false);
        c.setMaxPayloadLength(100_000);

        c.setBeforeMessagePrefix(prefix);
        c.setAfterMessageSuffix("]\n\n====================================================================================================================================================================\n");
        return c;
    }

}

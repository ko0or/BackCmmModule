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
        c.setBeforeMessagePrefix("\n\n================================================== HTTP REQUEST LOG [ "+ new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss (a)").format(new Date()) + " ] ================================================================\n\n[");

        c.setIncludePayload(true);
        c.setIncludeQueryString(true);

        c.setIncludeHeaders(false);
        c.setIncludeClientInfo(false);
        c.setMaxPayloadLength(100_000);

        c.setAfterMessageSuffix("]\n\n====================================================================================================================================================================\n");
        return c;
    }

}

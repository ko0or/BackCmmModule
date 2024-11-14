package back.cmm.module.cmm.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.setAllowedHeaders(ALLOW_HEADER_LIST);
      config.setAllowedOriginPatterns(ALLOW_ORIGIN_LIST);
      config.setAllowedMethods(ALLOW_METHOD_LIST);
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
   }

   private final static List<String> ALLOW_ORIGIN_LIST = new ArrayList<>(
           Arrays.asList(
                   "https://dangcoding.kro.kr",
                   "http://dangcoding.kro.kr",
                   "http://dockermng.kro.kr",
                   "https://dockermng.kro.kr",
                   "http://dockermng.kro.kr:8080",
                   "http://43.203.33.40:8080",
                   "http://43.203.33.40:12000",
                   "http://localhost:3000",
                   "http://localhost:3003"
           )
   );
   private final static List<String> ALLOW_HEADER_LIST = new ArrayList<>(
           Arrays.asList(
                   "Authorization",
                   "Content-Type",
                   "x-requested-with",
                   "Access-Control-Allow-Origin"
           )
   );
   private final static List<String> ALLOW_METHOD_LIST = new ArrayList<>(
           Arrays.asList(
                   "GET",
                   "POST",
                   "DELETE",
                   "OPTIONS"
           )
   );
}

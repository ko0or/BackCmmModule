package back.cmm.module.cmm.config;

import back.cmm.module.cmm.jwt.JwtAccessDeniedHandler;
import back.cmm.module.cmm.jwt.JwtAuthenticationEntryPoint;
import back.cmm.module.cmm.jwt.JwtSecurityConfig;
import back.cmm.module.cmm.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private static final String[] ALLOW_SWAGGER = {
            /* swagger v2 */
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            /*swagger v3 */
            "/v3/api-docs/**",
            "/swagger-ui/**",
    };
    private static final String[] PUBLIC_ALLOW_GET_LIST = {
            "/auth/login",
            "/auth/reg",
    };
    private static final String[] PUBLIC_ALLOW_POST_LIST = {
            "/auth/login",
            "/auth/reg",
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            )

            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers(PathRequest.toH2Console()).permitAll() // h2-console
                .requestMatchers(HttpMethod.GET,  ALLOW_SWAGGER).permitAll() // swagger doc
                .requestMatchers(HttpMethod.GET, PUBLIC_ALLOW_GET_LIST).permitAll() // public api [GET]
                .requestMatchers(HttpMethod.POST, PUBLIC_ALLOW_POST_LIST).permitAll() // public api  [POST]
                .anyRequest().authenticated()
            ).with(new JwtSecurityConfig(tokenProvider), customizer -> {});

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
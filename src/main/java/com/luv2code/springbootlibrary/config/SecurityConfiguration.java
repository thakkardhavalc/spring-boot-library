package com.luv2code.springbootlibrary.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Created By dhhaval thakkar on 2024-02-02
 */
@Configuration
public class SecurityConfiguration {
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/books/secure/**",
                        "/api/reviews/secure/**",
                        "/api/messages/secure/**",
                        "/api/admin/secure/**")
                .authenticated()
                .anyRequest()
                .permitAll());
        http.csrf(AbstractHttpConfigurer::disable);
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));
        http.cors(Customizer.withDefaults());
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }
}

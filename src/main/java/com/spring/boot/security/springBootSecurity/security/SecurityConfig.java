package com.spring.boot.security.springBootSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((request)->{
            request.requestMatchers("/balance").authenticated();
            request.anyRequest().permitAll();
        });
        http.formLogin(request -> request.permitAll());
        return http.build();
    }
}

package com.spring.boot.security.springBootSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((request)->{
            request.requestMatchers("/balance","/card").hasRole("User");
            request.requestMatchers("/accounts").hasRole("Admin");
            request.anyRequest().permitAll();
        });

        http.formLogin(request -> {
            request.permitAll();
        });
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User
                .withUsername("user1")
                .password("pwd123")
               .passwordEncoder(this::encodePassword)
                .roles("User")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password("admin")
                .passwordEncoder(this::encodePassword)
                .roles("Admin")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    private String encodePassword(String s) {
        return this.passwordEncoder().encode(s);
    }

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

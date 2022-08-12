package com.github.javamultiplex.config;

import com.github.javamultiplex.security.filters.CustomAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Rohit Agarwal on 07/08/22 12:14 am
 * @copyright github.com/javamultiplex
 */
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .build();
    }
}

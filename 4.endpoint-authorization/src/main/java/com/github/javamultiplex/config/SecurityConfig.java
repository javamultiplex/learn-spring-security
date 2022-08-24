package com.github.javamultiplex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Rohit Agarwal on 25/08/22 12:35 am
 * @copyright github.com/javamultiplex
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                //.authenticated()
                //.permitAll()
                //.denyAll()
                //.hasAuthority("write")
                //.hasAnyAuthority("write","read")
                //.hasRole("student")
                //.hasAnyRole("student","admin")
                .access("isAuthenticated() and hasRole('admin')")
                .and()
                .build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        final UserDetails userDetails1 = User
                .withUsername("rohit")
                .password(passwordEncoder().encode("password123"))
                .authorities("read")
                .roles("student")
                .build();
        final UserDetails userDetails2 = User
                .withUsername("bhavna")
                .password(passwordEncoder().encode("password12"))
                .authorities("write")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }
}

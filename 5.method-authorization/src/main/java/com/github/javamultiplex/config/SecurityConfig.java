package com.github.javamultiplex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Rohit Agarwal on 01/10/22 7:00 pm
 * @copyright github.com/javamultiplex
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        final UserDetails user1 = User.withUsername("rohit")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();

        final UserDetails user2 = User.withUsername("bhavna")
                .password(passwordEncoder().encode("12345"))
                .authorities("write")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

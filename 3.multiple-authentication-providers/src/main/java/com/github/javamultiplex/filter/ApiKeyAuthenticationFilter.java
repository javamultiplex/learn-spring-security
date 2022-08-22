package com.github.javamultiplex.filter;

import com.github.javamultiplex.authentication.ApiKeyAuthentication;
import com.github.javamultiplex.manager.ApiKeyAuthenticationManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rohit Agarwal on 21/08/22 12:20 am
 * @copyright github.com/javamultiplex
 */

@Component
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    @Value("${secret.key}")
    private String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestKey = request.getHeader("x-api-key");
        System.out.println("Request Key : " + requestKey);
        if (requestKey == null || requestKey.isBlank()) {
            filterChain.doFilter(request, response);
            return;
        }
        final ApiKeyAuthentication apiKeyAuthentication = new ApiKeyAuthentication(requestKey);
        final ApiKeyAuthenticationManager apiKeyAuthenticationManager = new ApiKeyAuthenticationManager(key);
        final Authentication authenticate;
        try {
             authenticate = apiKeyAuthenticationManager.authenticate(apiKeyAuthentication);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (authenticate.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}

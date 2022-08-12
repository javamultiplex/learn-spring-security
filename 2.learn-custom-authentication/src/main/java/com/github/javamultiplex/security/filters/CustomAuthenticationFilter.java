package com.github.javamultiplex.security.filters;

import com.github.javamultiplex.security.authentication.CustomAuthentication;
import com.github.javamultiplex.security.managers.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rohit Agarwal on 07/08/22 12:17 am
 * @copyright github.com/javamultiplex
 */
@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var key = String.valueOf(request.getHeader("key"));
        var customAuthentication = new CustomAuthentication(false, key);
        var authentication = authenticationManager.authenticate(customAuthentication);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}

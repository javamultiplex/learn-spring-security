package com.github.javamultiplex.security.providers;

import com.github.javamultiplex.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author Rohit Agarwal on 07/08/22 12:35 am
 * @copyright github.com/javamultiplex
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${secret.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication customAuthentication = (CustomAuthentication) authentication;
        if (key.equals(customAuthentication.getKey())){
            return new CustomAuthentication(true, null);
        }
        throw new BadCredentialsException("Key is not same!!!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}

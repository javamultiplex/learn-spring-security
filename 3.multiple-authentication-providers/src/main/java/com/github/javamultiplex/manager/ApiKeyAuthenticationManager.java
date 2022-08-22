package com.github.javamultiplex.manager;

import com.github.javamultiplex.provider.ApiKeyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author Rohit Agarwal on 21/08/22 7:18 pm
 * @copyright github.com/javamultiplex
 */

public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private final String key;

    public ApiKeyAuthenticationManager(String key) {
        this.key = key;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final ApiKeyAuthenticationProvider apiKeyAuthenticationProvider = new ApiKeyAuthenticationProvider(key);
        if (apiKeyAuthenticationProvider.supports(authentication.getClass())) {
            return apiKeyAuthenticationProvider.authenticate(authentication);
        }
        throw new BadCredentialsException("Authentication Provider not found!!!");
    }
}

package com.github.javamultiplex.security.authentication;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Rohit Agarwal on 07/08/22 12:29 am
 * @copyright github.com/javamultiplex
 */

@AllArgsConstructor
public class CustomAuthentication implements Authentication {

    private final boolean authenticated;

    private final String key;

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }

    public String getKey() {
        return key;
    }
}

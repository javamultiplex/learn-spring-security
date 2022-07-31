package com.github.javamultiplex.security;

import com.github.javamultiplex.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Rohit Agarwal on 31/07/22 3:35 pm
 * @copyright github.com/javamultiplex
 */

public record SecurityAuthority(Authority authority) implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}

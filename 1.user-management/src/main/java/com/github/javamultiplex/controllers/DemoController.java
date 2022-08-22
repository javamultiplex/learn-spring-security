package com.github.javamultiplex.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 31/07/22 2:03 pm
 * @copyright github.com/javamultiplex
 */

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities()
                .forEach(a -> System.out.println("Authority: " + a.getAuthority()));
        return "demo";
    }
}

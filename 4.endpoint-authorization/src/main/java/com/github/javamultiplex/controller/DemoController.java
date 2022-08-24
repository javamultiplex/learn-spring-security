package com.github.javamultiplex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 25/08/22 12:34 am
 * @copyright github.com/javamultiplex
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "Demo";
    }
}

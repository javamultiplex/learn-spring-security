package com.github.javamultiplex.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 01/10/22 7:04 pm
 * @copyright github.com/javamultiplex
 */
@RestController
public class DemoController {

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('read')")
    public String demo1(){
        return "demo1";
    }

    @GetMapping("/demo2")
    @PreAuthorize("hasAnyAuthority('write','read')")
    public String demo2(){
        return "demo2";
    }

    @GetMapping("/demo3/{name}")
    @PreAuthorize("#name==Authentication.name")
    public String demo3(@PathVariable String name){
        return "demo3";
    }
}

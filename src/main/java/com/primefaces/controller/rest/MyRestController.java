package com.primefaces.controller.rest;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController extends SpringBootServletInitializer{
    
    @RequestMapping("/")
    public String home(){
        return "Sample Spring boot rest controller";
    }

}

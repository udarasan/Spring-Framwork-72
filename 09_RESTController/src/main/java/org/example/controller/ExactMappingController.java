package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exact")
public class ExactMappingController {

    @GetMapping(path = "/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping(path = "/hello/two")
    public String sayHelloGet(){
        return "Hello World TWO";
    }
    @GetMapping(path = "/hello/two/api")
    public String sayHelloPost(){
        return "Hello World Two API";
    }
}

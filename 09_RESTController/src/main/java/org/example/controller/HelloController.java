package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/two")
    public String sayHelloGet(){
        return "Hello World Get";
    }
    @PostMapping
    public String sayHelloPost(){
        return "Hello World Post";
    }
    @PutMapping
    public String sayHelloPut(){
        return "Hello World Put";
    }
    @DeleteMapping
    public String sayHelloDelete(){
        return "Hello World Delete";
    }
    @PatchMapping
    public String sayHelloPatch(){
        return "Hello World Patch";
    }

}

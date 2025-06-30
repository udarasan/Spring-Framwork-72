package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("HelloController Constructor");
    }
    @GetMapping()
    public String hello() {
        return "index";
        //return "Hello World Two";
    }
}

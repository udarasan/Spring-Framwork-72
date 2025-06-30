package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/char")
public class CharacterMappingController {


    //IP12
    //I123
    @GetMapping(path = "item/I???")
    public String sayHello(){
        return "Hello World Item";
    }
    //char/1234/search
    //char/absd/search
    @GetMapping("????/search")
    public String sayHelloGet(){
        return "Hello World search";
    }
}

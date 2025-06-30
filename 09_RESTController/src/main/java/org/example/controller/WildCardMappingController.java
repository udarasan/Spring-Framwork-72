package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("one")
@RestController
public class WildCardMappingController {

    //one/test/hello - matching or not matching
    //one//hello/ - matching or not matching
    //one/123/hello - matching or not matching
    //one/test/123/hello - matching or not matching
//    @GetMapping("test/*/hello")
//    public String sayHello(){
//        return "Hello World";
//    }
//    @GetMapping("hello/**/ijse")
//    public String sayHelloPost2(){
//        return "Hello World 2 ijse";
//    }

//    @GetMapping("hello/*/*")
//    public String sayHelloPost(){
//        return "Hello World 2";
//    }


}

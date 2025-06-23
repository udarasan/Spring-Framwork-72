package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne {
    private SpringBeanOne() {
        System.out.println("SpringBeanOne");
    }
}

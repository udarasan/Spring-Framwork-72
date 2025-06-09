package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean Object Created");
    }
    public void testBean() {
        System.out.println("TestBean Method Called");
    }
}

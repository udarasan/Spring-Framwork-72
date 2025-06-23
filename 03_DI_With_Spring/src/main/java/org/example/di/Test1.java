package org.example.di;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements DI {
    public Test1() {
        System.out.println("Test1 Constructor called");
    }

    @Override
    public void sayHello() {
        System.out.println("Test1 Say Hello");
    }
}

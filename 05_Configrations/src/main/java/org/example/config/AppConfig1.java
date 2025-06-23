package org.example.config;

import org.example.bean.A;
import org.example.bean.B;
import org.example.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class AppConfig1 {
    @Bean
    public A a() {
        return new A();
    }
    @Bean
    public B b() {
        return new B();
    }

}

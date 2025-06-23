package org.example.config;

import org.example.bean.C;
import org.example.bean.D;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean
    public C c() {
        return new C();
    }
    @Bean
    public D d() {
        return new D();
    }
}

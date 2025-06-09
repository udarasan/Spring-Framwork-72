package org.example.config;

import org.example.bean.MyConnection;
import org.example.bean.TestBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
//@ComponentScan(basePackageClasses = TestBean1.class)
public class AppConfig {
    @Bean("san")
    MyConnection getConnection(){
        return new MyConnection();
    }
}

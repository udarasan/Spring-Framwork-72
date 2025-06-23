package org.example;

import org.example.bean.SpringBean;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        SpringBean bean = context.getBean(SpringBean.class);
        System.out.println(bean);

        context.registerShutdownHook();
    }
}
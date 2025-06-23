package org.example;

import org.example.bean.*;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean bean = context.getBean(SpringBean.class);
        A a = context.getBean(A.class);
        B b = context.getBean(B.class);
        C c = context.getBean(C.class);
        D d = context.getBean(D.class);

        System.out.println(bean);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        context.registerShutdownHook();
    }
}
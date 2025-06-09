package org.example;

import org.example.bean.SpringBean;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean bean1 =context.getBean(SpringBean.class);
        bean1.testBean();
        System.out.println(bean1);

        SpringBean bean2 =context.getBean(SpringBean.class);
        bean2.testBean();
        System.out.println(bean2);

        context.close();
    }
}
package org.example;

import org.example.bean.SpringBean;
import org.example.bean.TestBean1;
import org.example.bean.TestBean2;
import org.example.bean.TestBean3;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean bean1 =context.getBean(SpringBean.class);
        bean1.testBean();
        System.out.println(bean1);

        TestBean1 testBean1=context.getBean(TestBean1.class);
        System.out.println(testBean1);
        TestBean2 testBean2=context.getBean(TestBean2.class);
        System.out.println(testBean2);
        TestBean3  testBean3=context.getBean(TestBean3.class);
        System.out.println(testBean3);
        /*Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("JVM is about to shutdown");
            context.close();
        }));*/
        context.registerShutdownHook();

    }
}
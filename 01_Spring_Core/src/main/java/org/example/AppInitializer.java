package org.example;

import org.example.bean.MyConnection;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        /*TestBean1 testBean1=context.getBean(TestBean1.class);
        System.out.println(testBean1);

        //request bean from bean ID(Class Name (first letter ->simple letter)
        TestBean1 byBeanID= (TestBean1) context.getBean("testBean1");
        System.out.println(byBeanID);
        TestBean2 testBean2=context.getBean("udara",TestBean2.class);
        System.out.println(testBean2);*/
        MyConnection connection= (MyConnection)
                context.getBean("san");
        System.out.println(connection);

        context.registerShutdownHook();

    }
}
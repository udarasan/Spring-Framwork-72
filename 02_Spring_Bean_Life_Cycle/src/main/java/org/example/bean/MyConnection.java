package org.example.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements DisposableBean,
        BeanNameAware, BeanFactoryAware , ApplicationContextAware,
        InitializingBean {
    //the state of the object creation
    public MyConnection() {
        System.out.println("MyConnection Constructor Called");
    }
    // there is no method to find state of the properties

    //Bean Name Aware(Bean ID)
    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection setBeanName Called");
    }

    //Bean Factory Aware (DI)
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection setBeanFactory Called");
    }

    //Application context aware (AOP and DP)
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyConnection setApplicationContext Called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection is destroyed");
    }


}

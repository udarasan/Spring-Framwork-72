package org.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("udara-san")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }

  /*  @Autowired(required = false)
    public SpringBean(@Value("udara") String name) {
        System.out.println("SpringBean Constructor : "+name);
        //System.out.println("SpringBean Constructor : "+number);
        //System.out.println("SpringBean Constructor : "+b);
    }
    @Autowired(required = false)
    public SpringBean(@Value("udara") String name,@Value("23") int number) {
        System.out.println("SpringBean Constructor : "+name);
        System.out.println("SpringBean Constructor : "+number);
    }*/
}

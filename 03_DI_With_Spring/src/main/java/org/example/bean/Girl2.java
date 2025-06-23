package org.example.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Girl2 implements Agreement {
    public Girl2() {
        System.out.println("Girl Constructor");
    }
    @Override
    public void chat() {
        System.out.println("Girl 2 Chatting...");
    }
}

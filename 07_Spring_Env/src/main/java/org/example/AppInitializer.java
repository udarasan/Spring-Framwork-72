package org.example;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

       /* //access system environment variables
        Map<String,String> getenv=System.getenv();
        for(String key:getenv.keySet()){
            System.out.println(key+":"+getenv.get(key));
        }

        System.out.println("======================================");

        //Access Java Environment variables
        Properties properties=System.getProperties();
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key+":"+properties.get(key));
        }
        System.out.println("=====================================");
        String osName = System.getProperty("os.name");
        System.out.println(osName);*/

        context.registerShutdownHook();
    }
}
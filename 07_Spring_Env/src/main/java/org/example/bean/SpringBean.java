package org.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean{
    @Value("${os.name}")
    private String osName;

    @Value("${user.name}")
    private String LOGNAME;

    @Value("${db.name}")
    private String dbname;
    @Value("${db.user}")
    private String dbuser;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
        System.out.println(LOGNAME);
        System.out.println(dbname);
        System.out.println(dbuser);
    }
}

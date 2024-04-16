package org.spring.demo;

import org.spring.demo.config.IocConfig;
import org.spring.demo.service.DataSourceServie;
import org.spring.demo.service.UserService;
import org.spring.demo.entity.User;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableCaching
@SpringBootApplication
public class CoreExample {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(CoreExample.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        System.out.println(user.getName());
        DataSourceServie dataSourceServie = context.getBean(DataSourceServie.class);
        dataSourceServie.getDataSourceServie();
    }

}
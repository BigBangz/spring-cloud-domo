package org.spring.demo.config;

import org.spring.demo.entity.DataSourcBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"org.spring.demo.service", "org.spring.demo.util"})
@PropertySource("app.properties")
@EnableAspectJAutoProxy
public class IocConfig {

    @Bean("one")
    DataSourcBean createDataSourceOne() {
        return new DataSourcBean("user1", "123456", "13306");
    }

    @Bean
    @Qualifier("two")
    DataSourcBean createDataSourceTwo() {
        return new DataSourcBean("user2", "123456", "13307");
    }
}

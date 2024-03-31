package modules.config;

import modules.entity.DataSourcBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("app.properties")
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

package modules.config;

import modules.config.Factory.YamlPropertyResourceFactory;
import modules.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 模拟基础设施配置
 */
@Configuration
@PropertySource(value = "classpath:application.yml",encoding = "utf-8",factory = YamlPropertyResourceFactory.class)
public class FacilityConfig {
    @Bean
    @ConditionalOnProperty(name = "source.enable", havingValue = "true")
    public User myFeature() {
        System.out.println("根据yaml配置开启");
        return new User(4, "bo2@qq.com", "password", "bo");
    }
}

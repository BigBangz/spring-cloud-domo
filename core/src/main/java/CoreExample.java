import modules.config.IocConfig;
import modules.config.service.DataSourceServie;
import modules.config.service.UserService;
import modules.entity.User;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableAutoConfiguration
public class CoreExample {

    @RequestMapping("/")
    String home() {
        return "Hello World2";
    }

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
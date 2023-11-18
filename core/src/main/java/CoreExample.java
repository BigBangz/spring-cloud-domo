import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class CoreExample {

	@RequestMapping("/")
	String home() {
		return "Hello World2";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CoreExample.class, args);
	}

}
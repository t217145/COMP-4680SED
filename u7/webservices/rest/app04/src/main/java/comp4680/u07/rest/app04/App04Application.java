package comp4680.u07.rest.app04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class App04Application {

	public static void main(String[] args) {
		SpringApplication.run(App04Application.class, args);
	}

}

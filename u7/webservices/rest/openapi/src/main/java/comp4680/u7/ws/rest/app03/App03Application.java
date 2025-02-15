package comp4680.u7.ws.rest.app03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class App03Application {

	public static void main(String[] args) {
		SpringApplication.run(App03Application.class, args);
	}

}

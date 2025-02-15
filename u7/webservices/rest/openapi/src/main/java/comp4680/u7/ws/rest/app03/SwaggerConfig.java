package comp4680.u7.ws.rest.app03;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Demo RESTful API with Swagger Doc")
                        .version("1.0.0")
                        .description("COMP4680SED Demo - RESTful API with Swagger Doc"));
    }
}
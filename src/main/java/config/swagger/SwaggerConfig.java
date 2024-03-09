package config.swagger;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.info.License;

public class SwaggerConfig {
    @Bean
    public OpenAPI custOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mercado libre API")
                        .version("0.0.1")
                        .description("API para el TPI de Mercado libre.")
                // .termsOfService("")
                // .license(new License().name("").url(""))
                );
    }
}

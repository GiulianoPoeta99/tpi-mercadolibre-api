package com.mercadolibre.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import config.swagger.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class MercadolibreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadolibreApiApplication.class, args);
	}

}

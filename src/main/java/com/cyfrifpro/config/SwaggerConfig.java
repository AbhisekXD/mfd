package com.cyfrifpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springShopOpenAPI() {
		return new OpenAPI().info(new Info().title("Mutual fund distributor App")
			.description("Backend APIs Mutual fund distributor app")
			.version("v1.0.0")
			.contact(new Contact().name("Cyfrifpro tech").url("www.cyfrifprotech.com").email("tech.ho@cyfrif.com"))
			.license(new License().name("License").url("/")))
			.externalDocs(new ExternalDocumentation().description("Mutual fund distributor App Documentation")
			.url("http://localhost:9090/swagger-ui/index.html"));
	}
	
}

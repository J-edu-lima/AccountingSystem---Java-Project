package com.j_edulima.accouting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Accouting API")
                        .version("1.0")
                        .description("Documentação da API de contabilidade")
                        .contact(new Contact()
                                .name("J-eduLima")
                                .url("https://github.com/J-edu-lima")
                                .email("limaedu18@hotmail.com"))
                        .license(new License()
                                .name("Licença Open Source")
                                .url("")));
    }
}

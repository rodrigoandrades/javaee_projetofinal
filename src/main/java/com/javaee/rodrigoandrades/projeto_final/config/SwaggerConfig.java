package com.javaee.rodrigoandrades.projeto_final.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	private String title = "Projeto Final";
	private String description = null;
	private String version = "1.0.0";
	private String termsOfServiceUrl = null;
	private Contact contact = null;
	private String license = null;
	private String licenseUrl = null;
    
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javaee.rodrigoandrades.projeto_final.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, Collections.emptyList()));
    }
}

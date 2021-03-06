package edu.mum.etudiant.cong;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class ConfigSwagger {

    @Bean

    public Docket StudentApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                   .select()
                   .apis(RequestHandlerSelectors.basePackage("edu.mum.etudiant.controller"))
                   .paths(regex("/student.*"))
                   .build()
                  .apiInfo(metadata());



    }


    private ApiInfo metadata(){
        ApiInfo api = new ApiInfo(

                "Spring Boot REST API",
                "Spring Boot REST API for Online School",
                "1.0",
                "Terms of service",
                new Contact("Jean Chrisner", "https://www.google.com", "jeancharles.jeanchrisner@gmail.com"),
                "chriso License Version 1.0",
                "https://www.google.com/LICENSE-1.0");




        return api;
    }


}

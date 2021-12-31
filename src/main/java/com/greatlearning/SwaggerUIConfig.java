package com.greatlearning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerUIConfig {

    ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Employee Management API - Spring Security")
                .description("You are required to create a Employee Management Rest Api based Web application, where you will be developing CRUD(Create,Read,Update and Delete) functionality along with Sorting and some concepts of security.")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("https://www.mygreatlearning.com/terms")
                .version("1.0.0")
                .contact(new Contact("Akash Jaiswal", "", "akash.jaiswal@gmail.com"))
                .build();
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.greatlearning.controller"))
                .build()
                .apiInfo(apiInfo());
    }
}

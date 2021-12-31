package com.greatlearning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.greatlearning")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.greatlearning.entities"})
@EnableJpaRepositories("com.greatlearning.repositories")
@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
public class EmployeeManagementCrmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementCrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

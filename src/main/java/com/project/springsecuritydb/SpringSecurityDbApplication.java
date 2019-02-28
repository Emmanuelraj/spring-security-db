package com.project.springsecuritydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.springsecuritydb.interfaces.UserRepository;



@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@SpringBootApplication
public class SpringSecurityDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApplication.class, args);
	}

}

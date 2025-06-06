package com.springboot.crudh2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.springboot.crudh2db"})
@EntityScan("com.springboot.crudh2db.entity")
@EnableJpaRepositories("com.springboot.crudh2db.repository")
public class Crudh2dbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Crudh2dbApplication.class, args);
	}

}

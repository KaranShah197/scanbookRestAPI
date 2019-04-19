package com.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BooksApplication {

	/*The main application class from which we start the Spring application */
	public static void main(String args[]) {
		SpringApplication.run(BooksApplication.class, args);
	}
	
	
}

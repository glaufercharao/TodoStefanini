package com.gsam.technology.todostefanini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoStefaniniApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoStefaniniApplication.class, args);
	}

}

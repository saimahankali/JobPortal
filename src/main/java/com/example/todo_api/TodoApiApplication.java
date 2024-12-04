package com.example.todo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetailsService;




@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(TodoApiApplication.class, args);

	}

}

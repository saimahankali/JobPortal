package com.example.todo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.todo_api.Temp.Computer;
import com.example.todo_api.Temp.Desktop;
import com.example.todo_api.Temp.Dev;
import com.example.todo_api.Temp.Laptop;
import com.example.todo_api.service.MyUserDetailsService;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		Dev dev;
		ApplicationContext context = SpringApplication.run(TodoApiApplication.class, args);
//		dev = context.getBean(Dev.class);
//		dev.greet1();
//		dev.greet2();
//		Computer lap = context.getBean(Laptop.class);
//		lap.compile();
//		
//		Computer des = context.getBean(Desktop.class);
//		des.compile();
		
//		MyUserDetailsService userDetailsService = context.getBean(MyUserDetailsService.class);
//		CompanyUserDetailsService companyUserDetailsService = context.getBean(CompanyUserDetailsService.class);
	}

}

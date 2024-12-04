package com.example.todo_api.Temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Component
public class Dev {
	@Qualifier("laptop")
	@Autowired
	Computer computer1;
	
	@Qualifier("desktop")
	@Autowired
	Computer computer2;
	
	public void greet1() {
		computer1.compile();
		System.out.println("Happy Coding!");
	}
	
	public void greet2() {
		computer2.compile();
		System.out.println("Happy Coding!");
	}
	
	
	
}

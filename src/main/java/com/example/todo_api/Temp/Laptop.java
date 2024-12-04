package com.example.todo_api.Temp;

import org.springframework.stereotype.Component;

@Component("laptop")
public class Laptop implements Computer{
	public void compile() {
		System.out.println("Compiling On Laptop");
	}
}

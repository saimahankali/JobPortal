package com.example.todo_api.Temp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("desktop")
//@Primary
public class Desktop implements Computer{
	public void compile() {
		System.out.println("Compiling On Desktop");
	}
}

package com.example.todo_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String Home() {
		return "Welcome to Karma..!";
	}
	
	@RequestMapping("/about")
	public ResponseEntity<String> about() {
	    return ResponseEntity.ok("We are from Karma!");
	}

	
	@GetMapping("/csrf")
	public String getToken(HttpServletRequest request) {
		return ""+(CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("/user/dashboard")
	public String userDashboard() {
		return "Welcome to User Dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		try {
		return "Welcome to Admin Dashboard";
		} catch (Exception e) {
			// TODO: handle exception
			return "Bro You Dont't have acess to it!";
		}
	}
}


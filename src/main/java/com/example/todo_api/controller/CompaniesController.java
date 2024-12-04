package com.example.todo_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.model.Companies;
import com.example.todo_api.service.CompaniesService;

@RestController
@RequestMapping("/company")
public class CompaniesController {
	
	@Autowired
	private CompaniesService companiesService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@PostMapping("/register")
	public String register(@RequestBody Companies user) {
		try {
			companiesService.register(user);
			return "Scussfully registered!";
		} catch (Exception e) {
			// TODO: handle exception
			return "failed to Register";
		}
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Companies company) {
	        try {
	            Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(company.getUsername(), company.getPassword())
	            );

	            if (authentication.isAuthenticated()) {
	                Map<String, String> response = new HashMap<>();
//	                response.put("token", jwtService.generateToken(company.getUsername()));
//	                response.put("message", "Login successful");
	                return ResponseEntity.ok(response);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Invalid username or password");
	        }
	        return ResponseEntity.badRequest().body("Authentication failed");
	    }
}

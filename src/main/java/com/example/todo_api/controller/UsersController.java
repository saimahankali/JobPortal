package com.example.todo_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.model.Users;
import com.example.todo_api.service.EmailService;
import com.example.todo_api.service.JwtService;
import com.example.todo_api.service.UsersService;
@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return usersService.register(user);
	}
	
	
//	@PostMapping("/login")
//	public String login(@RequestBody Users user){
//
//		Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//		if(authentication.isAuthenticated())
//			return jwtService.generateToken(user.getUsername());
//		else
//			return "Login Failed";
//
//	}
	
//	@PostMapping("/login")
//	public Object login(@RequestBody Users user){
//		try {
//		Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//		if(authentication.isAuthenticated()) {
//			Map<String, String> response = new HashMap<>();
//			response.put("token", jwtService.generateToken(user.getUsername()));
//			
//			response.putAll(usersService.getIdAndUsername(user.getUsername()));
//			return response;
//		}
//		}
//		 catch (Exception e) {
//			// TODO: handle exception
//			 return new HashMap<>().put("message", "Failed");
//		}
//		return null;
//
//	}
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            if (authentication.isAuthenticated()) {
                Map<String, String> response = new HashMap<>();
                response.put("token", jwtService.generateToken(user.getUsername()));
                response.put("message", "Login successful");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
        return ResponseEntity.badRequest().body("Authentication failed");
    }
	
	
	 @PostMapping("/forgot-password")
	    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> request) {
	        String email = request.get("email");
	        if (usersService.existsByEmail(email)) {
	            String resetToken = jwtService.generateToken(email, 2);// 5 minutes Expiry
	            // Send resetToken to user's email
	            emailService.sendPasswordResetEmail(email, resetToken);
	            System.out.println("Password reset email sent.");
	            return ResponseEntity.ok("Password reset email sent.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
	        }
	    }
	 
	    @PostMapping("/reset-password")
	    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestBody Map<String, String> request) {
	        System.out.println("I am in Reset");
	    	String email = jwtService.extractUserName(token);
	        if (jwtService.isTokenExpired(token)) {
	        	System.out.println("Token Expired..");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token has expired.");
	        }

	        // You can also add additional checks like verifying the token, user, etc.

	        String newPassword = request.get("newPassword");
	        if (usersService.resetPassword(email, newPassword)) {
	        	//Expired Token 0 minutes
	        	System.out.println("Password reset successful.");
//	        	  tokenBlacklistService.addToBlacklist(token);
	            return ResponseEntity.ok("Password reset successful.");
	        } else {
	        	System.out.println("Password reset failed.");
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password reset failed.");
	        }
	    }

}

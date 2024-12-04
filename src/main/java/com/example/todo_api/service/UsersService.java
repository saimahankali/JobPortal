package com.example.todo_api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todo_api.model.Users;
import com.example.todo_api.repository.UserRepository;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder; // Use the PasswordEncoder bean

    @Autowired
    private UserRepository userRepository;

    public Users register(Users user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("Error during user registration: " + e.getMessage());
            // Optionally, rethrow a custom exception
        }
        return user;
    }
    

    public boolean existsByEmail(String email) {
        // Check if user exists with this email
    	Users user = userRepository.findByUsername(email);
    	if (user != null) {
    		return true;
    	}
        return false;
    }

    public boolean resetPassword(String email, String newPassword) {
        // Logic to reset the password
        Users user = userRepository.findByUsername(email);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword)); // Encrypt the password before saving
            userRepository.save(user);
            return true;
        }
        return false;
    }


	public Map<String, String> getIdAndUsername(String username) {
		// TODO Auto-generated method stub
		Users user = userRepository.findByUsername(username);
		Map<String, String> response = new HashMap<>();
		response.put("userId", ""+user.getId());
		response.put("fullname", user.getFullname());
		return response;
	}
}

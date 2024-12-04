package com.example.todo_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.todo_api.model.UserPrincipal;
import com.example.todo_api.model.Users;
import com.example.todo_api.repository.UserRepository;

@Component("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepository.findByUsername(username);
		if (user == null) {
			System.out.println("User Not Found!");
			throw new UsernameNotFoundException("User Not Found!");
		}
		return new UserPrincipal(user);
	}

}

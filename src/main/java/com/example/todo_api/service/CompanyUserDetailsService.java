package com.example.todo_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.todo_api.model.Companies;
import com.example.todo_api.model.CompanyUserPrincipal;

import com.example.todo_api.repository.CompaniesRepository;

@Service("companyUserDetailsService")
public class CompanyUserDetailsService implements UserDetailsService{

	@Autowired
	private CompaniesRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Companies user = repository.findByUsername(username);
				if (user == null) {
					System.out.println("User Not Found!");
					throw new UsernameNotFoundException("User Not Found!");
				}
				return new CompanyUserPrincipal(user);
		}

}

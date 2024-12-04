package com.example.todo_api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todo_api.model.Companies;
import com.example.todo_api.repository.CompaniesRepository;

@Service
public class CompaniesService {
	
	@Autowired
	private CompaniesRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public void register(Companies company) throws Exception {
		company.setPassword(passwordEncoder.encode(company.getPassword()));
		repository.save(company);
	}
	
	public Map<? extends String, ? extends String> getIdAndUsername(String username) {
		// TODO Auto-generated method stub
		Companies user = repository.findByUsername(username);
		Map<String, String> response = new HashMap<>();
		response.put("fullname",user.getFullname());
		response.put("companyId", ""+user.getCompanyId());
		return response;
	}

}

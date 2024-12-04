package com.example.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_api.model.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Integer>{

	Companies findByUsername(String username);

}

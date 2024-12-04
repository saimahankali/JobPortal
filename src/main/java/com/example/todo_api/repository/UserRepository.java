package com.example.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo_api.model.Users;

import jakarta.persistence.Entity;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}

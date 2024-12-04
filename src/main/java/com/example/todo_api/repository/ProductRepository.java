package com.example.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

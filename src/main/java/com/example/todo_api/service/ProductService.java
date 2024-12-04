package com.example.todo_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_api.model.Product;
import com.example.todo_api.repository.ProductRepository;

@Service
public class ProductService {
//	List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Redmi", 7000),
//											new Product(102, "Samsung", 800)));
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(int prodId) {
		// TODO Auto-generated method stub
		return productRepository.getById(prodId);
	}
	
	public void addProduct(Product prod) {
		productRepository.save(prod);
	}

	public void updateProduct(Product prod) {
		// TODO Auto-generated method stub
		productRepository.save(prod);
	}

	public void deleteProduct(int prodId) {
		productRepository.deleteById(prodId);
	}

	
	
}

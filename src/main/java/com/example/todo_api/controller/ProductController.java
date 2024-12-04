package com.example.todo_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.model.Product;
import com.example.todo_api.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@RequestMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@RequestMapping("/products/{prodId}")
	public Product getProductById(@PathVariable int prodId) {
		return productService.getProductById(prodId);
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product prod) {
		productService.addProduct(prod);
		return "Sucessfully Added!";
	}
	
	@PutMapping("/products")
	public String updateProduct(@RequestBody Product prod) {
		productService.updateProduct(prod);
		
		return "Sucessfully Updated!";
	}
	
	@DeleteMapping("/products/{prodId}")
	public String deleteProduct(@PathVariable int prodId) {
		productService.deleteProduct(prodId);
		return "Product Deleted";
	}
}

package com.example.todo_api.model;
import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int prodId;
	private String prodName;
	private int prodPrice;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int prodId, String prodName, int prodPrice) {
//		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
}

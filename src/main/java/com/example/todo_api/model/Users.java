package com.example.todo_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column (nullable = false)
	private String fullname;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@Column(nullable = false)
	private String password;
	
	
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	
	
}

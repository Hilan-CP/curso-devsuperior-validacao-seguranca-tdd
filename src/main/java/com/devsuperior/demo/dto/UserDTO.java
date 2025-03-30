package com.devsuperior.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.demo.entities.Role;
import com.devsuperior.demo.entities.User;

public class UserDTO {

	private Long id;
	private String email;
	private String password;
	private List<Role> roles = new ArrayList<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public UserDTO(User entity) {
		id = entity.getId();
		email = entity.getEmail();
		password = entity.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}
}

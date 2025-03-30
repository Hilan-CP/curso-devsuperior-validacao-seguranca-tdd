package com.devsuperior.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
}

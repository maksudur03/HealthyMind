package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ConfirmationToken;


public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}


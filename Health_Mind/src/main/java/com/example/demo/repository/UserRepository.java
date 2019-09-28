package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {
	User findByEmailIdIgnoreCase(String emailId);
	
	User findByUserid(int userid);
	@Query("select u from User u where name = :name and password = :password")
	User findByNameandPassword(String name,String password);
	
}

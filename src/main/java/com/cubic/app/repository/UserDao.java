package com.cubic.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Role;
import com.cubic.app.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	List<User> findAll();
	User	 findByEmail(String email);
	List<User> findByName(String name);
	User findById(int id);
	List<User> findByRole(Role role);
}

package com.cubic.app.service;

import java.util.List;

import com.cubic.app.domain.Role;
import com.cubic.app.domain.User;

public interface UserService {
	List<User> findAll();
	User findByEmail(String email);
	List<User> findByName(String name);
	User findById(int id);
	List<User> findByRole(Role role);
	void save(User u);
	User getCurrentUserInfo();
	public boolean hasRole(String role);
}

package com.cubic.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.app.domain.Role;
import com.cubic.app.domain.User;
import com.cubic.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public List<User> getUserList() {
		return userService.findAll();
	}
	
	//not working :: TODO
	@RequestMapping("/list/r/{role_type}")
	public List<User> getUserListByRole(@PathVariable Role role_type) {
		return userService.findByRole(role_type);
	}
}

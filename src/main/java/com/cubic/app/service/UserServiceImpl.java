package com.cubic.app.service;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.app.domain.Role;
import com.cubic.app.domain.User;
import com.cubic.app.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> findAll() {
		logger.info("Getting the list of all users");
		return userDao.findAll();
	}

	@Override
	@Transactional
	public User findByEmail(String email) {
		logger.info("Getting the list of all users by email = " + email);
		return userDao.findByEmail(email);
	}

	@Override
	@Transactional
	public List<User> findByName(String name) {
		logger.info("Getting the list of all users by name = " + name);
		return userDao.findByName(name);
	}

	@Override
	@Transactional
	public User findById(int id) {
		logger.info("Getting the User by Id " + id);
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public List<User> findByRole(Role role) {
		logger.info("Getting the User list by Role..");
		return userDao.findByRole(role);
	}

	@Override
	@Transactional
	public void save(User u) {
		logger.info("Saving User.." + u);
		userDao.save(u);

	}

	public boolean hasRole(String role) {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		boolean hasRole = false;
		for (GrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals(role);
			if (hasRole) {
				break;
			}
		}
		return hasRole;
	}
	
	public User getCurrentUserInfo() {
		User user = (User)SecurityContextHolder.getContext().
				   getAuthentication().getPrincipal();
		return user;
	}

}

package com.cubic.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;
	
	
	@Autowired
	SecurityContextRepository securityContextRepository;
	
	@Autowired
	RememberMeServices rememberMeServices;
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String performLogin(
			@RequestParam("j_username") String email,
			@RequestParam("j_password") String password,
			HttpServletRequest request,
			HttpServletResponse response
			) {
		
		logger.info("Authenticating User::");
		logger.info("Username: "+email);
		logger.info("Password: "+password);
		
		/*BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String pwd = bcrypt.encode("password");*/
		String pwd = password;
		
		UsernamePasswordAuthenticationToken token 
			= new UsernamePasswordAuthenticationToken(email, pwd);
		
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			securityContextRepository.saveContext(SecurityContextHolder.getContext(), request,response);
			//rememberMeServices.loginSuccess(request, response, auth);
			return "{\"status\":true}";
		} catch(BadCredentialsException ex){
			return "{\"status\": false, \"error\": \"Bad Credentials\"}";
		}
		
	}
}

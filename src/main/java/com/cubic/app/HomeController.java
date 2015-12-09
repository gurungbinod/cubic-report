package com.cubic.app;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cubic.app.domain.User;
import com.cubic.app.service.InterviewService;
import com.cubic.app.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserService userService;
	
	@Autowired
	private InterviewService interviewService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		//logger.info("Principal::"+principal.getName());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome.. Login page displayed..!!");
		//return "redirect:static/index.html#dashboard";
		return "login";
	}
	
	@RequestMapping(value="/secure/dashboard", method=RequestMethod.GET)
	public String dashboard(Model model) {
		logger.info("Load Dashboard");
		System.out.println("Interview List:: "+interviewService.getInterviewList());
		
		model.addAttribute("interviewList", interviewService.getInterviewList());
		return "dashboard";
	}
	
}

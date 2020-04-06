package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;
import com.services.interfaces.CredentialsBusinessServiceInterface;

/**
 * 
 * @author Ali Cooper
 * Login Controller 
 */
@Controller
public class LoginController {
	private CredentialsBusinessServiceInterface credentialsService;
	private XLogger logger = XLoggerFactory.getXLogger(LoginController.class);

	@Autowired
	public void setLoginService(CredentialsBusinessServiceInterface businessService) {
		logger.entry();
		logger.info("injecting login service");
		this.credentialsService = businessService;
		logger.exit();
		
	}
	
	
	/**
	 * home page for login
	 * @return Login view with an empty user model
	 */
	@GetMapping("/")
	public ModelAndView login() {
		
		logger.entry();
		logger.exit();
		return new ModelAndView("login", "user", new User());
	}
	
	/**
	 * logs user in, will redirect to login 
	 * if there are validation errors
	 * @param user
	 * @param result
	 * @return ModelAndView
	 */
	@PostMapping("/login")
	public String doLogin(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap map, HttpServletRequest request) {
		logger.entry();
		map.addAttribute("user", user);
		logger.info("userId: " + user.getId());
		
		//validate only username and password
		if (result.hasErrors()) {		
			logger.warn("errors found: " + result.getErrorCount());
			return "login";
		}
	
		// check to see if credentials are valid
		if (!credentialsService.isValidCredentials(user)) {
			logger.warn("invalid credentials for user " + user.getUsername());
			map.addAttribute("message", "Wrong Username or Password");
			return "login";
		}
		
		User tmp = credentialsService.getUserFromUsername(user.getUsername());
		request.getSession().setAttribute("user", tmp);
		logger.info("succesful login for user id " + tmp.getId());

		logger.exit();
		return "redirect:/home";
	}
	
	
}

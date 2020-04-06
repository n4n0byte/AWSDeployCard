package com.controllers;

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

import com.models.RegistrationForm;
import com.models.User;
import com.services.interfaces.CredentialsBusinessServiceInterface;



/**
 * 
 * @author Ali Cooper
 * Controller for regisitration based pages
 */
@Controller
public class RegistrationController {
	

	private CredentialsBusinessServiceInterface credentialsService;
	private XLogger logger = XLoggerFactory.getXLogger(RegistrationController.class);

	/**
	 * injects Credentials service
	 * @param businessService
	 */
	@Autowired
	public void setLoginService(CredentialsBusinessServiceInterface businessService) {
		logger.entry();
		this.credentialsService = businessService;
		logger.exit();
	}
	
	
	/**
	 * 
	 * @param user
	 * @param result
	 * @param map
	 * @return
	 */
	@GetMapping("/register")
	public String registerPage(ModelMap map) {
		logger.entry();
		RegistrationForm registrationForm = new RegistrationForm();
		map.addAttribute("registrationForm", registrationForm);
		logger.exit();
		return "register";
	}	
	
	/**
	 * attempts to register a user
	 * @param form
	 * @param result
	 * @return
	 */
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registrationForm")RegistrationForm form, BindingResult result, ModelMap map) {
		
		map.addAttribute("user", new User(form));
		logger.entry();
		
		if (result.hasErrors()) {
			logger.warn("errors found: " + result.getErrorCount());
			return "register";
		}
		
		// make a user out of the form data
		User user = new User(form);
		
		
		// try to register user, will return false
		// if user is already registered
		if (!credentialsService.tryRegisterUser(user)) {
			logger.warn("user: " + user + " is already registered");
			map.addAttribute("message", "You are already registered, please login");
		} else {
			logger.info("user: " + user + " sucessfully registered");
			map.addAttribute("message", "You have been successfully registered");
		}
		
		logger.exit();
		
		return "login";

	}

	
}

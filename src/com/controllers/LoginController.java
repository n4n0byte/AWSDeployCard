package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Autowired
	public void setLoginService(CredentialsBusinessServiceInterface businessService) {
		System.out.println("WORKED");
		this.credentialsService = businessService;
	}
	
	@GetMapping("test")
	@ResponseBody
	public String testView() {
		return "works";
	}
	
	/**
	 * home page for login
	 * @return Login view with an empty user model
	 */
	@GetMapping("/")
	public ModelAndView login() {
				
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

		map.addAttribute("user", user);
		
		//validate only username and password
		if (result.hasErrors()) {			
			return "login";
		}
	
		// check to see if credentials are valid
		if (!credentialsService.isValidCredentials(user)) {
			map.addAttribute("message", "Wrong Username or Password");
			return "login";
		}
			
		request.getSession().setAttribute("user", credentialsService.getUserFromUsername(user.getUsername()));
		return "redirect:/home";
	}
	
	
}

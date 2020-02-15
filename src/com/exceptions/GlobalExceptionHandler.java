package com.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Ali Cooper
 * custom exception handling class 
 */
@ControllerAdvice(basePackages = "com.controllers")
public class GlobalExceptionHandler {	
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView dataAccessObjectError(final Exception e) {

		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("message", 
					e.getMessage() 
					+ "<br>" 
					+ "<br>" 
					+ e.getLocalizedMessage()
					+ "<br>" 
					+ "<br>" 
					+ e.getCause().getMessage()
				);
		e.printStackTrace();
		mv.addObject("errorCode", Integer.valueOf(500));

		return mv;
	}
	
	

}

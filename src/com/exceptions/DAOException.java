package com.exceptions;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import com.controllers.LoginController;

/**
 * 
 * @author Ali Cooper
 * Exception for data access object 
 * runtime errors
 * 
 */
public class DAOException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private XLogger logger = XLoggerFactory.getXLogger(DAOException.class);

	/**
	 * wrap exception
	 * @param error String
	 * @param err Throwable
	 */
	public DAOException(String error, Throwable err) {
		super(error,err);
		logger.entry();
		logger.exit();
	}
	
}

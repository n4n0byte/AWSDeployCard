package com.exceptions;

/**
 * 
 * @author Ali Cooper
 * Exception for data access object 
 * runtime errors
 * 
 */
public class DAOException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	
	public DAOException(String error, Throwable err) {
		super(error,err);
	}
	
}

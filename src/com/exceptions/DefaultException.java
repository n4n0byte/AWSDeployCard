package com.exceptions;

public class DefaultException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DefaultException(String error, Throwable err) {
		super(error,err);
	}
	
	
}

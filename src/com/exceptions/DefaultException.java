package com.exceptions;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

/**
 * General Exception Wrapper
 * @author Ali Cooper
 *
 */
public class DefaultException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private XLogger logger = XLoggerFactory.getXLogger(DefaultException.class);

	/**
	 * wrap exception
	 * @param error String
	 * @param err Throwable
	 */
	public DefaultException(String error, Throwable err) {
		super(error,err);
		logger.entry();
		logger.exit();

	}
	
	
}

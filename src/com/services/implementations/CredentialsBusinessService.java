package com.services.implementations;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.models.User;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.GenericDAOInterface;
/**
 * 
 * @author Ali Cooper
 * Handles everything that has to do with the credentials for
 * Login and Registration.,
 *
 */
public class CredentialsBusinessService implements CredentialsBusinessServiceInterface {

	private GenericDAOInterface<User> userDAO;
	private XLogger logger = XLoggerFactory.getXLogger(CredentialsBusinessService.class);

	@Autowired
	public void setUserDAO(GenericDAOInterface<User> userDAO) {
		logger.entry();
		this.userDAO = userDAO;
		logger.exit();
	}
	/**
	 * Checks to see if a user is already registered
	 */
	@Override
	public boolean isRegistered(User user) {
		logger.entry();
		User usr = userDAO.findByName(user.getUsername());
		System.out.println(usr + "PRINT: USER REGISTERED");
		logger.info("user: " + user);
		
		logger.exit();
		return true;
	}

	/**
	 * Checks to see if a username is already taken
	 */
	@Override
	public boolean tryRegisterUser(User user) {
		logger.entry();
		User usr = userDAO.findByName(user.getUsername());
		System.out.println(usr);
		if (usr == null) {
			logger.info("successfully registered user:  " + user);
			userDAO.add(user);
			return true;
		}
		
		logger.warn("user id: " + user.getId() + " is registered");
		if (user.getEmail().equals(usr.getEmail()) || user.getFirstName().equals(usr.getFirstName())) return false;
		logger.exit();
		return true;
	}
	
	/**
	 * checks to see if all credentials are valid
	 */
	@Override
	public boolean isValidCredentials(User user) {
		logger.entry();
		User usr = userDAO.findByName(user.getUsername());
		System.out.println(usr);
		System.out.println(user);
		
		if(usr == null) {
			logger.warn("user model is null");
			logger.exit();
			return false;
		}
		
		if (usr.getPassword().equals(user.getPassword()) && usr.getUsername().equals(user.getUsername())) {
			logger.info("user: " + user + " has valid credentials");
			return true;
		}
		
		logger.warn("user: " + user + " has invalid credentials");
		return false;
	}
	
	/**
	 * gets user from database with that users username
	 */
	@Override
	public User getUserFromUsername(String username) {
		logger.entry();
		logger.exit();
		return userDAO.findByName(username);
	}

}

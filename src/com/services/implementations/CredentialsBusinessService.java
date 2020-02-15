package com.services.implementations;

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

	@Autowired
	public void setUserDAO(GenericDAOInterface<User> userDAO) {
		this.userDAO = userDAO;
	}
	/**
	 * Checks to see if a user is already registered
	 */
	@Override
	public boolean isRegistered(User user) {
		
		User usr = userDAO.findByName(user.getUsername());
		System.out.println(usr + "PRINT: USER REGISTERED");
		
		return true;
	}

	/**
	 * Checks to see if a username is already taken
	 */
	@Override
	public boolean tryRegisterUser(User user) {
		
		User usr = userDAO.findByName(user.getUsername());
		System.out.println(usr);
		if(userDAO.findByName(user.getUsername()) == null || userDAO.findByName(user.getEmail()) == null) {
			userDAO.add(user);
			return true;
		}

		
		return false;
	}
	
	/**
	 * checks to see if all credentials are valid
	 */
	@Override
	public boolean isValidCredentials(User user) {
		User usr = userDAO.findByName(user.getUsername());
		System.out.println(usr);
		System.out.println(user);
		if(usr == null) return false;
		
		if (usr.getPassword().equals(user.getPassword()) && usr.getUsername().equals(user.getUsername())) {
			return true;
		}
		
				
		return false;
	}
	
	/**
	 * gets user from database with that users username
	 */
	@Override
	public User getUserFromUsername(String username) {
		return userDAO.findByName(username);
	}

}

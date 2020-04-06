package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.implementations.CardDAO;
import com.services.implementations.CredentialsBusinessService;
import com.services.implementations.DeckBusinessService;
import com.services.implementations.DeckDAO;
import com.services.implementations.UserDAO;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.GenericDAOInterface;

/**
 * 
 * @author Ali Cooper
 * IoC Configuration class for services
 */
@Configuration
public class Services {
	

	////////////////////////////////////////
	//// Data Services
	///////////////////////////////////////
	
	/**
	 * user DAO injection config
	 * @return UserDAO
	 */
	@Bean
	@Primary
	public  GenericDAOInterface<User> userDAOService() { 
		GenericDAOInterface<User> userDAO = new UserDAO();
		
		return userDAO;
	}
	
	/**
	 * card DAO injection config
	 * @return CardDAO
	 */
	@Bean
	@Primary
	public  GenericDAOInterface<Card> cardDAOService() { 
		
		GenericDAOInterface<Card> cardDAO = new CardDAO();
		return cardDAO;
	}
	
	
	
	/** 
	 * Deck DAO injection config
	 * @return DeckDAO
	 */
	@Bean
	@Primary
	public GenericDAOInterface<Deck> deckDAOService() { 
		GenericDAOInterface<Deck> deckDAO = new DeckDAO();
		
		return deckDAO;
	}
	
	
	////////////////////////////////////////
	//// Business Services
	///////////////////////////////////////
	
	/**
	 * Credentials Business Service injection config
	 * @return CredentialsBusinessService
	 */
	@Bean
	@Primary
	public CredentialsBusinessServiceInterface credentialsBusinessServiceInterface() {
		return new CredentialsBusinessService();
	}
	
	/**
	 * Deck Business Service injection config
	 * @return DeckBusinessService
	 */
	@Bean
	@Primary
	public DeckBusinessServiceInterface businessServiceInterface() {
		return new DeckBusinessService();
	}

}

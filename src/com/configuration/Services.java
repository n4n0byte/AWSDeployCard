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
	

	
	@Bean
	@Primary
	public  GenericDAOInterface<User> userDAOService() { 
		GenericDAOInterface<User> userDAO = new UserDAO();
		
		return userDAO;
	}
	
		
	@Bean
	@Primary
	public  GenericDAOInterface<Card> cardDAOService() { 
		GenericDAOInterface<Card> cardDAO = new CardDAO();
		
		return cardDAO;
	}
	
	
	
	
	@Bean
	@Primary
	public GenericDAOInterface<Deck> deckDAOService() { 
		GenericDAOInterface<Deck> deckDAO = new DeckDAO();
		
		return deckDAO;
	}
	
	@Bean
	@Primary
	public CredentialsBusinessServiceInterface credentialsBusinessServiceInterface() {
		return new CredentialsBusinessService();
	}
	
	@Bean
	@Primary
	public DeckBusinessServiceInterface businessServiceInterface() {
		return new DeckBusinessService();
	}

}

package com.services.interfaces;

import java.util.List;

import com.models.Card;
import com.models.Deck;
import com.models.User;

/**
 * 
 * @author Ali Cooper, Anthony Natvidad
 *
 */
public interface DeckBusinessServiceInterface{
	
	/**
	 * returns all decks given the username
	 * that created them
	 * @param username
	 * @return
	 */
	public List<Deck> findAllDecksByUsername(String username);
	
	/**
	 * 
	 * @param id
	 * @return List<Deck> 
	 */
	public List<Deck> findAllDecksByUserId(int id);
	
	/**
	 * Update Deck
	 * @param deck Deck
	 */
	public void updateDeck(Deck deck);
	
	/**
	 * Deletes a Deck
	 * @param id
	 * @return boolean
	 */
	public boolean deleteDeckById(int id);
	
	/**
	 * List<Deck> finds a deck using a user's id
	 * @param id int
	 * @return UserID
	 */
	public List<Deck> getDeckByUserId(int id);
	
	/**
	 * gets all cards using User Model
	 * @param id
	 * @return List<Card>
	 */
	public List<Card> getAllCardsFromUser(User id);
	
	/**
	 * adds a deck
	 * @param deck Deck
	 */
	public void addDeck(Deck deck);
	
	/**
	 * finds a deck by its id
	 * @param deckId int
	 * @return Deck
	 */
	public Deck findDeckByDeckId(int deckId);
	
	/**
	 * deletes deck by title
	 * @param title String
	 * @return boolean
	 */
	public boolean deleteDeckByTitle(String title);
	
	/**
	 * adds a card to a deck
	 * @param card Card
	 * @param deckId int
	 */
	public void addCardToDeckWithDeckId(Card card, int deckId);
	
	/**
	 * adds a card to deck with title
	 * @param card
	 * @param deckTitle
	 */
	public void addCardToDeckWithDeckTitle(Card card, String deckTitle);

}

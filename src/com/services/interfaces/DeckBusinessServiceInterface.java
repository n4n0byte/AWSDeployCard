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
	 * @return
	 */
	public List<Deck> findAllDecksByUserId(int id);
	
	public void updateDeck(Deck deck);
	public boolean deleteDeckById(int id);
	public List<Deck> getDeckByUserId(int id);
	public List<Card> getAllCardsFromUser(User id);
	public void addDeck(Deck deck);
	public Deck findDeckByDeckId(int deckId);
	public boolean deleteDeckByTitle(String title);
	public void addCardToDeckWithDeckId(Card card, int deckId);
	public void addCardToDeckWithDeckTitle(Card card, String deckTitle);

}

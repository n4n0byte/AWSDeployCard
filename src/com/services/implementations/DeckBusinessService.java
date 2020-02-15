package com.services.implementations;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.GenericDAOInterface;

/**
 * 
 * @author Ali Cooper & Anthony Natividad
 * Deck Business Service implements Deck and Card DOAs
 */
public class DeckBusinessService implements DeckBusinessServiceInterface {
	
	GenericDAOInterface<Deck> iDeckDataService;
	GenericDAOInterface<Card> cardSvc;
	
	/**
	 * sets card data service
	 * @param cardSvc
	 */
	@Autowired
	public void setCardSvc(GenericDAOInterface<Card> cardSvc) {
		this.cardSvc = cardSvc;
	}


	@Autowired
	public void setiDeckDataService(GenericDAOInterface<Deck> iDeckDataService) {
		this.iDeckDataService = iDeckDataService;
	};

	/**
	 * calls the DeckDOA to find decks made by a single user		
	 */

	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		return iDeckDataService.findAllById(id);
	}
	
	
	/**
	 * Calls DAO for deck to update a deck
	 */
	@Override
	public void updateDeck(Deck deck) {
		iDeckDataService.updateById(deck, deck.getUserId());
	}
	
	/**
	 * deletes deck by deck id
	 */
	@Override
	public boolean deleteDeckById(int id) {
		return iDeckDataService.deleteById(id);
	}

	/**
	 * adds cards to deck using decks id
	 * calls Card DOA
	 */
	@Override
	public void addCardToDeckWithDeckId(Card card, int deckId) {
		card.setDeckId(deckId);
		cardSvc.add(card);	
	}



	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		return null;
	}
	
	@Override
	public boolean deleteDeckByTitle(String title) {
		return iDeckDataService.deleteByName(title);
	}


	@Override
	public List<Card> getAllCardsFromUser(User id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addDeck(Deck deck) {
		iDeckDataService.add(deck);
	}



	@Override
	public void addCardToDeckWithDeckTitle(Card card, String deckTitle) {
		card.setDeckId(iDeckDataService.findByName(deckTitle).getDeckId());
		cardSvc.add(card);
	}


	@Override
	public Deck findDeckByDeckId(int deckId) {
		return iDeckDataService.getById(deckId);
	}


	@Override
	public List<Deck> getDeckByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}

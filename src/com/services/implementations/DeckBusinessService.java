package com.services.implementations;
import java.util.List;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
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
	private XLogger logger = XLoggerFactory.getXLogger(DeckBusinessService.class);

	
	/**
	 * sets card data service
	 * @param cardSvc
	 */
	@Autowired
	public void setCardSvc(GenericDAOInterface<Card> cardSvc) {
		logger.entry();
		this.cardSvc = cardSvc;
		logger.info("injecting card svc");
		logger.exit();
	}


	@Autowired
	public void setiDeckDataService(GenericDAOInterface<Deck> iDeckDataService) {
		logger.entry();
		this.iDeckDataService = iDeckDataService;
		logger.info("injecting deck svc");
		logger.exit();
	};

	/**
	 * calls the DeckDOA to find decks made by a single user		
	 */

	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		logger.entry();
		logger.info("deck id: " + id);
		logger.exit();

		return iDeckDataService.findAllById(id);
	}
	
	
	/**
	 * Calls DAO for deck to update a deck
	 */
	@Override
	public void updateDeck(Deck deck) {
		logger.entry();
		iDeckDataService.updateById(deck, deck.getUserId());
		logger.info("current deck: " + deck.toString());
		logger.exit();
	}
	
	/**
	 * deletes deck by deck id
	 */
	@Override
	public boolean deleteDeckById(int id) {
		logger.entry();
		logger.info("deckId: " + id);
		logger.exit();
		return iDeckDataService.deleteById(id);
	}

	/**
	 * adds cards to deck using decks id
	 * calls Card DOA
	 */
	@Override
	public void addCardToDeckWithDeckId(Card card, int deckId) {
		logger.entry();
		card.setDeckId(deckId);
		logger.info("deck id: " + deckId);
		cardSvc.add(card);	
		logger.exit();
	}



	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		logger.entry();
		logger.exit();
		return null;
	}
	
	@Override
	public boolean deleteDeckByTitle(String title) {
		logger.entry();
		logger.info("deck title: title");
		logger.exit();
		return iDeckDataService.deleteByName(title);
	}


	@Override
	public List<Card> getAllCardsFromUser(User user) {
		logger.entry();	
		logger.info("user id: " + user.getId());
		logger.exit();
		return null;
	}



	@Override
	public void addDeck(Deck deck) {
		logger.entry();
		iDeckDataService.add(deck);
		logger.exit();
	}



	@Override
	public void addCardToDeckWithDeckTitle(Card card, String deckTitle) {
		logger.entry();
		card.setDeckId(iDeckDataService.findByName(deckTitle).getDeckId());
		cardSvc.add(card);
		logger.exit();
	}


	@Override
	public Deck findDeckByDeckId(int deckId) {
		logger.entry();
		logger.exit();
		return iDeckDataService.getById(deckId);
	}


	@Override
	public List<Deck> getDeckByUserId(int id) {
		logger.entry();
		logger.exit();
		return null;
	}



}

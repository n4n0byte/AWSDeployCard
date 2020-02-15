package com.models;

/**
 * 
 * @author Ali Cooper
 * 
 */
public class CardWithDeckTitle {
	
	Card card;
	
	String deckTitle;
	
	
	public CardWithDeckTitle(Card card, String deckTitle) {
		super();
		this.card = card;
		this.deckTitle = deckTitle;
	}

	public CardWithDeckTitle() {}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getDeckTitle() {
		return deckTitle;
	}

	public void setDeckTitle(String deckTitle) {
		this.deckTitle = deckTitle;
	}

	@Override
	public String toString() {
		return "CardWithDeckTitle [card=" + card + ", deckTitle=" + deckTitle + "]";
	}
	
	
	
}

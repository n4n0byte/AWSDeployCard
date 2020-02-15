package com.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author Ali Cooper
 *
 */
public class Deck {
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 100, message = "Must be between 1 and 100 characters")    
	private String title;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 100, message = "Must be between 1 and 100 characters")    
	private String description;
	
	
	List<Card> cards;
	
	int deckId;

	int userId;
	
	
	
	@Override
	public String toString() {
		return "Deck [title=" + title + ", description=" + description + ", cards=" + cards + ", deckId=" + deckId
				+ ", userId=" + userId + "]";
	}

	public Deck() {
		cards = new ArrayList<>();
	}
	
	public int getDeckId() {
		return deckId;
	}

	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void addCard(Card card) {
		if(cards == null) cards = new ArrayList<>();
		cards.add(card);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	
	
	
	
}

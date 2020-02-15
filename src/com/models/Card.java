package com.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * 
 * @author Ali Cooper
 * Card model class
 */
public class Card {
	
	
	int id;
	
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 20, message = "Must be between 1 and 10 characters")    
	@NotNull
	private String title;
	
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 40, message = "Must be between 1 and 40 characters")    
	@NotNull
	private String description;
	
	@Min(0)
	private int health;
	
	@Min(0)
	private int damage;

	private int deckId;	
	

	public Card(int id, String title, String description, int health, int damage) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.health = health;
		this.damage = damage;
	}

	public Card() {}

	
	public int getDeckId() {
		return deckId;
	}

	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", description=" + description + ", health=" + health
				+ ", damage=" + damage + ", deckId=" + deckId + "]";
	}
	
	
	
	
	
}

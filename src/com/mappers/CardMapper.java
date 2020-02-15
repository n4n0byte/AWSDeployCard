package com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.models.Card;

/**
 * 
 * @author Ali Cooper
 * Maps objects to their respective db rows
 */
public class CardMapper implements RowMapper<Card> {
	
	
	@Override
	public Card mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		Card card = new Card(
				arg0.getInt("id"), 
				arg0.getString("title"), 
				arg0.getString("description"), 
				arg0.getInt("health"), 
				arg0.getInt("damage"));
		
		card.setDeckId(arg0.getInt("deckId"));
		
		System.out.println(card);
		return card;
	}
	
	
	
}

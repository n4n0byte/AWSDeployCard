package com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.models.Deck;

/**
 * 
 * @author Ali Cooper
 * Maps objects to their respective db rows
 */
public class DeckMapper implements RowMapper<Deck>{

	@Override
	public Deck mapRow(ResultSet arg0, int arg1) throws SQLException {
		Deck deck = new Deck();
		deck.setTitle(arg0.getString(4));
		deck.setDescription(arg0.getString(3));
		deck.setUserId(arg0.getInt(2));
		deck.setDeckId(arg0.getInt(1));
		return deck;
	}
	
}

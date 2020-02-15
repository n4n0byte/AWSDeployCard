package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exceptions.DAOException;
import com.mappers.CardMapper;
import com.models.Card;
import com.services.interfaces.GenericDAOInterface;
/**
 * 
 * @author Anthony Natividad and Ali Cooper
 * CardDAO has all CRUD operations for our Card model
 *
 */
public class CardDAO implements GenericDAOInterface<Card>{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * sets data source and instantiates Jdbc template
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("INJECTING DATA SOURCE FROM CARD");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	/**
	 * returns a list of all cards in database
	 */
	@Override
	public List<Card> findAll() {
		String sql = "SELECT * FROM carddb.cards";

		List<Card> results = null;

		try {
			results  = jdbcTemplateObject.query(sql, new CardMapper());
			
		} catch(DataAccessException e) {
			throw new DAOException(e.getMessage(), e);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		for( Card c : results) {
			System.out.println(c);
		}

		return results;
	}

	/**
	 * returns  a card with ID as the condition
	 */
	@Override
	public Card getById(int id) {

		String sql = "SELECT * FROM carddb.cards where id = ?";

		Card results = null;

		try {
			results  = jdbcTemplateObject.queryForObject(sql, new Object[] {id}, new CardMapper());
		} catch(DataAccessException e) {
			throw new DAOException(e.getMessage()+"\n"+e.getStackTrace(), e);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return results;
	}
	
	/**
	 * Creates a card in the database
	 */
	@Override
	public void add(Card model) {

		try {
			jdbcTemplateObject.update("INSERT INTO carddb.cards (deckId, title, description, health, damage) VALUES (?, ?, ?, ?, ?)",
				model.getDeckId(),
				model.getTitle(),
				model.getDescription(),
				model.getHealth(),
				model.getDamage()
			);
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage()+"\n"+e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
	}

	/**
	 * 
	 */
	public List<Card> findAllById(int id) {
		String sql = "SELECT * FROM carddb.cards where deckId = " + id;

		List<Card> results = null;

		try {
			results = jdbcTemplateObject.query(sql, new CardMapper());
		}catch (DataAccessException e) {
			throw new DAOException(e.getMessage()+"\n"+e.getStackTrace(), e);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return results;
	}

	/**
	 * Not used for Cars
	 */
	@Override
	public boolean deleteById(int id) {
		// TODO stub for next milestone's functionality
		return false;
	}

	/**
	 * Not used for Card
	 */
	@Override
	public boolean updateById(Card input, int id) {
		// TODO stub for next milestone functionality
		return false;
	}

	/**
	 * Not used for Card
	 */
	@Override
	public Card findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Not used for card
	 */
	@Override
	public boolean updateByName(Card input, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not used for Card
	 */
	@Override
	public boolean deleteByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not used for Card
	 */
	@Override
	public void addCardWithName(Card input, String name) {
		// TODO Auto-generated method stub
		
	}


}

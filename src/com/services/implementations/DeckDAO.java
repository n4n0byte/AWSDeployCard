package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exceptions.DAOException;
import com.mappers.DeckMapper;
import com.models.Card;
import com.models.Deck;
import com.services.interfaces.GenericDAOInterface;

/**
 * 
 * @author Ali Cooper Data Access Object used for crud operations on Deck
 *         objects
 *
 */
public class DeckDAO implements GenericDAOInterface<Deck> {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private GenericDAOInterface<Card> cardDAO;

	/**
	 * sets data source instantiates JDBC templae object
	 * 
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("INJECTING DATA SOURCE");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	/**
	 * sets Card Data Access Object
	 * 
	 * @param cardDAO
	 */
	@Autowired
	public void setCardDAO(GenericDAOInterface<Card> cardDAO) {
		System.out.println("INJECTING CARD DAO~!");

		this.cardDAO = cardDAO;
	}

	/**
	 * Returns a list of deck by the users id
	 */
	@Override
	public Deck getById(int id) {
		List<Deck> decks = null;

		try {
			decks = jdbcTemplateObject.query("select * from carddb.decks where id = BINARY ? limit 1",
					new Object[] { id }, new DeckMapper());
			if (decks.size() > 0) {
				decks.get(0).setCards(cardDAO.findAllById(decks.get(0).getDeckId()));
				return decks.get(0);
			}
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * Returns a deck by its name
	 */
	@Override
	public Deck findByName(String title) {
		List<Deck> decks = null;

		try {
			decks = jdbcTemplateObject.query("select * from carddb.decks where title = BINARY ? limit 1",
					new Object[] { title }, new DeckMapper());
			if (decks.size() > 0) {
				decks.get(0).setCards(cardDAO.findAllById(decks.get(0).getDeckId()));
				return decks.get(0);
			}
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * Deletes a deck by its id
	 */
	@Override
	public boolean deleteById(int id) {

		try {
			int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where id = ?", id);
			if (rowsDeleted > 0)
				return true;
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return false;
	}

	/**
	 * deletes deck by its name
	 */
	@Override
	public boolean deleteByName(String title) {

		try {
			int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where title = BINARY ?", title);
			if (rowsDeleted > 0)
				return true;
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return false;

	}

	/**
	 * updates deck by its id passes in a deck object
	 */
	@Override
	public boolean updateById(Deck input, int id) {

		try {
			int rows = jdbcTemplateObject.update("UPDATE carddb.decks set description = ?, title = ? where userId = ?",
					input.getDescription(), input.getTitle(), id);

			if (rows == 1)
				return true;
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return false;
	}

	/**
	 * Creae api for the deck object
	 */
	@Override
	public void add(Deck model) {

		try {
			jdbcTemplateObject.update("INSERT INTO carddb.decks (userId, description, title) VALUES (?, ?, ?)",
					model.getUserId(), model.getDescription(), model.getTitle());

		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

	}

	/**
	 * Retruns a list of decks by the users id
	 */
	public List<Deck> findAllById(int id) {

		String sql = "SELECT id, userId, description, title FROM carddb.decks where userId = " + id;
		List<Deck> results = null;

		try {
			results = jdbcTemplateObject.query(sql, new DeckMapper());
			for (int i = 0; i < results.size(); i++) {
				results.get(i).setCards(cardDAO.findAllById(results.get(i).getDeckId()));
			}
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return results;
	}

	/**
	 * Returns a list of all decks in the database
	 */
	@Override
	public List<Deck> findAll() {

		String sql = "SELECT * FROM carddb.decks";

		List<Deck> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new DeckMapper());

			for (Deck d : results) {
				d.setCards(cardDAO.findAllById(d.getDeckId()));
			}

		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return results;

	}

	/**
	 * Not used for Deck object
	 */
	@Override
	public boolean updateByName(Deck input, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Passes in a card model adds a card to an existing deck deck is updated
	 */
	@Override
	public void addCardWithName(Card model, String name) {
	}

}

package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exceptions.DAOException;
import com.exceptions.NotImplementedException;
import com.mappers.UserMapper;
import com.models.Card;
import com.models.User;
import com.services.interfaces.GenericDAOInterface;
/**
 * 
 * @author Anthony Natividad and Ali Cooper
 * CardDAO has all CRUD operations for our Card model
 * however only few are used and are used for authentication purposes
 */
public class UserDAO implements GenericDAOInterface<User> {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private XLogger logger = XLoggerFactory.getXLogger(DeckDAO.class);

	/**
	 * sets data source
	 * JDBC template object is instantiated
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		logger.entry();
		System.out.println("INJECTING CARD DAO~!");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	/**
	 * Returns a list of all users in data base
	 */
	@Override
	public List<User> findAll() {
		logger.entry();

		String sql = "SELECT * from users";

		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new UserMapper());
			logger.info("user count: " + results.size());
		} catch (DataAccessException e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		}
		logger.exit();
		return results;
	}

	/**
	 * Returns a user by the id passed
	 */
	@Override
	public User getById(int id) {
		logger.entry();

		String sql = "SELECT * from users where id = BINARY ?";
		
		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new Object[] { id }, new UserMapper());
		} catch (DataAccessException e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		}

		if (results.size() > 0)
			return results.get(0);
		logger.exit();

		return null;
	}

	/**
	 * Not used for user
	 */
	@Override
	public boolean deleteById(int id) {
		logger.entry();
		logger.throwing(new NotImplementedException());
		logger.exit();
		
		throw new NotImplementedException();
	}

	/**
	 * not used for user
	 */
	@Override
	public boolean updateById(User input, int id) {
		logger.entry();
		logger.throwing(new NotImplementedException());
		logger.exit();
		
		throw new NotImplementedException();
	}

	/**
	 * creaes a new user in the database
	 */
	@Override
	public void add(User model) {
		logger.entry();

		try {
			jdbcTemplateObject.update(
					"INSERT INTO carddb.users (email, firstName, lastName, password, username) "
							+ "VALUES (?, ?, ?, ?, ?)",
					model.getEmail(), model.getFirstName(), model.getLastName(), model.getPassword(),
					model.getUsername());
		} catch (DataAccessException e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		}
		logger.exit();
	}

	/**
	 * returns a user by the name of that user
	 */
	@Override
	public User findByName(String username) {
		logger.entry();

		String sql = "SELECT * from carddb.users where username = BINARY ?";
		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new Object[] { username }, new UserMapper());
		} catch (DataAccessException e) {
			logger.catching(e);
			logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
	} catch (Exception e) {
		logger.catching(e);
		logger.throwing(new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e));
		throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		}
		if (results.size() > 0)
			return results.get(0);
		
		logger.exit();
		return null;
	}


	/**
	 * not used in user
	 */
	@Override
	public boolean updateByName(User input, String name) {
		logger.entry();
		logger.exit();
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * not used in user
	 */
	@Override
	public boolean deleteByName(String name) {
		logger.entry();
		logger.exit();
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * not used in user
	 */
	@Override
	public List<User> findAllById(int id) {
		logger.entry();
		logger.exit();
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * not used in user
	 */
	@Override
	public void addCardWithName(Card input, String name) {
		logger.entry();
		logger.exit();
		// TODO Auto-generated method stub
		
	}

}

package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

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

	/**
	 * sets data source
	 * JDBC template object is instantiated
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	/**
	 * Returns a list of all users in data base
	 */
	@Override
	public List<User> findAll() {
		String sql = "SELECT * from users";

		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new UserMapper());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return results;
	}

	/**
	 * Returns a user by the id passed
	 */
	@Override
	public User getById(int id) {
		
		String sql = "SELECT * from users where id = BINARY ?";
		
		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new Object[] { id }, new UserMapper());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		if (results.size() > 0)
			return results.get(0);

		return null;
	}

	/**
	 * Not used for user
	 */
	@Override
	public boolean deleteById(int id) {
		throw new NotImplementedException();
	}

	/**
	 * not used for user
	 */
	@Override
	public boolean updateById(User input, int id) {
		throw new NotImplementedException();
	}

	/**
	 * creaes a new user in the database
	 */
	@Override
	public void add(User model) {

		try {
			jdbcTemplateObject.update(
					"INSERT INTO carddb.users (email, firstName, lastName, password, username) "
							+ "VALUES (?, ?, ?, ?, ?)",
					model.getEmail(), model.getFirstName(), model.getLastName(), model.getPassword(),
					model.getUsername());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

	}

	/**
	 * returns a user by the name of that user
	 */
	@Override
	public User findByName(String username) {
		String sql = "SELECT * from carddb.users where username = BINARY ?";
		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new Object[] { username }, new UserMapper());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		if (results.size() > 0)
			return results.get(0);
		return null;
	}


	/**
	 * not used in user
	 */
	@Override
	public boolean updateByName(User input, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * not used in user
	 */
	@Override
	public boolean deleteByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * not used in user
	 */
	@Override
	public List<User> findAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * not used in user
	 */
	@Override
	public void addCardWithName(Card input, String name) {
		// TODO Auto-generated method stub
		
	}

}

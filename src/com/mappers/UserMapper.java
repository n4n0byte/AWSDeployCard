package com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.models.User;

/**
 * 
 * @author Ali Cooper
 * Maps objects to their respective db rows
 */
public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		User user = new User();
		
		user.setId(arg0.getInt("id"));
		user.setEmail(arg0.getString("email"));
		user.setUsername(arg0.getString("username"));
		user.setFirstName(arg0.getString("firstName"));
		user.setLastName(arg0.getString("lastName"));
		user.setPassword(arg0.getString("password"));
		
		return user;
	}
	
	
	
}

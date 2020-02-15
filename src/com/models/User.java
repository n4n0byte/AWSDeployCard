
package com.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2596918449003832584L;

	private int id;

	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 30, message = "First Name Must be between 3 and 30 characters")    
	@NotNull
	private String username;
	
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 30, message = "First Name Must be between 3 and 30 characters")    
	@NotNull
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	
	public User() {
		this(-1,"","","","","");
	}
	
	public User(User user) {
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
	
	public User(RegistrationForm registrationForm) {
		this.email = registrationForm.getEmail();
		this.firstName = registrationForm.getFirstName();
		this.lastName = registrationForm.getLastName();
		this.password = registrationForm.getPassword();
		this.username = registrationForm.getUsername();
		this.password = registrationForm.getPassword();
	}
	
	public User(int id, String username, String password, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
}

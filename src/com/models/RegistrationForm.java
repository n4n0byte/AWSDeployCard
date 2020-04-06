package com.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {


	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 30, message = "First Name Must be between 3 and 30 characters")    
	@NotNull
	private String firstName;
	
	
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 30, message = "Last Name Must be between 3 and 30 characters")
	@NotNull
	private String lastName;
	
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 30, message = "Last Name Must be between 3 and 30 characters")
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	@Size(min = 3, max = 30, message = "Username Must be between 3 and 30 characters")
	private String username;
	
	@NotBlank
	@NotNull
	@Size(min = 3, max = 30, message = "Username Must be between 3 and 30 characters")
	private String password;
	

	public RegistrationForm() {
	}


	public RegistrationForm(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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
	
	
	
	
}

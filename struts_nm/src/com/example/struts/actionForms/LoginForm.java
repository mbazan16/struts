package com.example.struts.actionForms;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public LoginForm() {
		super();
	}

	public LoginForm(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

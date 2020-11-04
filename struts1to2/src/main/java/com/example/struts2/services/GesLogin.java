package com.example.struts2.services;

import com.example.struts2.commons.exceptions.ServicesException;

public interface GesLogin {
	
	public Long login(String  username,String password) throws ServicesException;

}
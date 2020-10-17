package com.example.struts.services;

import com.example.struts.commons.exceptions.ServicesException;

public interface GesLogin {
	
	public Long login(String  username,String password) throws ServicesException;

}
package com.example.strutvalidator.services;

import com.example.strutvalidator.commons.exceptions.ServicesException;

public interface GesLogin {
	
	public Long login(String  username,String password) throws ServicesException;

}
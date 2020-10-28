package com.example.strutstiles.services;

import com.example.strutstiles.commons.exceptions.ServicesException;

public interface GesLogin {
	
	public Long login(String  username,String password) throws ServicesException;

}
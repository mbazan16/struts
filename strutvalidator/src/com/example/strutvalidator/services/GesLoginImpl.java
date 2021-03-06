package com.example.strutvalidator.services;

import static com.example.strutvalidator.commons.Constantes.*;

import com.example.strutvalidator.commons.exceptions.ServicesException;

public class GesLoginImpl implements GesLogin {

	@Override
	public Long login(String username, String password) throws ServicesException {
		if (username == null || !"a".equalsIgnoreCase(username))
			throw new ServicesException(USERNAME_INCORRECTO);
		if (password == null || !"a".equalsIgnoreCase(password))
			throw new ServicesException(PASSWORD_INCORRECTA);
		
		Long id = getIdUsuario(username, password);
		return id;
	}

	private Long getIdUsuario(String username, String password) {
		
		return 1L;
	}

}

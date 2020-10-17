package com.example.struts.services;

import static com.example.struts.commons.Constantes.CODIGO_USUARIO_INCORRECTO;
import static com.example.struts.commons.Constantes.PASSWORD_INCORRECTA;

import com.example.struts.commons.exceptions.ServicesException;

public class GesLoginImpl implements GesLogin {

	@Override
	public Long login(String username, String password) throws ServicesException {
		if (username == null || !"a".equalsIgnoreCase(username))
			throw new ServicesException(CODIGO_USUARIO_INCORRECTO);
		if (password == null || !"a".equalsIgnoreCase(password))
			throw new ServicesException(PASSWORD_INCORRECTA);
		
		Long id = getIdUsuario(username, password);
		return id;
	}

	private Long getIdUsuario(String username, String password) {
		
		return 1L;
	}

}

package com.example.struts.commons.exceptions;

public class ServicesException extends Exception {
	
	private int codigo;
	

	public ServicesException(int codigo) {
		super();
		this.codigo = codigo;
	}


	public int getCodigo() {
		return codigo;
	}
	

}

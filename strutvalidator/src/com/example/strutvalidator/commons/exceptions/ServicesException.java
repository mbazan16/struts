package com.example.strutvalidator.commons.exceptions;

public class ServicesException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String claveError;

	public ServicesException(String claveError) {
		super();
		this.claveError = claveError;
	}

	public String getClaveError() {
		return claveError;
	}	
	

}

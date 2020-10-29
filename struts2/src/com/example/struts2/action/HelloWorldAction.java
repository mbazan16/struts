package com.example.struts2.action;

import com.example.struts2.model.MensajeUsuario;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private MensajeUsuario mensajeUsuario;

	@Override
	public String execute() throws Exception {
		mensajeUsuario = new MensajeUsuario();
		return SUCCESS;
	}

	public MensajeUsuario getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	

}

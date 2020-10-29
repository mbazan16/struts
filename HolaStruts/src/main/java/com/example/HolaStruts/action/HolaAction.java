package com.example.HolaStruts.action;

import com.opensymphony.xwork2.ActionSupport;

public class HolaAction extends ActionSupport {
private static final long serialVersionUID = 1L;	
	
	private String nombre;
	private String mensaje;	
	
	@Override
    public String execute() throws Exception {
        mensaje = "Hola bienvenido a struts 2:";
        return ActionSupport.SUCCESS;
    }	
	
	@Override
	public void validate() {
        if (null == nombre || nombre.length() == 0)
            addActionError(getText("error.nombre.requerido"));
        
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}

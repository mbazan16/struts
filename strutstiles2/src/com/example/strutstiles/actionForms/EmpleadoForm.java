package com.example.strutstiles.actionForms;

import org.apache.struts.validator.ValidatorActionForm;

import com.example.strutstiles.data.Empleado;

public class EmpleadoForm extends ValidatorActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String accion;
	
	private Empleado empleado;
	
	private String newPassword;
	

	public EmpleadoForm() {
		super();
		empleado = new Empleado();
	}
	
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}	
	
	

}

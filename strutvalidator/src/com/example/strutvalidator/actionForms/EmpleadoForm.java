package com.example.strutvalidator.actionForms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.example.strutvalidator.data.Empleado;

public class EmpleadoForm extends ValidatorForm{
	
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

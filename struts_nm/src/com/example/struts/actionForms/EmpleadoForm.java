package com.example.struts.actionForms;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.example.struts.actions.EmpleadoAction;
import com.example.struts.data.Departamento;
import com.example.struts.data.Empleado;

public class EmpleadoForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(EmpleadoForm.class);
	
	private String accion;
	
	private Empleado empleado;
	
	private String newPassword;
	
	private List<Departamento> departamentos;
	

	public EmpleadoForm() {
		super();
		empleado = new Empleado();
		departamentos = new ArrayList<Departamento>();
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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	 public ActionErrors validate(ActionMapping mapping,
             HttpServletRequest request) {
		 log.info("EmpleadoForm-Validate");
		 ActionErrors errores = new ActionErrors();
		 if(empleado.getUsername()==null || "".equalsIgnoreCase(empleado.getUsername().trim()))
			 errores.add("username", new ActionMessage("error.username"));
		 if(empleado.getNombre()==null || "".equalsIgnoreCase(empleado.getNombre().trim()))
			 errores.add("nombre", new ActionMessage("error.nombre"));
		 if(empleado.getEdad()<18)
			 errores.add("edad", new ActionMessage("error.edad.minima"));
		/*
		 * if(empleado.getDepartamento()==null ||
		 * empleado.getDepartamento().getId()==null ||
		 * empleado.getDepartamento().getId()==0l) errores.add("departamento", new
		 * ActionMessage("error.departamento"));
		 */  
		 
		 log.info("Enviamos errores");
		 return errores;

	 }
	
	
	

}

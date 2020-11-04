package com.example.struts2.services;

import java.util.List;

import com.example.struts2.commons.exceptions.ServicesException;
import com.example.struts2.data.Departamento;
import com.example.struts2.data.Empleado;

public interface GesEmpleado {
	
	public Empleado getEmpleado(Long id) throws ServicesException;
	
	public List<Departamento> getListDepartamentos();

	public Empleado grabar(Empleado empleado) throws ServicesException;

}
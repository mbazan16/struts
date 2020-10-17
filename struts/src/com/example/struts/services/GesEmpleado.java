package com.example.struts.services;

import java.util.List;

import com.example.struts.commons.exceptions.ServicesException;
import com.example.struts.data.Departamento;
import com.example.struts.data.Empleado;

public interface GesEmpleado {
	
	public Empleado getEmpleado(Long id) throws ServicesException;
	
	public List<Departamento> getListDepartamentos();

	public Empleado grabar(Empleado empleado) throws ServicesException;

}
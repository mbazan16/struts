package com.example.strutvalidator.services;

import java.util.List;

import com.example.strutvalidator.commons.exceptions.ServicesException;
import com.example.strutvalidator.data.Departamento;
import com.example.strutvalidator.data.Empleado;

public interface GesEmpleado {
	
	public Empleado getEmpleado(Long id) throws ServicesException;
	
	public List<Departamento> getListDepartamentos();

	public Empleado grabar(Empleado empleado) throws ServicesException;

}
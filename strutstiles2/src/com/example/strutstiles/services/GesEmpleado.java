package com.example.strutstiles.services;

import java.util.List;

import com.example.strutstiles.commons.exceptions.ServicesException;
import com.example.strutstiles.data.Departamento;
import com.example.strutstiles.data.Empleado;

public interface GesEmpleado {
	
	public Empleado getEmpleado(Long id) throws ServicesException;
	
	public List<Departamento> getListDepartamentos();

	public Empleado grabar(Empleado empleado) throws ServicesException;

}
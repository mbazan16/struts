package com.example.struts2.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.struts2.commons.exceptions.ServicesException;
import com.example.struts2.data.Departamento;
import com.example.struts2.data.Empleado;

public class GesEmpleadoImpl implements GesEmpleado {
	
	private static final Logger log = LogManager.getLogger(GesEmpleadoImpl.class);
	
	public static Long NEXT_ID_USUARIO = 1l;

	public Empleado getEmpleado(Long id) throws ServicesException{
		log.info("getEmpleado-id:"+id);
		
		Empleado empleado = generateEmplado(id);
		return empleado;
	}

	@Override
	public List<Departamento> getListDepartamentos() {
		log.info("getListDepartamentos");
		
		return generateListDepartamentos();
	}

	@Override
	public Empleado grabar(Empleado empleado) throws ServicesException {
		log.info("grabar-Empleado:"+empleado);
		
		if(empleado.getId()==null) empleado.setId(++NEXT_ID_USUARIO);
		
		//TODO Cuando conectemos a bbdd se cambia: Se busca el departamento
		Long indice =empleado.getDepartamento().getId()-1;
		
		log.info("indice:"+indice);
		empleado.setDepartamento(generateListDepartamentos().get(Integer.parseInt(indice+"")));
		
		return empleado;
		
	}

	private List<Departamento> generateListDepartamentos() {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		departamentos.add(generateDepartamento(1L, "Administracion"));
		departamentos.add(generateDepartamento(2l, "Compras"));
		departamentos.add(generateDepartamento(3l, "Direccion"));
		return departamentos;
	}

	private Empleado generateEmplado(Long id) {
		Empleado empleado = new Empleado();
		empleado.setId(id);
		empleado.setUsername("a");
		empleado.setNombre("Miguel");
		empleado.setApellidos("Suarez");
		empleado.setEdad(35);
		empleado.setDepartamento(generateDepartamento(1l,"Administracion"));
		return empleado;
	}

	private Departamento generateDepartamento(Long id, String nombre) {
		Departamento departamento = new Departamento();
		departamento.setId(id);
		departamento.setNombre(nombre);
		return departamento;
	}

}

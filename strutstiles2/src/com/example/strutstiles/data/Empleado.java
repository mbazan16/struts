package com.example.strutstiles.data;

import java.util.Date;

public class Empleado {
	
	private Long id;
	private String username;
	private String nombre;
	private String apellidos;
	private int edad;
	private Departamento departamento;		
	
	public Empleado() {
		super();
		departamento = new Departamento();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", edad=" + edad + ", departamento=" + departamento
				+ "]";
	}
	
	

}

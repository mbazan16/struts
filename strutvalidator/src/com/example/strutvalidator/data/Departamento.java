package com.example.strutvalidator.data;

public class Departamento {
	
	private Long id;
	private String nombre;
	
	public Departamento() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}

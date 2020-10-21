package com.example.strutexample.model;

import org.apache.struts.action.ActionForm;

public class ObjectModel extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public ObjectModel() {
		super();
	}

	public ObjectModel(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMaria() {
		return "retorno lo que quiera";
	}


}

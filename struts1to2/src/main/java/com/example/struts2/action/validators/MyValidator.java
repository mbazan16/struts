package com.example.struts2.action.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class MyValidator extends FieldValidatorSupport {

	private String palabrasNoPermitidas;

	public String getPalabrasNoPermitidas() {
		return palabrasNoPermitidas;
	}

	public void setPalabrasNoPermitidas(String palabrasNoPermitidas) {
		this.palabrasNoPermitidas = palabrasNoPermitidas;
	}

	@Override
	public void validate(Object arg0) throws ValidationException {
		String fieldName = getFieldName();
		Object value = this.getFieldValue(fieldName, arg0);		
		String palabras = (String) value;
		
		  StringTokenizer tokens = new
		  StringTokenizer(this.palabrasNoPermitidas,",");
		  List<String> palabrasNoPermitidas = new ArrayList<String>(); 
		  while
		  (tokens.hasMoreElements()) {
		  palabrasNoPermitidas.add(tokens.nextToken().toUpperCase());
		  } 
		  // Comprobamos que no haya ninguna palabra no permitida,
		  // si las hay se emite error if
		  if(!comprobarPalabras(palabras, palabrasNoPermitidas)) {
			  addFieldError(fieldName, arg0);
		   }
		 
	}

	private static boolean comprobarPalabras(String palabras, List<String> palabrasNoPermitidas) {
		// Trozeamos las palabras
		StringTokenizer tokens = new StringTokenizer(palabras, " ");
		String palabra = null;
		while (tokens.hasMoreTokens()) {
			palabra = tokens.nextToken().toUpperCase();
			if (palabrasNoPermitidas.contains(palabra))
				return false;
		}
		return true;

	}

}

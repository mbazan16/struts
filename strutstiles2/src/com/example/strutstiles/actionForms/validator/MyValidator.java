package com.example.strutstiles.actionForms.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

public class MyValidator {

	public static boolean validarPalabras(Object object, ValidatorAction va, Field field, ActionMessages errors,
			Validator val, HttpServletRequest request) {
		StringTokenizer tokens = new StringTokenizer(field.getVar("noPermitidas").getValue().toString(),",");
		List<String> palabrasNoPermitidas = new ArrayList<String>();
		while (tokens.hasMoreElements()) {
			palabrasNoPermitidas.add(tokens.nextToken().toUpperCase());
		}
		// Parseamos la cadena a validar desde el campo del formulario
		String palabras = ValidatorUtils.getValueAsString(object, field.getProperty());
		// Comprobamos que no haya ninguna palabra no permitida, si las hay se emite
		// error
		if (!comprobarPalabras(palabras, palabrasNoPermitidas)) {
			errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
			return false;
		}
		return true;
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
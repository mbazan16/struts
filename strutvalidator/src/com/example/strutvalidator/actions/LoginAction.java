package com.example.strutvalidator.actions;

import static com.example.strutvalidator.commons.Constantes.ERROR_GENERAL;
import static com.example.strutvalidator.commons.Constantes.PASSWORD_INCORRECTA;
import static com.example.strutvalidator.commons.Constantes.USERNAME_INCORRECTO;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;

import com.example.strutvalidator.commons.exceptions.ServicesException;
import com.example.strutvalidator.services.GesLogin;
import com.example.strutvalidator.services.GesLoginImpl;

public class LoginAction extends Action {
	private static final Logger log = Logger.getLogger(LoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("LoginAction-execute");
		String forward = "login";
		GesLogin servicio;
		ActionMessages errores = new ActionErrors();

		try {
			
			DynaValidatorForm loginForm = (DynaValidatorForm)form;
			
			log.info("Username:" + loginForm.get("username"));
			log.info("Password:" + loginForm.get("password"));
			
			servicio = new GesLoginImpl();
			
			Long idUsuario = servicio.login((String)loginForm.get("username"), (String)loginForm.get("password"));
			
			loginForm.set("idUsuario", idUsuario);
			
			forward = "success";
			//int i=1/0;
			
			/* Métodos para comprobar los valores del request y de session por trazas
			 * log.info("REQUEST:"+request); mostrarParametros(request);
			 * mostrarAtributos(request); log.info("SESSION:"+request.getSession());
			 * mostrarAtributosSession(request);
			 */

		} catch (ServicesException e) {
			log.error("Exception", e);
			if(USERNAME_INCORRECTO.equalsIgnoreCase(e.getClaveError())) {
				errores.add("username",new ActionMessage(e.getClaveError()));
			}else if(PASSWORD_INCORRECTA.equalsIgnoreCase(e.getClaveError())){
				errores.add("password",new ActionMessage(e.getClaveError()));
			}
			saveErrors(request, errores);
			forward = "failure";
			
		}catch (Exception e) {
			log.error("Exception", e);
			errores.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage(ERROR_GENERAL,e.getMessage()));
			saveErrors(request, errores);
			forward = "error";
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}
	
	private void mostrarParametros(HttpServletRequest request) {
		log.info("Request-Parametros:");
		Enumeration parametros =request.getParameterNames();
		while(parametros.hasMoreElements()) {
			log.info(parametros.nextElement());
		}
		
	}

	private void mostrarAtributos(HttpServletRequest request) {
		log.info("Request-Atributos:");
		Enumeration atributos =request.getAttributeNames();
		while(atributos.hasMoreElements()) {
			log.info(atributos.nextElement());
		}
		
	}

	private void mostrarAtributosSession(HttpServletRequest request) {
		log.info("Session-Atributos:");
		Enumeration atributos =request.getSession().getAttributeNames();
		while(atributos.hasMoreElements()) {
			log.info(atributos.nextElement());
		}
	}

}

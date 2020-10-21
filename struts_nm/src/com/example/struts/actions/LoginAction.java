package com.example.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.struts.actionForms.LoginForm;
import com.example.struts.services.GesLogin;
import com.example.struts.services.GesLoginImpl;

public class LoginAction extends Action {
	private static final Logger log = Logger.getLogger(LoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("LoginAction-execute");
		String forward = "login";
		GesLogin servicio;

		try {
			LoginForm loginForm = (LoginForm) form;
			if (loginForm.getUsername() == null)
				return mapping.findForward(forward);			
			
			log.info("Username:" + loginForm.getUsername());
			log.info("Password:" + loginForm.getPassword());
			
			servicio = new GesLoginImpl();
			
			Long idUsuario = servicio.login(loginForm.getUsername(), loginForm.getPassword());
			
			request.getSession().setAttribute("idUsuario", idUsuario);
			
			forward = "success";

		} catch (Exception e) {
			log.error("Exception", e);
			request.setAttribute("error", e.getMessage());
			forward = "error";
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}

}

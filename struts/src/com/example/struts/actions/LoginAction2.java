package com.example.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.example.struts.services.GesLogin;
import com.example.struts.services.GesLoginImpl;

public class LoginAction2 extends Action {
	private static final Logger log = Logger.getLogger(LoginAction2.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("LoginAction-execute");
		String forward = "login";
		GesLogin servicio;

		try {
			
			DynaActionForm loginForm = (DynaActionForm)form;
			if (loginForm.get("username") == null)
				return mapping.findForward(forward);			
			
			log.info("Username:" + loginForm.get("username"));
			log.info("Password:" + loginForm.get("password"));
			
			servicio = new GesLoginImpl();
			
			Long idUsuario = servicio.login((String)loginForm.get("username"), (String)loginForm.get("password"));
			
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

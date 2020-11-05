package com.example.struts2.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.example.struts2.commons.exceptions.ServicesException;
import com.example.struts2.services.GesLogin;
import com.example.struts2.services.GesLoginImpl;
import com.opensymphony.xwork2.ActionSupport;

import static com.example.struts2.commons.Constantes.*;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(LoginAction.class);

	private String username;

	private String password;
	Map<String, Object> mapaSession;
	
	

	@Override
	public String execute() throws Exception {
		log.info("LoginAction-execute"); 

		GesLogin servicio;
		try {

			log.info("Username:" + username);
			log.info("Password:" + password);
			System.out.println("execute");

			servicio = new GesLoginImpl();

			Long idUsuario = servicio.login(username, password);

			mapaSession.put(USUARIO_KEY, idUsuario);

		}catch (ServicesException e) {
			log.error("Exception", e);
			String[] params= {username};
			if(USERNAME_INCORRECTO.equalsIgnoreCase(e.getClaveError()))
				addFieldError("username", getText("error.username.novalid",params));
			if(PASSWORD_INCORRECTA.equalsIgnoreCase(e.getClaveError()))
				addFieldError("password", getText("error.password.novalid"));
			log.info("ActionSupport.INPUT:"+ActionSupport.INPUT);
			return ActionSupport.INPUT;
		} catch (Exception e) {
			log.error("Exception", e);
			addActionError(getText("error.message"));
			return ActionSupport.ERROR;
		}

		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		if (username == null || "".equalsIgnoreCase(username.trim()))
			addFieldError("username", getText("error.username"));
		if (password == null || "".equalsIgnoreCase(password.trim()))
			addFieldError("password", getText("error.password"));
		super.validate();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map getMapaSession() {
		return mapaSession;
	}

	public void setMapaSession(Map mapaSession) {
		this.mapaSession = mapaSession;
	}

	@Override
	public void setSession(Map<String, Object> m) {
		this.mapaSession = m;

	}

}

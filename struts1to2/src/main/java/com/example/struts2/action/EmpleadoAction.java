package com.example.struts2.action;

import static com.example.struts2.commons.Constantes.USUARIO_KEY;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.example.struts2.data.Departamento;
import com.example.struts2.data.Empleado;
import com.example.struts2.services.GesEmpleado;
import com.example.struts2.services.GesEmpleadoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EmpleadoAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	final static Logger log = LogManager.getLogger(EmpleadoAction.class);

	private Empleado empleado;
	Map<String, Object> mapaSession;

	@Override
	public String execute() throws Exception {

		log.info("EmpleadoAction-unspecified");
		Long idUsuario = 0L;

		GesEmpleado gesEmpleado;

		try {
			gesEmpleado = new GesEmpleadoImpl();

			// Este es el codigo para recuperar el idUsuario cuando venga por sesion
			idUsuario = (Long) mapaSession.get(USUARIO_KEY);
			log.info("idUsuario:" + idUsuario);

			empleado = gesEmpleado.getEmpleado(idUsuario);

			// cambiamos el locale
			ServletActionContext.getContext().setLocale(new Locale("en", "US"));
			//int i=1/0;

		} catch (Exception e) {
			log.error("Exception", e);
			String[] params = {e.getMessage()};
			addActionError(getText("error.message",params));
			//throw e;
			return ActionSupport.ERROR;
		}

		return ActionSupport.SUCCESS;

	}

	public String editar() throws Exception {

		log.info("EmpleadoAction-editar");

		GesEmpleado gesEmpleado;

		try {

			gesEmpleado = new GesEmpleadoImpl();

			// Este es el codigo para recuperar el idUsuario cuando venga por sesion
			Long idUsuario = (Long) mapaSession.get("idUsuario");
			log.info("idUsuario:" + idUsuario);
			empleado = gesEmpleado.getEmpleado(idUsuario);

			List<Departamento> departamentos = gesEmpleado.getListDepartamentos();
			mapaSession.put("departamentos", departamentos);

		} catch (Exception e) {
			log.error("Exception", e);
			return ActionSupport.ERROR;
		}

		return ActionSupport.SUCCESS;

	}

	public String nuevo() throws Exception {

		log.info("EmpleadoAction-nuevo");

		GesEmpleado gesEmpleado;

		try {

			gesEmpleado = new GesEmpleadoImpl();

			List<Departamento> departamentos = gesEmpleado.getListDepartamentos();
			mapaSession.put("departamentos", departamentos);

		} catch (Exception e) {
			log.error("Exception", e);
			return ActionSupport.ERROR;
		}

		return ActionSupport.SUCCESS;

	}

	public String grabar() throws Exception {

		log.info("EmpleadoAction-grabar");

		GesEmpleado gesEmpleado;

		try {

			log.info("empleado:" + empleado);

			gesEmpleado = new GesEmpleadoImpl();

			empleado = gesEmpleado.grabar(empleado);

			mapaSession.remove("departamentos");

		} catch (Exception e) {
			log.error("Exception", e);
			return ActionSupport.ERROR;
		}

		return ActionSupport.SUCCESS;

	}

	public String crear() throws Exception {

		log.info("EmpleadoAction-crear");

		GesEmpleado gesEmpleado;

		try {

			log.info("empleado:" + empleado);

			gesEmpleado = new GesEmpleadoImpl();

			empleado = gesEmpleado.grabar(empleado);

			mapaSession.remove("departamentos");

		} catch (Exception e) {
			log.error("Exception", e);
			return ActionSupport.ERROR;
		}

		return ActionSupport.SUCCESS;

	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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

	@Override
	public void validate() {
		if (empleado != null) {
			if (empleado.getNombre() == null || "".equalsIgnoreCase(empleado.getNombre().trim()))
				addFieldError("nombre", getText("error.nombre"));
		}
		super.validate();
	}

}

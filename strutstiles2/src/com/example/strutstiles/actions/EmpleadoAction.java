package com.example.strutstiles.actions;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

import com.example.strutstiles.actionForms.EmpleadoForm;
import com.example.strutstiles.data.Departamento;
import com.example.strutstiles.data.Empleado;
import com.example.strutstiles.services.GesEmpleado;
import com.example.strutstiles.services.GesEmpleadoImpl;

public class EmpleadoAction extends DispatchAction {
	private static final Logger log = Logger.getLogger(EmpleadoAction.class);

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("EmpleadoAction-unspecified");
		ActionMessages errores = new ActionErrors();
 
		EmpleadoForm empleadoForm;
		String forward = "success";
		Long idUsuario = 0L;

		GesEmpleado gesEmpleado;

		try {
			empleadoForm = (EmpleadoForm) form;

			gesEmpleado = new GesEmpleadoImpl();

			/*
			 * Métodos para comprobar los valores del request y de session por trazas
			 * log.info("REQUEST:"+request); mostrarParametros(request);
			 * mostrarAtributos(request); log.info("SESSION:"+request.getSession());
			 * mostrarAtributosSession(request);
			 */

			/*
			 * Este es el codigo para recuperar el idUsuario cuando la accion tenga un
			 * 
			 * try { idUsuario = (Long) ((DynaValidatorForm)
			 * request.getAttribute("loginForm")).get("idUsuario"); log.info("idUsuario:" +
			 * idUsuario);
			 * 
			 * } catch (Exception e) {
			 * log.error("Excepcion recogida del request - ATRIBUTTE", e); }
			 */

			// Este es el codigo para recuperar el idUsuario cuando venga por sesion
			idUsuario = (Long) ((DynaValidatorForm) request.getSession().getAttribute("loginForm")).get("idUsuario");
			log.info("idUsuario:" + idUsuario);
			//Introducimos en sesion el idUsuario para utilizarlo despues
			request.getSession().setAttribute("idUsuario", idUsuario);
			

			Empleado empleado = gesEmpleado.getEmpleado(idUsuario);
			empleadoForm.setEmpleado(empleado);

			// Eliminamos de sesion el formulario de Login
			request.getSession().removeAttribute("loginForm");

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.message", e.getMessage()));
			saveErrors(request, errores);
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}

	public ActionForward editar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("EmpleadoAction-editar");
		ActionMessages errores = new ActionErrors();
		EmpleadoForm empleadoForm;
		String forward = "esuccess";

		GesEmpleado gesEmpleado;

		try {

			// Estas tres sentencias no son necesarias
			// Comprobación de que el empleadoForm NO tiene valores
			// ya que empleado.jsp no ennvia ningun dato
			empleadoForm = (EmpleadoForm) form;
			log.info("empleadoForm:" + empleadoForm);
			log.info("id:" + empleadoForm.getEmpleado().getId());

			gesEmpleado = new GesEmpleadoImpl();
			
			Long idUsuario =(Long) request.getSession().getAttribute("idUsuario");
			
			Empleado empleado = gesEmpleado.getEmpleado(idUsuario);
			empleadoForm.setEmpleado(empleado);

			List<Departamento> departamentos = gesEmpleado.getListDepartamentos();
			request.getSession().setAttribute("departamentos", departamentos);

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message", e.getMessage()));
			saveErrors(request, errores);
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}

	public ActionForward crear(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("EmpleadoAction-crear");
		ActionMessages errores = new ActionErrors();
		EmpleadoForm empleadoForm;
		String forward = "nsuccess";

		GesEmpleado gesEmpleado;

		try {

			// Estas tres sentencias no son necesarias
			// Comprobación de que el empleadoForm NO tiene valores
			// ya que empleado.jsp no ennvia ningun dato
			empleadoForm = (EmpleadoForm) form;
			log.info("empleadoForm:" + empleadoForm);
			log.info("id:" + empleadoForm.getEmpleado().getId());		

			gesEmpleado = new GesEmpleadoImpl();

			List<Departamento> departamentos = gesEmpleado.getListDepartamentos();
			request.getSession().setAttribute("departamentos", departamentos);

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message", e.getMessage()));
			saveErrors(request, errores);
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}

	public ActionForward grabar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("EmpleadoAction-grabar");
		ActionMessages errores = new ActionErrors();
		EmpleadoForm empleadoForm;
		String forward = "success";

		GesEmpleado gesEmpleado;

		try {

			// Comprobación de que el empleadoForm tiene valores
			// ya que e_empleado.jsp y n_empleado.jsp envian los datos
			empleadoForm = (EmpleadoForm) form;
			log.info("empleadoForm:" + empleadoForm);
			log.info("id:" + empleadoForm.getEmpleado().getId());

			gesEmpleado = new GesEmpleadoImpl();

			Empleado empleado = empleadoForm.getEmpleado();

			empleado = gesEmpleado.grabar(empleado);

			empleadoForm.setEmpleado(empleado);

			request.getSession().removeAttribute("departamentos");

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message", e.getMessage()));
			saveErrors(request, errores);
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}

	private void mostrarParametros(HttpServletRequest request) {
		log.info("Request-Parametros:");
		Enumeration parametros = request.getParameterNames();
		while (parametros.hasMoreElements()) {
			log.info(parametros.nextElement());
		}

	}

	private void mostrarAtributos(HttpServletRequest request) {
		log.info("Request-Atributos:");
		Enumeration atributos = request.getAttributeNames();
		while (atributos.hasMoreElements()) {
			log.info(atributos.nextElement());
		}

	}

	private void mostrarAtributosSession(HttpServletRequest request) {
		log.info("Session-Atributos:");
		Enumeration atributos = request.getSession().getAttributeNames();
		while (atributos.hasMoreElements()) {
			log.info(atributos.nextElement());
		}
	}

}

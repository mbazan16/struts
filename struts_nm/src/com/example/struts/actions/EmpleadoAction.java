package com.example.struts.actions;

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

import com.example.struts.actionForms.EmpleadoForm;
import com.example.struts.data.Departamento;
import com.example.struts.data.Empleado;
import com.example.struts.services.GesEmpleado;
import com.example.struts.services.GesEmpleadoImpl;

public class EmpleadoAction extends DispatchAction {
	private static final Logger log = Logger.getLogger(EmpleadoAction.class);

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.info("EmpleadoAction-unspecified");
		ActionMessages errores = new ActionErrors();
		
		
		EmpleadoForm empleadoForm;
		String forward = "success";

		GesEmpleado gesEmpleado;

		try {
			empleadoForm = (EmpleadoForm) form;

			gesEmpleado = new GesEmpleadoImpl();

			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			log.info("idUsuario:" + idUsuario);

			Empleado empleado = gesEmpleado.getEmpleado(idUsuario);
			empleadoForm.setEmpleado(empleado);
			
			//int i=1/0;
			

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message",e.getMessage()));
            saveErrors(request, errores);
            //throw new Exception(e);
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

			empleadoForm = (EmpleadoForm) form;

			gesEmpleado = new GesEmpleadoImpl();

			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			log.info("idUsuario:" + idUsuario);

			Empleado empleado = gesEmpleado.getEmpleado(idUsuario);
			List<Departamento> departamentos = gesEmpleado.getListDepartamentos();
			empleadoForm.setEmpleado(empleado);
			empleadoForm.setDepartamentos(departamentos);

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message",e.getMessage()));
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

			empleadoForm = (EmpleadoForm) form;

			gesEmpleado = new GesEmpleadoImpl();

			List<Departamento> departamentos = gesEmpleado.getListDepartamentos();
			empleadoForm.setDepartamentos(departamentos);

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message",e.getMessage()));
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

			empleadoForm = (EmpleadoForm) form;

			gesEmpleado = new GesEmpleadoImpl();

			Empleado empleado = empleadoForm.getEmpleado();

			empleado = gesEmpleado.grabar(empleado);

			empleadoForm.setEmpleado(empleado);

		} catch (Exception e) {
			log.error("Exception", e);
			errores.add("noControlado", new ActionMessage("error.message",e.getMessage()));
            saveErrors(request, errores);
		}

		log.info("forward" + forward);
		return mapping.findForward(forward);

	}

}

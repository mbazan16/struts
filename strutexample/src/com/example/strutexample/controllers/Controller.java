package com.example.strutexample.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.strutexample.model.ObjectModel;



public class Controller extends Action {
	
	private static final Logger log = Logger.getLogger(Controller.class);

	 public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
		 String forward = "view";
			

			try {
				
				ObjectModel model = new ObjectModel(1l,"myObject");
				
				request.setAttribute("model", model);
				//long error = 1l/0;
				
			} catch (Exception e) {
				log.error("Exception", e);
				request.setAttribute("error", e.getMessage());
				forward = "error";
			}

			log.debug("forward"+forward);		
		   return mapping.findForward(forward);
	   }
	

}

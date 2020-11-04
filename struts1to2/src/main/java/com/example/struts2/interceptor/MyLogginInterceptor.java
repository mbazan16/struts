package com.example.struts2.interceptor;

import static com.example.struts2.commons.Constantes.USUARIO_KEY;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.example.struts2.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyLogginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(MyLogginInterceptor.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("MyLogginInterceptor-destroy");

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		log.info("MyLogginInterceptor-init");


	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		final ActionContext context = ai.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(StrutsStatics.HTTP_REQUEST);
		log.info("MyLogginInterceptor-intercept");

				
		HttpSession session = request.getSession(true);
		

		// Is there a "user" object stored in the user's HttpSession?
		Object idUsuario = session.getAttribute(USUARIO_KEY);
		log.info("MyLogginInterceptor-idUsuario:"+idUsuario);
		
		log.info("MyLogginInterceptor-InvocationAction:"+ai.getAction().getClass());
		
		if (idUsuario == null) {
			if (ai.getAction().getClass().equals(LoginAction.class))
			{
				return ai.invoke();
			}
			
			log.info("MyLogginInterceptor-login");
			return "login";
		}
		return ai.invoke();
	}

}

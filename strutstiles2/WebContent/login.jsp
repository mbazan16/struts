<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<div class="contenedorLogin">
<html:form action="registrar" method="post" target="_self">
	<html:hidden name="loginForm" property="idUsuario"/>
<p> <bean:message key="aplication.login"/> </p>
  <fieldset>
    <legend><bean:message key="aplication.campo.username"/></legend>
   <html:text name="loginForm" property="username"/>
   <span class="error"><html:errors property="username" /></span>
  </fieldset>
  <fieldset>
    <legend><bean:message key="aplication.campo.password"/></legend>
    <html:password name="loginForm" property="password"/>
    <span class="error"><html:errors property="password"/></span>
  </fieldset>
  <button type="submit" class="button"><bean:message key="aplication.enviar"/>
  </button>
</html:form>
</div>

</body>
</html>
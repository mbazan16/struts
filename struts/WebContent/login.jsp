<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginJSP</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<div class="contenedorLogin">
<html:form action="login" method="post" target="_self">
<p> Login </p>
  <fieldset>
    <legend>Username</legend>
   <html:text name="loginForm" property="username"/>
  </fieldset>
  <fieldset>
    <legend>Password</legend>
    <html:password name="loginForm" property="password"/>
  </fieldset>
  <button type="submit" class="button">Enviar
  </button>
</html:form>
</div>

</body>
</html>
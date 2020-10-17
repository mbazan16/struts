<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginJSP</title>
</head>
<body>
<html:form action="login" method="post" target="_self">
  <fieldset>
    <legend>Username</legend>
   <html:text name="loginForm2" property="username"/>
  </fieldset>
  <fieldset>
    <legend>Password</legend>
    <html:password name="loginForm2" property="password"/>
  </fieldset>
  <button type="submit">Enviar
  </button>
</html:form>

</body>
</html>
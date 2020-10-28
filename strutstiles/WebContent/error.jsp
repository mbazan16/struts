<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Error</title>
</head>
<body>
<div class="contenedorErrores">
 Se ha producido el error:<span class="error"> <html:errors/></span> 
 <p><a href="./login.do" class="button">Salir</a></p>
</div>
</body>
</html>
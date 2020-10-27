<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Errores Validacion</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<div class="contenedorErrores">
<span class="error"> <html:errors/></span> 
 <p><a href="./empleado.do?accion=crear" class="button">Volver</a></p>
</div>
</body>
</html>
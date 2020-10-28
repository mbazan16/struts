<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>Entrada datos</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

<tiles:insert attribute="header" />

<div class="contenedor">

<tiles:insert attribute="formulario" />
<tiles:insert attribute="buttons" />
</div>

<tiles:insert attribute="errores" />


<tiles:insert attribute="footer" />


</body>
</html>
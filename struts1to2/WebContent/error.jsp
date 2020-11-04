<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Error</title>
<link rel="stylesheet" type="text/css" href="../css/estilo.css">
</head>
<body>
	<div class="contenedorErrores">
		<s:if test="exception!=null">
 Se ha producido el error:<span class="error"> <s:property
					value="exception" /></span>
			<br>
 Detalles: <s:property value="exceptionStack" />
	</div>
	</s:if>
	<s:if test="exception==null">
 Se ha producido el error:<span class="error"> <s:actionerror/></span>

	</s:if>
	</div>
	<p>
		<a href="<s:url action=""/>" class="button">Salir</a>
	</p>

</body>
</html>
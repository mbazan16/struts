<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="aplication.empleado.editar" /></title>
<link rel="stylesheet" type="text/css" href="../css/estilo.css">
</head>
<body>
	<div class="contenedor">
		<s:form action="grabar" method="post" validate="true">
			<p>
			<s:text name="aplication.empleado.editar" />
			</p>
			<s:text name="aplication.campo.username" />
			<s:property value="empleado.username" />
			<s:textfield name="empleado.nombre" key="aplication.campo.nombre" />
			<s:textfield name="empleado.apellidos"
				key="aplication.campo.apellidos" />
			<s:textfield name="empleado.edad" key="aplication.campo.edad" />
			<s:select name="empleado.departamento.id" key="aplication.campo.departamento"
 				list="#session.departamentos" listKey="id" listValue="nombre" /> 
			<s:submit name="btnEnviar" type="submit" key="aplication.enviar"
				align="center" class="button" />
		</s:form>
	</div>
	<s:if test="hasActionErrors()">
		<div class="contenedorErrores">
			<s:text name="aplication.errores" />
			:<br> <span class="error"> <s:actionerror /></span>
		</div>
	</s:if>

</body>
</html>
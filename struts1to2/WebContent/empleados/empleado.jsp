<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="aplication.empleado.ficha" /></title>
<link rel="stylesheet" type="text/css" href="../css/estilo.css">
</head>
<body>
	<div class="contenedor">
		
		<table>
			<p>
				<s:text name="aplication.empleado.ficha" />
			</p>
			<tr>
				<td class="legend"><s:text name="aplication.campo.username" /></td>
				<td><s:property value="empleado.username" /></td>
			</tr>
			<tr>
				<td class="legend"><s:text name="aplication.campo.nombre" /></td>
				<td><s:property value="empleado.nombre" /></td>
			</tr>
			<tr>
				<td class="legend"><s:text name="aplication.campo.apellidos" /></td>
				<td><s:property value="empleado.apellidos" /></td>
			</tr>
			<tr>
				<td class="legend"><s:text name="aplication.campo.edad" /></td>
				<td><s:property value="empleado.edad" /></td>
			</tr>

			<tr>
				<td class="legend"><s:text name="aplication.campo.departamento" /></td>
				<td><s:property value="empleado.departamento.nombre" /></td>
			</tr>
		</table>
		<a href="<s:url action="editar.action" namespace="/empleados"/>"
			class="button"><s:text name="aplication.editar" /></a> <a
			href="<s:url action="nuevo.action" namespace="/empleados"/>"
			class="button"><s:text name="aplication.crear" /></a> <a
			href="<s:url action="login.action" namespace="/"/>" class="button"><s:text
				name="aplication.volver" /></a>
	</div>
	<s:if test="hasActionErrors()">
		<div class="contenedorErrores">
			<s:text name="aplication.errores" />
			:<br> <span class="error"> <s:actionerror /></span>
		</div>
	</s:if>
</body>
</html>
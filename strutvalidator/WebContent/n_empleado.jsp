<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Empleado</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<bean:define id="departamentos" scope="session" name="departamentos"/>
<div class="contenedor">
<html:form action="nempleado" method="post" target="_self">
	<html:hidden name="empleadoForm" property="accion" value="grabar"/>
    
<table>
  <p>Empleado</p>
  <tr>
    <td class="legend">Username</td>
    <td><html:text name="empleadoForm" property="empleado.username"/><html:errors property="username"/></td>
  </tr>
  <tr>
    <td class="legend">Password</td>
    <td><html:password name="empleadoForm" property="newPassword"/></td>
  </tr>
  <tr>
    <td class="legend">Nombre</td>
    <td><html:text name="empleadoForm" property="empleado.nombre"/><html:errors property="nombre"/></td>
  </tr>
  <tr>
    <td class="legend">Apellidos</td>
    <td><html:text name="empleadoForm" property="empleado.apellidos"/></td>
  </tr>
  <tr>
    <td class="legend">Edad</td>
    <td><html:text name="empleadoForm" property="empleado.edad"/><html:errors property="edad"/></td>
  </tr>  
  <tr>
    <td class="legend">Departamento</td>
    <td><html:select name="empleadoForm" property="empleado.departamento.id" >
       <html:option value=""><bean:message key="aplication.select.seleccionar"/></html:option>
       <html:optionsCollection  name="departamentos" label="nombre" value="id"/>
    </html:select><html:errors property="departamento"/></td>
  </tr>
</table>
  <button type="submit" class="button">Enviar</button>
</html:form>
</div>

</body>
</html>
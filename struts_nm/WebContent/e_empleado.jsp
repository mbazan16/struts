<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="aplication.empleado.editar"/></title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<div class="contenedor">
<html:form action="eempleado" method="post" target="_self">
	<html:hidden name="empleadoForm" property="accion" value="grabar"/>
    <html:hidden name="empleadoForm" property="empleado.id"/>
    <html:hidden name="empleadoForm" property="empleado.username"/>
    
<table>
  <p><bean:message key="aplication.empleado.editar"/></p>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.username"/></td>
    <td><bean:write name="empleadoForm" property="empleado.username"/></td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.nombre"/></td>
    <td><html:text name="empleadoForm" property="empleado.nombre"/><html:errors property="nombre"/>
     </td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.apellidos"/></td>
    <td><html:text name="empleadoForm" property="empleado.apellidos"/></td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.edad"/></td>
    <td><html:text name="empleadoForm" property="empleado.edad"/><span class="error"><html:errors property="edad"/></span></td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.departamento"/></td>
    <td><html:select name="empleadoForm" property="empleado.departamento.id" >
       <html:option value=""><bean:message key="aplication.select.seleccionar"/></html:option>
       <html:optionsCollection  name="empleadoForm" property="departamentos" label="nombre" value="id"/>
    </html:select><html:errors property="departamento"/></td>
  </tr>
</table>
     <button type="submit" class="button"><bean:message key="aplication.enviar"/>
</html:form>
</div>

</body>
</html>
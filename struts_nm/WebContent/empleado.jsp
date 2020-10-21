<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="aplication.empleado.ficha"/></title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
<div class="contenedor">
<table>
  <p><bean:message key="aplication.empleado.ficha"/></p>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.username"/></td>
    <td><bean:write name="empleadoForm" property="empleado.username"/></td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.nombre"/></td>
    <td><bean:write name="empleadoForm" property="empleado.nombre"/></td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.apellidos"/></td>
    <td><bean:write name="empleadoForm" property="empleado.apellidos"/></td>
  </tr>
  <tr>
    <td class="legend"><bean:message key="aplication.campo.edad"/></td>
    <td><bean:write name="empleadoForm" property="empleado.edad"/></td>
  </tr>
  
  <tr>
    <td class="legend"><bean:message key="aplication.campo.departamento"/></td>
    <td><bean:write name="empleadoForm" property="empleado.departamento.nombre"/></td>
  </tr>
</table>
<a href="./empleado.do?accion=editar" class="button"><bean:message key="aplication.editar"/></a>
<a href="./empleado.do?accion=crear"  class="button"><bean:message key="aplication.crear"/></a>
</div>
 <logic:messagesPresent >
    <div class="contenedorErrores">
    	<bean:message key="aplication.errores"/>:<br>
      	<span class="error"><html:errors/></span>
     </div>
 </logic:messagesPresent>
</body>
</html>
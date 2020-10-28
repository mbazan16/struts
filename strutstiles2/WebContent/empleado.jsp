<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

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

 
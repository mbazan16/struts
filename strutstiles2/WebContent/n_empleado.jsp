<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<script>
 function enviar(){
	 document.forms['empleadoForm'].submit();
 }
 </script>
<bean:define id="departamentos" scope="session" name="departamentos"/>
<html:form action="nempleado" method="post" target="_self">
	<html:hidden name="empleadoForm" property="accion" value="grabar"/>
    
<table>
  <p>Empleado</p>
  <tr>
    <td class="legend">Username</td>
    <td><html:text name="empleadoForm" property="empleado.username"/><html:errors property="empleado.username"/></td>
  </tr>
  <tr>
    <td class="legend">Password</td>
    <td><html:password name="empleadoForm" property="newPassword"/></td>
  </tr>
  <tr>
    <td class="legend">Nombre</td>
    <td><html:text name="empleadoForm" property="empleado.nombre"/><html:errors property="empleado.nombre"/></td>
  </tr>
  <tr>
    <td class="legend">Apellidos</td>
    <td><html:text name="empleadoForm" property="empleado.apellidos"/></td>
  </tr>
  <tr>
    <td class="legend">Edad</td>
    <td><html:text name="empleadoForm" property="empleado.edad"/><html:errors property="empleado.edad"/></td>
  </tr>  
  <tr>
    <td class="legend">Departamento</td>
    <td><html:select name="empleadoForm" property="empleado.departamento.id" >
       <html:option value=""><bean:message key="aplication.select.seleccionar"/></html:option>
       <html:optionsCollection  name="departamentos" label="nombre" value="id"/>
    </html:select><html:errors property="departamento"/></td>
  </tr>
</table>  
</html:form>
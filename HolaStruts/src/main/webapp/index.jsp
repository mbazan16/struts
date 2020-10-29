<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts2 hola mundo</title>
<s:head/>

</head>


<body>
<h1 style="color : red"> <s:text name="label.saludo"></s:text> </h1>
  <s:if test="hasActionErrors()">
    <div id="campoError">
        <s:actionerror/>
    </div>
  </s:if>

  <s:form action="holaAction" namespace="/" method="post" name="holaForm">
   <s:textfield name="nombre" size="30" maxlength="50" key="label.nombre"></s:textfield>
   <s:submit key="enviar" align="rigth"></s:submit>
  
  </s:form>
</body>
</html>

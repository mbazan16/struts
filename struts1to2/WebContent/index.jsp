<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
	<div class="contenedorLogin">	

		<s:form action="login">
			<p>
				<s:text name="aplication.login" />
			</p>

			<s:textfield name="username" key="aplication.campo.username" />
			<br>
			<s:password name="password" key="aplication.campo.password" />
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
	<s:if test="hasActionMessages()">
		<div class="contenedorErrores">
			<s:text name="aplication.errores" />
			:<br> <span class="error"> <s:actionmessage /></span>
		</div>
	</s:if>
</body>
</html>

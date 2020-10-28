<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<title>Entrada datos</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

<tiles:insert attribute="header" />


<tiles:insert attribute="errores" />


<tiles:insert attribute="footer" />

<a href="/login.do" class="button"><bean:message key="aplication.volver"/></a>

</body>
</html>
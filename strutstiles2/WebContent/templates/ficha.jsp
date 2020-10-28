<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

<tiles:insert attribute="header" />

<div class="contenedor">
<tiles:insert attribute="body" />
<tiles:insert attribute="buttons" />
</div>

<tiles:insert attribute="footer" />
<bean:message key="aplication.title"/>

</body>
</html>
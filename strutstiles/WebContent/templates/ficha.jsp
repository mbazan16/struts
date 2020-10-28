<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
	<table >
		<tr>
			<td  >
			<tiles:insert attribute="header" /></td>
		</tr>
		<tr>
			<td >
			<tiles:insert attribute="body" />
			</td>
		</tr>
		<tr>
			<td >
			<tiles:insert attribute="footer" /></td>
		</tr>
	</table>
</body>
</html>
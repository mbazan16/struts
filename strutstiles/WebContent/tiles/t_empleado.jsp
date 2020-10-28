<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/tiles/template.jsp" flush="true">
    <tiles:put name="title" value="Tiles Example" />
    <tiles:put name="header" value="/header.jsp" />
    <tiles:put name="body" value="/empleado.jsp" />
    <tiles:put name="footer" value="/footer.jsp" />
</tiles:insert>
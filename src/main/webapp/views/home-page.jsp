<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/css/style.css" var="urlCss"/>
        <link rel="STYLESHEET" href="${urlCss}" type="text/css" /> 
        <title>Example Spring Validation</title>
    </head>
    <body>
    <form:form method="POST" action="beer" modelAttribute="stadiumCommand">
        Choose color:
        <form:select path="stadiumSelected" items="${stadiumList}" />
        <input type="submit" value="OK" />
    </form:form>
    </body>
</html>
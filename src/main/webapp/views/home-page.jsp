<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="home.stadium.select" var="labelSelect" />
<spring:message code="home.title" var="title" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <spring:url value="/css/style.css" var="urlCss"/>
        <link rel="STYLESHEET" href="${urlCss}" type="text/css" /> 
        <title>${title}</title>
    </head>
    <body>
    <form:form method="POST" action="game" modelAttribute="stadiumCommand">
        ${labelSelect}:
        <form:select path="stadiumSelected">
            <form:option value="NONE" label="--- Select ---" />
            <form:options items="${stadiumForm.stadiums}" itemValue="name" itemLabel="name"/>
        </form:select>
        <input type="submit" value="OK" />
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    </form:form>
    </body>
</html>
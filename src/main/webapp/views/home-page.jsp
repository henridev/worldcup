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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>${title}</title>
    </head>
    <body>
    <main class="container p-4">
        <%@include file="./component/logout.jsp"%>
        <form:form
            method="POST"
            action="game"
            modelAttribute="stadiumCommand"
            class="d-flex flex-column justify-content-between align-items-center"
        >
            <%--@declare id="stadium"--%>
            <label class="p-2" for="stadium">${labelSelect}</label>
            <form:select
                path="stadiumSelected"
                class="custom-select d-block w-100 p-2 mb-4"
                id="stadium"
                required=""
            >
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${stadiumForm.stadiums}" itemValue="name" itemLabel="name"/>
            </form:select>
            <input class="p-2 w-100 btn btn-primary" type="submit" value="OK" />
        </form:form>
    </main>
    </body>
</html>
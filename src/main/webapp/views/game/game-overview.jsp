<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:message code="table.title" var="title" />
<spring:message code="table.column.nr" var="labelNr" />
<spring:message code="table.column.game" var="labelGame" />
<spring:message code="table.column.date" var="labelDate" />
<spring:message code="table.column.start" var="labelStart" />
<spring:message code="table.column.ticket" var="labelTickets" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <spring:url value="/css/style.css" var="urlCss" />
    <spring:url value="/game/" var="showDetailUrl" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="STYLESHEET" href="${urlCss}" type="text/css" />
    <title>${title}: ${stadium}</title>
</head>
    <body>
    <main class="container p-4">
        <%@include file="../component/logout.jsp"%>
        <h1>${title}: ${stadium}</h1>
        <table class="table-secondary table-striped" width="50%">
            <tr>
                <th scope="row">${labelNr}</th>
                <th>${labelGame}</th>
                <th>${labelDate}</th>
                <th>${labelStart}</th>
                <th>${labelTickets}</th>
            </tr>
            <c:forEach items="${games}" var="game">
                <tr>
                    <td scope="row"><a href="${showDetailUrl}${game.id}">${game.id}</a>
                    <td>${game.countriesNames}</td>
                    <td>${game.date}</td>
                    <td>${game.time}</td>
                    <td>${game.stadium.capacity - game.boughtTickets}</td>
                </tr>
            </c:forEach>
        </table>
    </main>
    </body>
</html>
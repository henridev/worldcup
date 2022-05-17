<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="stadium" scope="session" type="com.fifa.worldcup.controller.GameController"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <spring:url value="/css/style.css" var="urlCss" />
    <spring:url value="/game/" var="showDetailUrl" />

    <link rel="STYLESHEET" href="${urlCss}" type="text/css" />
    <title>games overview</title>
    </head>
    <body>
        <h1>Stadium: ${stadium}</h1>
        <table width="50%">
            <tr>
                <th>Nr</th>
                <th>Game</th>
                <th>Date</th>
                <th>Start</th>
                <th>Tickets</th>
            </tr>
            <c:forEach items="${games}" var="game">
                <tr>
                    <td><a href="${showDetailUrl}${game.id}">${game.id}</a>
                    <td>${game.countries}</td>
                    <td>${game.date}</td>
                    <td>${game.phone}</td>
                    <td>${game.tickets}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
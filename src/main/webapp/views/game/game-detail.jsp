<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="welcome.message" var="labelWelcome" />
<spring:message code="date.format.pattern" var="dateFormatPattern" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <spring:url value="/css/style.css" var="urlCss"/>
  <link rel="STYLESHEET" href="${urlCss}" type="text/css" />
  <title>Match details</title>
</head>
<body>
<h1>FIFA World Cup Qatar 2022</h1>
<h2>Stadium: Al bayt Stadium</h2>
<h3>Belgium vs Canada</h3>
<h3>Tickets available: 23</h3>
Today is
<fmt:formatDate value="${today}" pattern="${dateFormatPattern}" />
<form:form method="POST" action="buy" modelAttribute="TicketOrder">

  <p><label>email:</label>
    <form:input path="email" size = "20"/>&nbsp;
    <form:errors path="email" cssClass="error"/>
    <spring:bind path="email">${status.value}</spring:bind>
  </p>
  <p><label>tickets:</label>
    <form:password path="tickets" size = "20"/>&nbsp;
    <form:errors path="tickets" cssClass="error"/>
  </p>
  <p><label>soccerCode1:</label>
    <form:password path="soccerCode1" size = "20"/>&nbsp;
    <form:errors path="soccerCode1" cssClass="error"/>
  </p>
  <p><label>soccerCode2:</label>
    <form:input path="soccerCode2" size = "20"/>&nbsp;
    <form:errors path="soccerCode2" cssClass="error"/>
  </p>
  <p>
    <input type="submit" value="OK" />
  </p>

</form:form>

</body>
</html>
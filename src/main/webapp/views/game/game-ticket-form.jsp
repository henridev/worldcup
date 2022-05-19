<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="ticket.title" var="title" />
<spring:message code="ticket.stadium" var="labelStadium" />
<spring:message code="ticket.in" var="labelIn" />
<spring:message code="ticket.available" var="labelAvailable" />
<spring:message code="form.email" var="labelEmail" />
<spring:message code="form.tickets" var="labelTickets" />
<spring:message code="form.soccerCode1" var="labelSoccerCode1" />
<spring:message code="form.soccerCode2" var="labelSoccerCode2" />
<spring:message code="form.submit" var="labelButton" />
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
  <h1>${title}</h1>
  <h2>${labelStadium}: ${game.stadium.name} ${labelIn} ${game.stadium.location}</h2>
  <h3>${game}</h3>
  <h3>${labelAvailable} : ${game.stadium.capacity - game.boughtTickets}</h3>
  <form:form method="POST" action="${gameID}" modelAttribute="ticketOrderForm" cssClass="pt-3">
    <div class="mb-3 d-flex flex-row align-items-center">
      <label for="email" class="form-label w-25">${labelEmail}:</label>
      <form:input cssClass="form-control w-25" path="email" id="email" size = "20"/>&nbsp;
      <form:errors path="email" cssClass="error"/>
    </div>
    <div class="mb-3 d-flex flex-row align-items-center">
      <label for="tickets" class="form-label w-25">${labelTickets}:</label>
      <form:input cssClass="form-control w-25" path="tickets" id="tickets" size = "20"/>&nbsp;
      <form:errors path="tickets" cssClass="error"/>
    </div>
    <div class="mb-3 d-flex flex-row align-items-center">
      <label for="soccerCode1" class="form-label w-25">${labelSoccerCode1}:</label>
      <form:input cssClass="form-control w-25" path="soccerCode1"  id="soccerCode1" size = "20"/>&nbsp;
      <form:errors path="soccerCode1" cssClass="error"/>
    </div>
    <div class="mb-3 d-flex flex-row align-items-center">
      <label for="soccerCode2" class="form-label w-25">${labelSoccerCode2}:</label>
      <form:input cssClass="form-control w-25" path="soccerCode2" id="soccerCode2" size = "20"/>&nbsp;
      <form:errors path="soccerCode2" cssClass="error"/>
    </div>
    <input class="btn btn-primary" type="submit" value=${labelButton} />
    <%@include file="../component/csfr.jsp"%>
  </form:form>
</main>
</body>
</html>
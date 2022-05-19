<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="prohibited" var="title" />
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
<h1>${title}</h1>
<%@include file="../component/logout.jsp"%>
</body>
</html>
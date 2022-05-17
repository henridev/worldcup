<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <spring:url value="/css/style.css" var="urlCss"/>
    <link rel="stylesheet" href="${urlCss}" type="text/css" />
    <jsp:useBean id="_csrf" scope="request" type="org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Contentnegotiation"/>
</head>
<body>

<h1>Spring Security Custom Login Form (Annotation)</h1>

<div id="login-box">

    <h3>Login with Username and Password</h3>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
    <form action='login' method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><label>
                    <input type='text' name='username' value=''>
                </label></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><label>
                    <input type='password' name='password' />
                </label></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="submit" /></td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

    </form>
</div>

</body>
</html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Authorization</title>
</head>
<body>
<style>
    .login{
        text-align: center;
    }
    .error {
        color: crimson;
        text-align: center;
    }
</style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mine" uri="Mine" %>

    <div class="login">
        <mine:loginTag method="POST" url="/loginController"/>
    </div>
<br>
<br>
    <c:if test="${not empty requestScope.errorMessage}">
        <div class="error">
                ${requestScope.errorMessage}
        </div>
        <c:set var="errorMessage" scope="request" value="${null}"/>
    </c:if>
</body>
</html>
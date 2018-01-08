<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
  "http://www.w3.org/TR/html4/strict.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Authorization</title>
 </head>
 <body>
 <style>
  .outer {
    text-align: center;
  }
  .error {
      color: crimson;
      text-align: center;
  }
</style>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <div class="outer">
	<form method = "POST" action = "/loginController">
		<p>Login</p><input type = "text" name = "Login">
		<p>Password</p><input type = "password" name = "Password">
		<br>
		<br>
		<input type = "submit" value = "Log in">
    </form>
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
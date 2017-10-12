<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" 
  "http://www.w3.org/TR/html4/strict.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Authorization</title>
 </head>
 <style>
  .outer {
    text-align: center;
  }
  .error {
      color: crimson;
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
</div>
 <br>
 <br>
 <c:if test="${requestScope.errorMessage != null}">
     <div class="error">
     ${requestScope.errorMessage}
     </div>
 </c:if>

	</body>
</html>
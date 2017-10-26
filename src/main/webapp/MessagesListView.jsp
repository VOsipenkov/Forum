<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" 
  "http://www.w3.org/TR/html4/strict.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Typing message</title>
  </head>
	<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page pageEncoding="UTF-8"%>

	<div>
		${requestScope.message}
	</div><br>
	---------
	---------
	<br>


<div>
   <c:forEach var="mess" items="${messages}">
	   ---------------------------------<br>
	   ${mess.userName} : ${mess.message}<br>
	   ---------------------------------<br>
   </c:forEach>
</div><br><br>

	<div align = "center">
		<form action = "/addMessage" method="post">
				<textarea rows="20" cols="40" name="message">
				</textarea>
			<br>
			<input type = "submit" value = "Send">
		</form>
	</div>

	</body>
</html>
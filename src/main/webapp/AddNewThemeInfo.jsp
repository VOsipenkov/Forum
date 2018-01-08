<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="LogoutHeader.jsp"/>

<form method="post" action="/addNewTheme">
    <input type="text" name="addTheme"/><br>
    <input type="submit" value="enter"/>
</form>

</body>
</html>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/logoutHeader.jsp"/>

<form method="post" action="/themes/create">
    <input type="text" name="addTheme"/><br>
    <input type="submit" value="enter"/>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 21cmPC
  Date: 28.10.2017
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

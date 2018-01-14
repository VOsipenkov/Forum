
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% System.out.println("Redirect to list messages controller");%>
    <jsp:forward page="/messages/list"/>
</body>
</html>

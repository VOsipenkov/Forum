<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mine" uri="Mine" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
/loginView<br>
<mine:formTag method="GET" url="/loginView" inputItems="${['login', 'item2']}"/>
</body>
</html>

<html>

<head>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<c:forEach var="item" items="${requestScope.themes}">
	<div>
		<form method="get" action="/listMessagesInThemeController">
			${item.name}<br>
			<button type="submit" name="theme" value="${item.name}">
				<img
						src="https://mdn.mozillademos.org/files/2917/fxlogo.png"
						width="50"
						alt="SomeAlternateText"
				>
			</button>
		</form>
	</div><br>
</c:forEach>
</body>

</html>
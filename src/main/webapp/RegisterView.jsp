<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Sign on</title>
	<style type="text/css">
		.right
		{
			position:absolute;
			right:400px;
			width:600px;
		}
	</style>
</head>
<body>
<%@ taglib prefix="mine" uri="Mine" %>
<div class="right">
	<form method = "POST" action = "/registerController">
		<h><b>Sign on</b></h>

		<p>Name <input type = "text" name ="Name"></p>
		<p>Login <input type = "text" name = "Login"></p>
		<p>Email <input type = "email" name = "Email"></p>
		<p>Password <input type = "password" name = "Password"></p>
		<p>Confirm password <input type = "password" name = "Confirm password"></p>
		<br>
		<br>
		<input type = "submit" value = "Sign on">
	</form><hr>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logging out</title>
<link rel="stylesheet" href="registersuccess.css">
</head>
<body>
	<%
		session.invalidate();
		
	%>
	<div class="container">
		<video autoplay loop muted plays-inline class="background-clip">
			<source src="logout.mp4" type="video/mp4">
		</video>
		<div class="content">
<h3>Logged out successfully</h3>
<a href="/BankingApplication/bankx.html">Go to home</a>
</div>
</div>

</body>
</html>
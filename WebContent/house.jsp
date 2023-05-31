<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>house loan</title>
 <link rel="stylesheet" href="edu.css">
</head>
<body>
 <ul>
        <li id="ik">
            <%
	session = request.getSession();
	String name = (String) session.getAttribute("name");
	
	out.println("Dear"+" "+name);
	out.println("<br>");
	out.println("Thank you for applying for house loan");

	%>

        </li>
    </ul>
    <div class="container">
        <video autoplay loop muted plays-inline class="background-clip">
            <source src="house.mp4" type="video/mp4">
        </video>
        </div></body>
</html>
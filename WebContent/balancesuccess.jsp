<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance success</title>
<link rel="stylesheet" href="balancesuccess.css">
</head>
<body>
	    
        <ul>
            <li id="o">
	<%
		session = request.getSession();
		int bal = (int) session.getAttribute("newbal");

		out.println("<h1>The balance is</h1> :" + bal);
	%>
</li>
</ul>


    <div class="container">
        <video autoplay loop muted plays-inline class="background-clip">
            <source src="balance.mp4" type="video/mp4">
        </video>
        </div>

</body>
</html>
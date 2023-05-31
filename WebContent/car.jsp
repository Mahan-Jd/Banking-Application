<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>car loan</title>
        <link rel="stylesheet" href="car.css">
    </head>
    <body>
        <ul>
            <li id="y">
                <%
                session = request.getSession();
                String name = (String) session.getAttribute("name");
                
                out.println("Dear"+" "+name);
                out.println("<br>");
                out.println("Thank you for applying for car loan");
            
                %>

            </li>
        </ul>
        <div class="container">
            <video autoplay loop muted plays-inline class="background-clip">
                <source src="car.mp4" type="video/mp4">
            </video>
            </div>

</body>
</html>
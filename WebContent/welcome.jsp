<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="welcome.css">
  <style>
            body{
             background-image : url("99.jpg");
             background-size: auto;
             background-repeat:no-repeat ;
             background-size: cover;
             height: 800px
    
            }
           
        </style>
</head>
<body>
	<%
		session = request.getSession();
		String name = (String) session.getAttribute("name");
		int accno = (int) session.getAttribute("accno");

		out.println("<h1>Welcome" +" "+name + "</h1><br>");
		out.println("Account number:" + accno);
	
	%>
	<br><br><br>
   
    
    <div id="b"><a href="/BankingApplication/balance.html">view balance</a></div></button>
	<br><br><br>
    <div id="l"><a href="/BankingApplication/loan.html">Apply loan</a></div></button>
	<br><br><br>
    <div id="t"><a href="/BankingApplication/transfermoney.html">Transfer money</a></div></button>
	<br><br><br>
    <div id="cp"><a href="/BankingApplication/changepass.html">Change password</a></div></button>
	<br><br><br>
    <div id="cn"><a href="/BankingApplication/changename.html">Change name</a></div></button>
	<br><br><br>
    <div id="log"><a href="/BankingApplication/logout.jsp">Logout</a></div>

</body>
</html>
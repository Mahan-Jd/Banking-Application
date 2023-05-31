package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BalValidation extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			String pass= req.getParameter("pass");
			if(pass.length()==0)
			{
				res.sendRedirect("/BankingApplication/balanceerror.html");
				
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Balance").forward(req, res);
				
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	

}

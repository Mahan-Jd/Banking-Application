package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeNameVal extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			String nn = req.getParameter("nn");
			String p = req.getParameter("p");
			
			if(nn.length()==0 || p.length()==0)
			{
				res.sendRedirect("/BankingApplication/changenameerror.html");
				
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/ChangeName").forward(req, res);
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}


}

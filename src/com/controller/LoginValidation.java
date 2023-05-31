package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bank")
public class LoginValidation extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			//collect form data
			String accno = req.getParameter("accno");
			String pass = req.getParameter("pass");
			
			//basic validation
			if(pass.length()==0)
			{
				res.sendRedirect("/BankingApplication/invalid.html");
				
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Login").forward(req, res);
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

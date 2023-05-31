package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class Balance extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{
			HttpSession hs = req.getSession();
			
			//get the password from session
			String pwd = (String)hs.getAttribute("pass");
			int accno = (int)hs.getAttribute("accno");
			
			
			//get the form data
			String pass=req.getParameter("pass");
			if(pwd.equals(pass))
			{
				Model m = new Model();
				m.setAccno(accno);
				boolean status = m.viewBalance();
				int bal = m.getBalance();
				if(status==true)
				{
					hs.setAttribute("newbal", bal);
					res.sendRedirect("/BankingApplication/balancesuccess.jsp");
					
					
				}
				else
				{
					res.sendRedirect("/BankingApplication/balancefail.html");
				}
				
			}
			else
			{
				res.sendRedirect("/BankingApplication/balanceerror.html");
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

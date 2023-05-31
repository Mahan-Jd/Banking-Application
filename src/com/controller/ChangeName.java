package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class ChangeName extends HttpServlet 
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			String nn = req.getParameter("nn");
			String p = req.getParameter("p");
			
			HttpSession hs = req.getSession();
			int accno = (int)hs.getAttribute("accno");
			
			Model m = new Model();
			m.setAccno(accno);
			m.setName(nn);
			m.setPass(p);
			
			boolean status  = m.changeName();
			
			if(status==true)
			{
				res.sendRedirect("/BankingApplication/changenamesuccess.html");
				
			}
			else
			{
				res.sendRedirect("/BankingApplication/changenamefail.html");
				
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

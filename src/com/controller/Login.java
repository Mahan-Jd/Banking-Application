package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Login extends HttpServlet 
{

	public void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try
		{
			//get the formdata
			int accno = Integer.parseInt(req.getParameter("accno"));
			String pass = req.getParameter("pass");

			//connect with model
			Model m = new Model();
			
			//send the data to model
			m.setAccno(accno);
			m.setPass(pass);
			
			boolean status = m.login();
			
			if(status==true)
			{
				//login successfull
				int a = m.getAccno();
				String b = m.getName();
				String c = m.getPass();
				String d = m.getEmail();
				int e = m.getBalance();
				
				
				//create session
				
				HttpSession hs = req.getSession(true);
				
				//store the data in session
				hs.setAttribute("accno", a);
				hs.setAttribute("name", b);
				hs.setAttribute("pass", c);
				hs.setAttribute("email", d);
				hs.setAttribute("balance", e);

                //send the control to welcome.jsp if the details are correct
				res.sendRedirect("/BankingApplication/welcome.jsp");

				
			}
			else
			{
				//login details are in correct
				res.sendRedirect("/BankingApplication/incorrect.html");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();		
		}

	}


}

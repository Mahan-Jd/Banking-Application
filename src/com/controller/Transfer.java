package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Transfer extends HttpServlet
{

	public void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try
		{
			int taccno=Integer.parseInt(req.getParameter("taccno"));
    		int amount  = Integer.parseInt(req.getParameter("amount"));
    		
    		HttpSession hs = req.getSession();
    		int accno = (int)hs.getAttribute("accno");
    		
    		Model m = new Model();
    		m.setAccno(accno);
    		
    		boolean status1 = m.viewBalance();
    		if(status1==true)
    		{
    			int bal = m.getBalance();
    			if(bal>amount)
    			{
    				
					boolean status2 = m.transfer(amount, taccno);
					if(status2==true)
					{
						res.sendRedirect("/BankingApplication/transfersuccess.html");
					}
					else
					{
						res.sendRedirect("/BankingApplication/transferfail.html");
						
					}
    				
    			}
    			else
    			{
    				res.sendRedirect("/BankingApplication/transferfail.html");
					
    				
    			}
    			
    		}
    		else
    		{
    			res.sendRedirect("/BankingApplication/transferfail.html");
				
    		}
    		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}

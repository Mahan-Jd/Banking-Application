package com.model;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Model 
{
	private int accno;
	private String name;
	private String pass;
	private String email;
    int balance;
	
	public int getAccno() 
	{
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	String path = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String pa="system";
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	public  Model()
	{
		try
		{
			Class.forName(path);
			con = DriverManager.getConnection(url, user, pa);
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public boolean login()
	{
		try
		{
			String query="	SELECT * from SEPTBANK where accno=? and pass=?";
			
			//create the medium
			pstmt = con.prepareStatement(query);
			
			//setting the values
			
			pstmt.setInt(1, accno);
			pstmt.setString(2, pass);
			
			//execute the query
			rs = pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				accno=rs.getInt(1);
				name=rs.getString(2);
				pass=rs.getString(3);
				email=rs.getString(4);
				balance=rs.getInt(5);
				
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean viewBalance()
	{
		try
		{
			String sql= "select  balance from septbank where accno=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accno);
			rs = pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				balance=rs.getInt("balance");
				return true;
				
			}
			else
			{
				return false;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean changePwd(String np)
	{
		try 
		{
			String sql="update septbank set pass=? where accno=? and pass=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, np);
			pstmt.setInt(2, accno);
			pstmt.setString(3, pass);
			
			int row = pstmt.executeUpdate();
			
			if(row==0)
			{
				return false;
				
			}
			else
			{
				return true;
				
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeName()
	{
		try
		{
			String sql="update septbank set name=? where accno=? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, accno);
			pstmt.setString(3, pass);
			
			int row = pstmt.executeUpdate();
			
			if(row==0)
			{
				return false;
				
			}
			else
			{
				return true;
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean register()
	{
		try 
		{
			String sql = "insert into septbank values (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,accno);
			pstmt.setString(2, name);
			pstmt.setString(3, pass);
			pstmt.setString(4, email);
			pstmt.setInt(5, balance);
			
			int row = pstmt.executeUpdate();
			
			
			if(row==0)
			{
				return false;
				
			}
			else
			{
				return true;
			}
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean transfer(int amount,int taccno)
	{
		try 
		{
			String sql1 ="update septbank set balance = balance-? where accno=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, accno);
			int row1 = pstmt.executeUpdate();
			
			String sql2 ="update septbank set balance = balance+? where accno=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, taccno);
			int row2 = pstmt.executeUpdate();
			
			
			if(row1==0 || row2==0)
			{
				return false;
				
			}
			else
			{
				return true;
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean forgotPassword(String np)
	{
		try
		{
			String sql = "update septbank set pass=? where accno=? and name=? and email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,np);
			pstmt.setInt(2, accno);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			int row = pstmt.executeUpdate();
			
			if(row==0)
			{
				return false;
				
			}
			else
			{
				return true;
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
}


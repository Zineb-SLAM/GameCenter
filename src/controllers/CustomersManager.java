package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;  


/**
 * Servlet implementation class CustomersManager
 */
//@WebServlet("/echocust")
public class CustomersManager extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersManager() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		 
		// TODO Auto-generated method stub
		 response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	      out.println("<Hello Get\n>");
	      // Allocate a output writer to write the response message into the network socket
	      // Write the response message, in an HTML page
	     
	      try 
	      {
	         out.println("<body><h2>You have entered</h2>");
	 
	         // Retrieve the value of the query parameter "username" (from text field)
	         String username = request.getParameter("username");
	         // Get null if the parameter is missing from query string.
	         // Get empty string or string of white spaces if user did not fill in
	         if (username == null
	               || (username = htmlFilter(username.trim())).length() == 0) {
	            out.println("<p>Name: MISSING</p>");
	         } else {
	            out.println("<p>Name: " + username + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "password" (from password field)
	         String password = request.getParameter("password");
	         if (password == null
	               || (password = htmlFilter(password.trim())).length() == 0) {
	            out.println("<p>Password: MISSING</p>");
	         } else {
	            out.println("<p>Password: " + password + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "gender" (from radio button)
	         String gender = request.getParameter("gender");
	         // Get null if the parameter is missing from query string.
	         if (gender == null) 
	         {
	            out.println("<p>Gender: MISSING</p>");
	         } else if (gender.equals("m")) 
	         {
	            out.println("<p>Gender: male</p>");
	         } else 
	         {
	            out.println("<p>Gender: female</p>");
	         }
	           
	       doPost(request, response);
	      } finally 
	      {
	         out.close();  // Always close the output writer
	      }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();

			try 
			{	
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/SR03","root","YASSINE97"); 
				if(con == null)
				{
					response.getWriter().append("CONNECTION TO DB FAILED \n");
					
				}
				DBTablePrinter.printTable(con, "CUSTOMERS");
				/*Statement stmt=con.createStatement();  
				ResultSet res=stmt.executeQuery("SELECT * from CUSTOMERS");
				ResultSetMetaData rsmd = res.getMetaData();
				int columnsNumber = rsmd.getColumnCount();                     

				while (res.next()) 
				{
					
					for(int i = 1 ; i <= columnsNumber; i++)
					{

						  out.println(
		                			 res.getInt("id") +  "\t" + 
		                             res.getString("lastname") + "\t" +
		                             res.getString("firstname") + "\t" +
		                             res.getString("gender") + "\t" +
		                             res.getString("username") + "\t" +
		                             res.getString("email") + "\t" +
		                             res.getString("password"));
		                             res.getString("\n"); //Print one element of a row

					}

					  System.out.println();//Move to the next line to print the next row.           

			    }*/
		
	              
				out.println("Done");
				con.close();  
						
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	 // Filter the string for special HTML characters to prevent
	   // command injection attack
	   private static String htmlFilter(String message) 
	   {
	      if (message == null) return null;
	      int len = message.length();
	      StringBuffer result = new StringBuffer(len + 20);
	      char aChar;
	 
	      for (int i = 0; i < len; ++i) {
	         aChar = message.charAt(i);
	         switch (aChar) {
	             case '<': result.append("&lt;"); break;
	             case '>': result.append("&gt;"); break;
	             case '&': result.append("&amp;"); break;
	             case '"': result.append("&quot;"); break;
	             default: result.append(aChar);
	         }
	      }
	      return (result.toString());
	   }

}

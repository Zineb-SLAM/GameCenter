package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import dao.CustomersDao; 

/**
 * Servlet implementation class CustomersManager
 */

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
		response.setContentType("text/html; charset=UTF-8");
		
		
	    List<Customer> listC = null;
	    
		 
		listC =  CustomersDao.findAll();
		request.setAttribute("CustomersList", listC);
		
		
		// Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CustomersListView.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		   String id = (String) request.getParameter("id");
		 
		    CustomersDao.delete(id);
		 

		    List<Customer> listC = null;
		    
			 
			listC =  CustomersDao.findAll();
			request.setAttribute("CustomersList", listC);
			
			
			// Forward to /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CustomersListView.jsp");
	        dispatcher.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	    
						
	}
	
	

	
	
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

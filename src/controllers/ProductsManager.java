package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsManager
 */
@WebServlet("/ProductsManager")
public class ProductsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
							return;
						}
							
						
						Statement stmt=con.createStatement();  
						ResultSet res=stmt.executeQuery("SELECT PRODUCTS.name as name, PRODUCTS.maingenre as genre, GAMETYPES.name as console, PRODUCTS.agemin as agemin, PRODUCTS.price as price,"
								+ " PUBLISHERS.name as publisher, PRODUCTS.releasedate as releasedate FROM PRODUCTS, PUBLISHERS, GAMETYPES "
								+ "WHERE PRODUCTS.gametypeid = GAMETYPES.id AND PRODUCTS.publisherid = PUBLISHERS.id");
					
						while (res.next()) 
						{
								  out.println(
				                			 res.getString("name") + "\t" +
				                			 res.getString("genre") + "\t" +
				                			 res.getString("console") + "\t" +
				                			 res.getString("publisher") + "\t" +
				                			 res.getDate("releasedate") + "\t" +
				                			 res.getInt("agemin") + "\t" +
				                			 res.getFloat("price")); 
				                            
				                           
				                           
				                            // out.println("\n");//Move to the next line to print the next row.           
					    }
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

}

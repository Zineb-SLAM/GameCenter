package controllers;
import beans.Customer;
import dao.CustomersDao; 

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomersDelete
 */
@WebServlet("/CustomersDelete")
public class CustomersDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

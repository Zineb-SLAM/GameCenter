package beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserBean
 */
@WebServlet("/UserBean")
public class UserBean extends HttpServlet 
{
	private String username; /* the same as the one we had at index.jsp --> response.jsp affects one(from index)
	to the other (in userbean attribute) with jsp::setproperty or jsp::getproperty, scope session means that the object
	is available as long as the session is open, we set prperty=* means got look for attributes in the UserBean class
	as well as the implicit ones. the second getproperty is only to print*/
   
    public UserBean() 
    {
        username="";
        // TODO Auto-generated constructor stub
    }
	
	public String getUsername()
	{
		return username;
	}

	


}

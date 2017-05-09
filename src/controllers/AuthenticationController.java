package controllers;

//import org.json.simple.JSONObject;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
import beans.Customer;
import dao.CustomersDao;

@Path("/auth")
public class AuthenticationController {

	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer register(@FormParam("gender") String gender, @FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("email") String email, 
			@FormParam("username") String username,
			@FormParam("pwd") String pwd) {
		try {
				return CustomersDao.create(gender, first_name, last_name, email, username, pwd);
		}
		catch (Exception e) {
			return new Customer();	
		}
	}
	
	@POST
	@Path("/login") // To be tested
	@Produces(MediaType.APPLICATION_JSON)
	public Customer login(@FormParam("username") String username, @FormParam("email") String email, @FormParam("pwd") String pwd){
		try {
			Customer customer = CustomersDao.findUsername(username);
			if (customer.getPwd() == pwd)
				return customer;
			else
				return new Customer();
		} catch (Exception e) {
			return new Customer(); // TODO: Set a real error handler
		}
		
	}
}

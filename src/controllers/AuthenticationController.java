package controllers;

//import org.json.simple.JSONObject;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
import beans.Customer;
import dao.CustomersDao;

@Path("/auth")
public class AuthenticationController {

	
	//@GET
	//@Path("/register")
	//@Produces(MediaType.APPLICATION_JSON)
	//public Customer register(@QueryParam("gender") String gender, @QueryParam("first_name") String first_name,
	//		@QueryParam("last_name") String last_name,
	//		@QueryParam("email") String email, 
	//		@QueryParam("username") String username,
	//		@QueryParam("pwd") String pwd) {
	//	try {
	//			return CustomersDao.create(gender, first_name, last_name, email, username, pwd);
	//	}
	//	catch (Exception e) {
	//		return new Customer();	
	//	}
	//}
	
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer register(@PathParam("gender") String gender, @PathParam("first_name") String first_name,
			@PathParam("last_name") String last_name,
			@PathParam("email") String email, 
			@PathParam("username") String username,
			@PathParam("pwd") String pwd) {
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
	public Customer login(@QueryParam("username") String username, @QueryParam("email") String email, @QueryParam("pwd") String pwd){
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

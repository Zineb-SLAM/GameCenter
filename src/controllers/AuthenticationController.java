package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam; 
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
		
		return CustomersDao.create_customer(5 ,gender, first_name, last_name, email, username, pwd);
	}
}

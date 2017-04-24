package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
import beans.Customer;
import dao.CustomersDao;

@Path("/customers") 

public class CustomersController {
	@GET 
	@Path("/users") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Customer> getCustomers(){ 
	      return CustomersDao.findAll();
	}  
}

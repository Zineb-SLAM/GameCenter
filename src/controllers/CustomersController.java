package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
import beans.Customer;
import dao.CustomersDao;
import services.NeedAuthentication;
//import controllers.GameCenterServer;


@Path("/customers") 
public class CustomersController {
	@GET 
	@Path("")
	@NeedAuthentication
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Customer> getCustomers()
	{ 
	      return CustomersDao.findAll();

			
	} 
	

	@GET 
	@Path("/{sort}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Customer> getCustomers(@PathParam("sort") String sort)
	{ 

			return CustomersDao.findAll(sort);
			
	} 
		
	@GET 
	@Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Customer getCustomerId(@PathParam("id") int id)
	{
		return CustomersDao.findId(id);
		
	}
	
//	@GET 
//	@Path("/{id}") 
//	@Produces(MediaType.APPLICATION_JSON) 
//	public List<Customer> deleteCustomer(@PathParam("id") String id)
//	{
//		CustomersDao.delete(id);
//		return CustomersDao.findAll();
//	}
	
//	@GET
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Customer getCustomer(@PathParam("")){
//		return
//	}
	
	
	//@GET 
	//@Path("/{username}") 
	//@Produces(MediaType.APPLICATION_JSON) 
	//public Customer deleteCustomer(@PathParam("username") String username)
	//{
		//return CustomersDao.findUsername(username);
		
	//}
}

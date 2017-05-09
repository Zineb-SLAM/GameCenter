package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import beans.Address;
import beans.Customer;
import dao.AddressesDao;
import dao.CustomersDao;
import services.NeedAuthentication;
import controllers.GameCenterServer;

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
}

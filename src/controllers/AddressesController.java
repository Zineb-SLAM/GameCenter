package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.FormParam; 
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import com.sun.istack.internal.NotNull;

import beans.Address;
import beans.Customer;
import dao.AddressesDao;
import dao.CustomersDao;

@Path("/customers/{customer_id}/addresses") 

public class AddressesController {
	

	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddresses(@PathParam("customer_id") int customer_id) throws Exception
	{ 
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
	      return AddressesDao.findCustAddresses(cust, -1);
		}
	} 
	
	
	@GET 
	@Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddress(@PathParam("customer_id") int customer_id, @PathParam("id") int id) throws Exception
	{ 
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			return AddressesDao.findCustAddresses(cust, id);
		}
	} 
	
	
	@DELETE 
	@Path("{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> deleteAddress(@PathParam("customer_id") int customer_id, @PathParam("id") int id) throws Exception
	{
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			AddressesDao.delete(cust, id);
			return AddressesDao.findCustAddresses(cust, -1);
		}
	}
	
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> addAddress(@PathParam("id") int idcust,  @NotNull @FormParam("address") 
			String address, @NotNull @FormParam("zipcode") String zipcode, 
			@NotNull @FormParam("city") String city, @NotNull @FormParam("country") String country,
			@NotNull @FormParam("type") String type) throws Exception
	{	
		
		if(!CustomersDao.exists(idcust))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ idcust);
		}
		else
		{
			Customer cust = CustomersDao.findId(idcust);
			boolean res =  AddressesDao.add(address, zipcode, city, country, type, cust);
			return AddressesDao.findCustAddresses(cust, -1);
		}
	}
	

	
	@PUT 
	@Path("/{id}/edit") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> editAddress(@NotNull @PathParam("customer_id") int customer_id, @NotNull @FormParam("id") int id,
			 @FormParam("address") String address) 
			throws Exception
	{	
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			AddressesDao.edit(cust, id,address);
			return AddressesDao.findCustAddresses(cust, -1);
		}
	}
	
};

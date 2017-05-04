package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam; 
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import com.sun.istack.internal.NotNull;

import beans.Address;
import dao.AddressesDao;

@Path("/customers/{customer_id}/addresses") 

public class AddressesController {
	

	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddresses(@PathParam("customer_id") int customer_id) throws Exception
	{ 
	      return AddressesDao.findCustAddress(customer_id, -1);
	} 
	
	
	@GET 
	@Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddress(@PathParam("customer_id") int customer_id, @PathParam("id") int id) throws Exception
	{ 
		 System.out.print(customer_id + ", " + id);
	     return AddressesDao.findCustAddress(customer_id, id);
	} 
	
	
	@DELETE 
	@Path("{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> deleteAddress(@PathParam("customer_id") int customer_id, @PathParam("id") int id) throws Exception
	{
		AddressesDao.delete(customer_id, id);
		return AddressesDao.findCustAddress(customer_id, -1);
	}
	
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> addAddress(@PathParam("id") int idcust, @NotNull @FormParam("address") String address, @NotNull @FormParam("zipcode") String zipcode, 
			@NotNull @FormParam("city") String city, @NotNull @FormParam("country") String country, @NotNull @FormParam("type") String type) throws Exception
	{	
		boolean res =  AddressesDao.add(address, zipcode, city, country, type, idcust);
		return AddressesDao.findCustAddress(idcust, -1);
	}
	

	
	@PUT 
	@Path("/{id}/edit") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> editAddress(@NotNull @PathParam("customer_id") int customer_id, @NotNull @FormParam("id") int id,
			 @FormParam("address") String address) 
			throws Exception
	{	
		AddressesDao.edit(customer_id, id,address);
		return AddressesDao.findCustAddress(customer_id, -1);
	}
	
};

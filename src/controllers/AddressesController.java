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

import org.json.simple.JSONObject;

import com.sun.istack.internal.NotNull;

import beans.Address;
import beans.Customer;
import dao.AddressesDao;
import dao.CustomersDao;

@Path("/customers/{customer_id}/addresses") 

public class AddressesController {

//	@GET 
//	@Path("") 
//	@Produces(MediaType.APPLICATION_JSON) 
//	public List<Address> getAddresses(@PathParam("customer_id") int customer_id) throws Exception
//	{ 
//		if(!CustomersDao.exists(customer_id))
//		{
//			throw new Exception("ERROR: Insertion failed, customer not found "+ customer_id);
//		}
//		else
//		{
//			Customer cust = CustomersDao.findId(customer_id);
//	      return AddressesDao.findCustAddresses(cust, -1);
//		}
//	}
	
	@GET 
	@Path("shipping") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getShippingAddresses(@PathParam("customer_id") int customer_id) throws Exception
	{ 
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
	      return AddressesDao.findCustAddresses(cust, -1, "shipping");
		}
	}
	
	@GET 
	@Path("billing") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getBillingAddresses(@PathParam("customer_id") int customer_id) throws Exception
	{ 
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
	      return AddressesDao.findCustAddresses(cust, -1, "billing");
		}
	}
//	
//	
	@GET 
	@Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Address getAddress(@PathParam("customer_id") int customer_id, @PathParam("id") int id) throws Exception
	{ 
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			return AddressesDao.findCustAddresses(cust, id, "ignore_type").get(0);
		}
	} 
	
	
	@DELETE 
	@Path("{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public JSONObject deleteAddress(@PathParam("customer_id") int customer_id, @PathParam("id") int id) throws Exception
	{
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			JSONObject json = new JSONObject();
			json.put("deleted", AddressesDao.delete(cust, id));
			return json;
		}
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Address addAddress(@PathParam("customer_id") int idcust,  @NotNull @FormParam("address") 
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
			return AddressesDao.add(address, zipcode, city, country, type, cust);
		}
	}
//	
//
//	
	@PUT 
	@Path("/{id}/update") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Address editAddress(@PathParam("customer_id") int customer_id, @NotNull @PathParam("id") int id, @NotNull @FormParam("address") 
	String address, @NotNull @FormParam("zipcode") String zipcode, 
	@NotNull @FormParam("city") String city, @NotNull @FormParam("country") String country,
	@NotNull @FormParam("type") String type)
			throws Exception
	{	
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			return AddressesDao.update(cust, id ,address, zipcode, city, country, type);
		}
	}
	
};

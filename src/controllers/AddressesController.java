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

@Path("/customers/{id}/addresses") 

public class AddressesController {
	

	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddresses(@PathParam("id") int idcust) throws Exception
	{ 
	      return AddressesDao.findCustAddress(idcust, -1);
	} 
	
	
	@GET 
	@Path("/{idadd}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddress(@PathParam("id") int idcust, @PathParam("idadd") int idadd) throws Exception
	{ 
	      return AddressesDao.findCustAddress(idcust, idadd);
	} 
	
	
	@DELETE 
	@Path("/delete/{idadd}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> deleteAddress(@PathParam("id") int idcust, @PathParam("idadd") int idadd) throws Exception
	{
		AddressesDao.delete(idcust, idadd);
		return AddressesDao.findCustAddress(idcust, -1);
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> addAddress(@PathParam("id") int idcust, @NotNull @FormParam("address") String address, @NotNull @FormParam("zipcode") String zipcode, 
			@NotNull @FormParam("city") String city, @NotNull @FormParam("country") String country, @NotNull @FormParam("type") String type) throws Exception
	{	
		boolean res =  AddressesDao.add(address, zipcode, city, country, type, idcust);
		return AddressesDao.findCustAddress(idcust, -1);
	}
	

	
	@PUT 
	@Path("/edit/") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> editAddress(@NotNull @PathParam("id") int idcust, @NotNull @FormParam("idaddress") int idaddress,
			 @FormParam("address") String address) 
			throws Exception
	{	
		AddressesDao.edit(idcust, idaddress,address);
		return AddressesDao.findCustAddress(idcust, -1);
	}
	
};

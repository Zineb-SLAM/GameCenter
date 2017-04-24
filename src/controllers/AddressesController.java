package controllers;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
import beans.Address;
import dao.AddressesDao;

@Path("/addresses") 

public class AddressesController {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Address> getAddress()
	{ 
	      return AddressesDao.findAll();
	} 
	
	
	public List<Address> deleteAddress(int id)
	{
		
		return AddressesDao.findAll();
	}
}

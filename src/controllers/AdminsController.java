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

import beans.Admin;
import beans.Customer;
import beans.Product;
import dao.AdminsDao;
import dao.CustomersDao;
import dao.ProductsDao;

@Path("/admins") 

public class AdminsController 
{
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Admin> getAddresses() throws Exception
	{ 
	      return AdminsDao.findAll();
	} 
	
	@GET 
	@Path("/customers/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Admin getAddresses(@PathParam("id") int id) throws Exception
	{ 
	      return AdminsDao.find(id);
	} 
	
	@GET 
	@Path("/customers")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Customer> getCustomers()
	{ 
	      return CustomersDao.findAll();
	} 
	
	@DELETE
	@Path("/products/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Product> deleteProduct(@PathParam("id")int id)
	{
		ProductsDao.delete(id);
		return ProductsDao.findAll();
	}
	
	
	@POST
	@Path("/products/create")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> addAddress(@FormParam("name") String name, @FormParam("genre") String genre, 
			@FormParam("publisher") String publisher,
			@FormParam("agemin") int agemin, @FormParam("console") String console, 
			@FormParam("day") String day, @FormParam("month") String month, @FormParam("year") String year,
			@FormParam("price") float price,
			@FormParam("quantity") int quantity, @FormParam("description") String description) throws Exception
	{	
		//add(String name, String genre, String publisher, int agemin, String console, String date,
		//float price, int quantity, String description)
		String date = year + "-" + month + "-" + day;
		 ProductsDao.add(name, genre, publisher, agemin, console, date, price, quantity, description);
		return ProductsDao.findAll();
	}
	
	@PUT
	@Path("/products/update")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> editPrice(@NotNull @FormParam("id") int id, @FormParam("name") String name,
			@FormParam("quantity") int quantity, @FormParam("price") int price, 
			@FormParam("maingenre") String maingenre, @FormParam("agemin") int agemin, 
			@FormParam("console") String console, @FormParam("publisher") String publisher,  
			@FormParam("description") String description )
	{
		
		if(name != null)
		{
			ProductsDao.editName(id, name);
		}
		if(quantity >= 0)
		{
			ProductsDao.editQuantity(id, quantity);
		}
		if(price > 0)
		{
			ProductsDao.editPrice(id, price);
		}
		if(maingenre != null)
		{
			ProductsDao.editMaingenre(id, maingenre);		
		}
		if(agemin > 0)
		{
			ProductsDao.editAgemin(id, agemin);
		}
		if(console != null)
		{
			ProductsDao.editConsole(id, console);
		}
		if(publisher != null)
		{
			ProductsDao.editPublisher(id, publisher);
		}
			
		return ProductsDao.findAll();
	}
}

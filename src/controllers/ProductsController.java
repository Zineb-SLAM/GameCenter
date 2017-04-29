package controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import beans.Address;
import beans.Product;
import dao.AddressesDao;
import dao.ProductsDao;

@Path("/products") 

public class ProductsController {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Product> getProduct()
	{ 
	      return ProductsDao.findAll();
	} 
	
	@GET 
	@Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Product getProduct(@PathParam("id") int id)
	{ 
	     return ProductsDao.find(id);
	} 
	
	@GET 
	@Path("/{feature}/{name}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Product> getProduct(@PathParam("feature") String feature, @PathParam("name") String name)
	{ 
		switch(feature)
		{
			case "name":
			{
				return ProductsDao.findName(name); 
			}
			
			case "genre":
			{
				return ProductsDao.findGenre(name); 
			}
			
			case "publisher":
			{
				return ProductsDao.findPublisher(name); 
			}
			
			case "console":
			{
				return ProductsDao.findConsole(name); 
			}
			
			case "description":
			{
				return ProductsDao.findDesc(name); 
			}
		}
		
		return ProductsDao.findAll();
	     
	}
	
	
	@DELETE
	@Path("/delete/{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Product> deleteProduct(@PathParam("id")int id)
	{
		ProductsDao.delete(id);
		return ProductsDao.findAll();
	}
	
	
	@POST
	@Path("/add")
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
	
}

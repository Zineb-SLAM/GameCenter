package controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import com.sun.istack.internal.NotNull;

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
}

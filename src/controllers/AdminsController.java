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
import dao.AdminsDao;

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
	@Path("{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Admin getAddresses(@PathParam("id") int id) throws Exception
	{ 
	      return AdminsDao.find(id);
	} 
	
	
}

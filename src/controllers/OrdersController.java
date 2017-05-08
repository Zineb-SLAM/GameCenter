package controllers;

import java.util.List; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import beans.Order;
import beans.Customer;
import dao.CustomersDao;
import dao.OrderDao;

@Path("/customers/{customer_id}/orders")

public class OrdersController {
	@GET 
	@Path("") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Order> getCustomers(@PathParam("customer_id") int customer_id)
	{ 
		Customer customer = CustomersDao.findId(customer_id);
		System.out.print("Customer: ------------ " + customer.getFirstname() + "--------------");
	    try {
	    	List<Order> list = OrderDao.findAll(customer);
	    	return list;
	    } catch (Exception e){
	    	e.printStackTrace();
	    	return null;
	    }
		
	}
	
	@GET // TODO: Mettre en POST
	@Path("/pay")
	@Produces(MediaType.APPLICATION_JSON)
	public Order createOrder(@PathParam("customer_id") int customer_id, @QueryParam("payment_id") int payment_id) throws Exception{
		Customer customer = CustomersDao.findId(customer_id);
		Order order = OrderDao.findOrCreateCart(customer, false);
		return OrderDao.payOrder(customer, order, payment_id);
	}
	
}

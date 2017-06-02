package controllers;

import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import dao.CustomersDao;
import dao.OrderDao;
import beans.Order;
import beans.OrderLine;
import dao.OrderLineDao;

@Path("/customers/{customer_id}/current_cart")

public class OrderLinesController {
	
	@POST // TODO: Mettre en POST
	@Path("/add_to_cart")
	@Produces(MediaType.APPLICATION_JSON)
	public Order addOrderLine(@PathParam("customer_id") int customer_id, @FormParam("product_id") int product_id, @FormParam("quantity") int quantity) {
		Customer customer;
		Order order;
		try{
			customer = CustomersDao.findId(customer_id);
			order = OrderDao.findOrCreateCart(customer, true);
			return OrderLineDao.addToCart(order, product_id, quantity);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	@GET
	@Path("/cart")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getCart(@PathParam("customer_id") int customer_id) {
		try{
			Customer customer = CustomersDao.findId(customer_id);
			Order order = OrderDao.findOrCreateCart(customer, true);
			return order;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/*** TODO: Update This method***/
	@DELETE
	@Path("order_lines/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order removeFromCart(@PathParam("customer_id") int customer_id, @PathParam("id") int order_line_id) throws Exception {
		Customer customer;
		Order order;
		try{
			customer = CustomersDao.findId(customer_id);
			order = OrderDao.findOrCreateCart(customer, false);
			OrderLine order_line = OrderLineDao.findId(order, order_line_id);
			return OrderLineDao.removeOrderLine(order_line, order);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}

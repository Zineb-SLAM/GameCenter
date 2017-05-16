package controllers;

import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import dao.CustomersDao;
import dao.OrderDao;
import beans.Order;
import beans.OrderLine;
import dao.OrderLineDao;

@Path("/customers/{customer_id}/orders/current_cart")

public class OrderLinesController {

	
	@POST // TODO: Mettre en POST
	@Path("/add_to_cart")
	@Produces(MediaType.APPLICATION_JSON)
	public String addOrderLine(@PathParam("customer_id") int customer_id, @FormParam("product_id") int product_id, @FormParam("quantity") int quantity) {
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
	
	
	@DELETE
	@Path("order_lines/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeFromCart(@PathParam("customer_id") int customer_id, @PathParam("id") int order_line_id) throws Exception {
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

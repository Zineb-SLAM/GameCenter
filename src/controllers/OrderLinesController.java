package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import dao.CustomersDao;
import dao.OrderDao;
import dao.OrderLineDao;

@Path("/customers/{customer_id}/orders/{order_id}/order_lines")

public class OrderLinesController {

	
	@GET // TODO: Mettre en POST
	@Path("/add_to_cart")
	@Produces(MediaType.APPLICATION_JSON)
	public String addOrderLine(@PathParam("order_id") int order_id, @QueryParam("product_id") int product_id, @QueryParam("quantity") int quantity) throws Exception{
		return OrderLineDao.addToCart(order_id, product_id, quantity);
	}
}

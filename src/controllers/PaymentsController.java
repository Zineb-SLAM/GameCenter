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

import beans.Payment;
import dao.PaymentsDao;

@Path("/customers/{customer_id}/payments") 

public class PaymentsController 
{
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	/*Payment(int id, String t, String nb, String c, int idcust, String fname, String lname, 
	 * String gender, String email, String username, String pwd)*/
	public List<Payment> getPayments(@NotNull @PathParam("customer_id") int customer_id ) throws Exception
	{
		return PaymentsDao.findCustPayments(customer_id, -1);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	/*Payment(int id, String t, String nb, String c, int idcust, String fname, String lname, 
	 * String gender, String email, String username, String pwd)*/
	public List<Payment> getPayments(@NotNull @PathParam("customer_id") int customer_id, 
			@NotNull @PathParam("idp") int payment_id)
	throws Exception
	{
		return PaymentsDao.findCustPayments(customer_id, payment_id);
	}
	
	

	@DELETE 
	@Path("{id}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Payment> deletePayment(@NotNull @PathParam("id") int idcust, @NotNull @PathParam("idpay") int idpay) throws Exception
	{
		PaymentsDao.delete(idcust, idpay);
		return PaymentsDao.findCustPayments(idcust, -1);
	}
	
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> editPayment(@NotNull @PathParam("id") int idcust, @NotNull @FormParam("idpay") int idpay, 
			@FormParam("pan") String pan, @NotNull @FormParam("cvv") String cvv,
			@NotNull @FormParam("month") int month, @NotNull @FormParam("year") int year) throws Exception
	{
		if(pan != null)
		{
			PaymentsDao.editPan(idcust, idpay, pan);
		}
		if(cvv != null)
		{
			PaymentsDao.editCvv(idcust, idpay, cvv);
		}
		if(month<12 && year!=9999 && year>2017 && month>0)
		{
			PaymentsDao.editExpiration(idcust, idpay, month, year);
		}
		return PaymentsDao.findCustPayments(idcust, idpay);
	}
	
	

	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> addPayment(@NotNull @PathParam("id") int idcust, 
			@FormParam("type") String type, @FormParam("pan") String pan,
			@FormParam("cvv") String cvv, @FormParam("day") String day, 
			@FormParam("month") int month, @FormParam("year") int year) throws Exception
	{
		PaymentsDao.add(type, pan, cvv, month, year, idcust);
		
		return PaymentsDao.findCustPayments(idcust, -1);
		
	}
}
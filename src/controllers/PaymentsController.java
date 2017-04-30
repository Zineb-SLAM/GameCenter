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

@Path("/customers/{id}/payments") 

public class PaymentsController 
{
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	/*Payment(int id, String t, String nb, String c, int idcust, String fname, String lname, 
	 * String gender, String email, String username, String pwd)*/
	public List<Payment> getPayments(@NotNull @PathParam("id") int id ) throws Exception
	{
		return PaymentsDao.findCustPayments(id, -1);
	}
	
	@GET
	@Path("/{idp}")
	@Produces(MediaType.APPLICATION_JSON)
	/*Payment(int id, String t, String nb, String c, int idcust, String fname, String lname, 
	 * String gender, String email, String username, String pwd)*/
	public List<Payment> getPayments(@NotNull @PathParam("id") int idcust, @NotNull @PathParam("idp") int idp)
	throws Exception
	{
		return PaymentsDao.findCustPayments(idcust, idp);
	}
	
	

	@DELETE 
	@Path("/delete/{idpay}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Payment> deletePayment(@NotNull @PathParam("id") int idcust, @NotNull @PathParam("idpay") int idpay) throws Exception
	{
		PaymentsDao.delete(idcust, idpay);
		return PaymentsDao.findCustPayments(idcust, -1);
	}
	
	
	@PUT
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> editPayment(@NotNull @PathParam("id") int idcust, @NotNull @FormParam("idpay") int idpay, 
			@FormParam("pan") String pan, @NotNull @FormParam("cvv") String cvv,
			@NotNull @FormParam("expiration") String expiration) throws Exception
	{
		if(pan != null)
		{
			PaymentsDao.editPan(idcust, idpay, pan);
		}
		if(cvv != null)
		{
			PaymentsDao.editCvv(idcust, idpay, cvv);
		}
		if(expiration!=null)
		{
			
		}
		return PaymentsDao.findCustPayments(idcust, idpay);
	}
	
	

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> addPayment(@NotNull @PathParam("id") int idcust, 
			@FormParam("type") String type, @FormParam("pan") String pan,
			@FormParam("cvv") String cvv, @FormParam("expiration") String expiration) throws Exception
	{
		PaymentsDao.add(type, pan, cvv, expiration, idcust);
		
		return PaymentsDao.findCustPayments(idcust, -1);
		
	}
}
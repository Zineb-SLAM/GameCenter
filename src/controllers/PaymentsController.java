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
import beans.Customer;
import dao.CustomersDao;
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
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			return PaymentsDao.findCustPayments(cust, -1);
		}
	}	
	
	@GET
	@Path("/{idpay}")
	@Produces(MediaType.APPLICATION_JSON)
	/*Payment(int id, String t, String nb, String c, int idcust, String fname, String lname, 
	 * String gender, String email, String username, String pwd)*/
	public List<Payment> getPayments(@NotNull @PathParam("customer_id") int customer_id, 
			@NotNull @PathParam("idpay") int payment_id)
	throws Exception
	{
		
		if(!CustomersDao.exists(customer_id))
		{
			throw new Exception("ERROR: customer not found "+ customer_id);
		}
		else
		{
			Customer cust = CustomersDao.findId(customer_id);
			return PaymentsDao.findCustPayments(cust, payment_id);
		}
		
		
	}
	
	

	@DELETE 
	@Path("{idpay}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Payment> deletePayment(@NotNull @PathParam("id") int idcust, @NotNull @PathParam("idpay") int idpay) throws Exception
	{
		
		if(!CustomersDao.exists(idcust))
		{
			throw new Exception("ERROR: customer not found "+ idcust);
		}
		else
		{
			Customer cust = CustomersDao.findId(idcust);
			PaymentsDao.delete(cust, idpay);
			return PaymentsDao.findCustPayments(cust, -1);
		}
		
		
		
	}
	
	
	@PUT
	@Path("{idpay}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> editPayment(@NotNull @PathParam("id") int idcust, @NotNull @FormParam("idpay") int idpay, 
			@FormParam("pan") String pan, @NotNull @FormParam("cvv") String cvv,
			@NotNull @FormParam("month") int month, @NotNull @FormParam("year") int year) throws Exception
	{
		if(!CustomersDao.exists(idcust))
		{
			throw new Exception("ERROR: customer not found "+ idcust);
		}
		else
		{
			Customer cust = CustomersDao.findId(idcust);
			if(pan != null)
			{
				PaymentsDao.editPan(cust, idpay, pan);
			}
			if(cvv != null)
			{
				PaymentsDao.editCvv(cust, idpay, cvv);
			}
			if(month<12 && year!=9999 && year>2017 && month>0)
			{
				PaymentsDao.editExpiration(cust, idpay, month, year);
			}
			
			return PaymentsDao.findCustPayments(cust, -1);
		}
		
		
		
	}
	
	

	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> addPayment(@NotNull @PathParam("id") int idcust, 
			@FormParam("type") String type, @FormParam("pan") String pan,
			@FormParam("cvv") String cvv, @FormParam("day") String day, 
			@FormParam("month") int month, @FormParam("year") int year) throws Exception
	{
		if(!CustomersDao.exists(idcust))
		{
			throw new Exception("ERROR: customer not found "+ idcust);
		}
		else
		{
			Customer cust = CustomersDao.findId(idcust);
			
			PaymentsDao.add(type, pan, cvv, month, year, cust);
			
			return PaymentsDao.findCustPayments(cust, -1);
			
		}
		
		
	}
}
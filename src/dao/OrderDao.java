package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Order;
import beans.OrderLine;
import beans.Payment;
import beans.Address;
import beans.Customer;
public class OrderDao {

	public static List<Order> findAll(Customer customer) throws Exception 
	{
		List<Order> lu = new ArrayList<Order>();
		Connection cnx=null;
		//try 
		//{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT * FROM ORDERS WHERE customerid = ? AND paid = 1";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, customer.getId());
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//Order(int id, String fname, String lname, String email, String pwd)
			while(res.next()){
				System.out.println("SERVER DAO --- ORDER PAID? ----" + (res.getString("paid").equals("1")));
				lu.add(new Order(res.getInt("id"),customer , res.getString("paid").equals("1"), new Payment(0, "-------------secret-----------", "-------------secret-----------", "-------------secret-----------", 0,0, customer), res.getInt("shipping_address_id"), res.getInt("billing_address_id")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
			for(Order order : lu){
				List<OrderLine> list = OrderLineDao.findAll(order);
				order.setOrderLines(list);
			}
			
			for(Order order : lu){
				if (order.get_shipping_address_id() != 0){
					Address sa = AddressesDao.findCustAddresses(customer, order.get_shipping_address_id(), "shipping").get(0);
					order.setShippingaddress(sa);
				}
				if (order.get_billing_address_id() != 0){
					Address ba = AddressesDao.findCustAddresses(customer, order.get_billing_address_id(), "billing").get(0);
					order.setBillingaddress(ba);
				}
			}

		return lu;
	}
	
	public static String create(Customer customer) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "INSERT INTO ORDERS (customerid,paid) VALUES (?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);

		
		ps.setInt(1, customer.getId());
		ps.setInt(2, 0);
		//Execution et traitement de la réponse
		int res = ps.executeUpdate();
		
		System.out.println("Inserted: " + res);
		if (res == 1)
			return "created";
		else
			throw new Exception("DataBase Insertion Error with customer: " + customer.getEmail());
	}
	
	public static Order findId(Customer customer, int id) throws Exception 
	{

		Order lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM ORDERS WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				System.out.println("SA-:" + res.getInt("shipping_address_id"));
				System.out.println("BA-:" + res.getInt("billing_address_id"));
				lu = new Order(res.getInt("id"), customer, res.getBoolean("paid"), res.getInt("shipping_address_id"), res.getInt("billing_address_id"));
				System.out.println("SA-----:" + lu.get_shipping_address_id());
				System.out.println("BA-----:" + lu.get_billing_address_id());
			}
//			
			res.close();
			ConnectionBDD.getInstance().closeCnx();	
			
			List<OrderLine> lines = OrderLineDao.findAll(lu);
			lu.setOrderLines(lines);
			
			if (lu.get_shipping_address_id() != 0){
				Address sa = AddressesDao.findCustAddresses(customer, lu.get_shipping_address_id(), "shipping").get(0);
				System.out.println("SA:" + sa.getCity());
				lu.setShippingaddress(sa);
			}
			if (lu.get_billing_address_id() != 0){
				Address ba = AddressesDao.findCustAddresses(customer, lu.get_billing_address_id(), "billing").get(0);
				System.out.println("BA:" + ba.getCity());
				lu.setBillingaddress(ba);
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lu;
	}

	public static Order findOrCreateCart(Customer customer, boolean allow_create) throws Exception {
		
		Order lu = null;
		
		Connection cnx=null;
		cnx = ConnectionBDD.getInstance().getCnx();

		String sql = "SELECT * FROM ORDERS WHERE (paid = 0 OR paid = NULL) AND customerid = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, customer.getId());
		
		ResultSet res = ps.executeQuery();
		while(res.next()){
			lu = new Order(res.getInt("id"), customer, res.getBoolean("paid"), res.getInt("shipping_address_id"), res.getInt("billing_address_id"));
		}
		
		res.close();
		ConnectionBDD.getInstance().closeCnx();
		if(lu == null){
			if(allow_create) {
				create(customer);
				System.out.print("-------------------------CREATE------------------------");
				return findOrCreateCart(customer, true);
			}else{
					throw new Exception("Your cart is empty");
			}
		}
		List<OrderLine> list = OrderLineDao.findAll(lu);
		lu.setOrderLines(list);
		if (lu.get_shipping_address_id() != 0){
			Address sa = AddressesDao.findCustAddresses(customer, lu.get_shipping_address_id(), "shipping").get(0);
			lu.setShippingaddress(sa);
		}
		if (lu.get_billing_address_id() != 0){
			Address ba = AddressesDao.findCustAddresses(customer, lu.get_billing_address_id(), "billing").get(0);
			lu.setBillingaddress(ba);
		}
		System.out.print("Found : " + lu.getId());
		return lu;
	}
	
	public static Order setAddresses(Customer customer, Order order, int shipping_address_id, int billing_address_id) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		System.out.println("Shipping " + shipping_address_id);
		System.out.println("Billing " + billing_address_id);

		String sql = "UPDATE ORDERS SET shipping_address_id = ?, billing_address_id = ? WHERE id = ? AND paid = 0";
		PreparedStatement ps = cnx.prepareStatement(sql);

		ps.setInt(1, shipping_address_id);
		ps.setInt(2, billing_address_id);
		ps.setInt(3, order.getId());
		//Execution et traitement de la réponse
		int res = ps.executeUpdate();
		
		System.out.println("Inserted: " + res);
		if (res == 1) {
			Order updated_order = findId(customer, order.getId());
			return updated_order;
		}
		else
			throw new Exception("DataBase Insertion Error with customer: " + order.getId());
	}
	
	public static Order payOrder(Customer customer, Order order, int payment_id) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "UPDATE ORDERS SET paid = 1, paymentid = ? WHERE id = ? AND paid = 0";
		PreparedStatement ps = cnx.prepareStatement(sql);

		ps.setInt(1, payment_id);
		ps.setInt(2, order.getId());
		//Execution et traitement de la réponse
		int res = ps.executeUpdate();
		
		System.out.println("Inserted: " + res);
		if (res == 1) {
			Order paid_order = findId(customer, order.getId());
			return paid_order;
		}
		else
			throw new Exception("DataBase Insertion Error with customer: " + order.getId());
	}
		
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Order;
import beans.OrderLine;
import beans.Customer;
public class OrderDao {

	public static List<Order> findAll(Customer customer) throws Exception 
	{
		List<Order> lu = new ArrayList<Order>();
		Connection cnx=null;
		//try 
		//{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT * FROM ORDERS WHERE customerid = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, customer.getId());
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//Order(int id, String fname, String lname, String email, String pwd)
			while(res.next()){
				lu.add(new Order(res.getInt("id"),customer , (res.getString("paid") == "True" || res.getString("paid") == "1")));
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
	
	public static Order findId(Customer customer, int id) 
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
				lu = new Order(res.getInt("id"), customer, res.getBoolean("paid"));
			}
			
//			List<OrderLine> lines = OrderLineDao.findAll(lu);
//			lu.order(lines);
//			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
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
			lu = new Order(res.getInt("id"), customer, res.getBoolean("paid"));
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
		System.out.print("Found : " + lu.getId());
		return lu;
	}
	
	public static Order payOrder(Customer customer, Order order, int payment_id) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "UPDATE ORDERS SET paid = 1, paymentid = ? WHERE id = ?";
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

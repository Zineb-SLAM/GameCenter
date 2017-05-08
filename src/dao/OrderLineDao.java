package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.OrderLine;
import beans.Product;
import beans.Customer;
import beans.Order;
import beans.Product;
public class OrderLineDao {

	public static List<OrderLine> findAll(Order order) 
	{
		List<OrderLine> lu = new ArrayList<OrderLine>();
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());


			//Requete
			String sql = "select o.*, p.name, p.consoleid, p.price as uni_price, p.price * quantity as total from ORDER_LINES o, PRODUCTS p where o.productid = p.id AND orderid = ?;";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, order.getId() + ""); // conversion en String
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			System.out.println(res);
			
			//OrderLine(int id, String fname, String lname, String email, String pwd)
//			while(res.next()){
//				lu.add(new OrderLine(res.getInt("id"), res.getString("firstname"), res.getString("lastname"), res.getString("email"),
//						res.getString("usernmae"), res.getString("password")));
//			}
//			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
	}


		return lu;
	}
	
	public static OrderLine findId(Order order, int id) throws SQLException 
	{

		OrderLine lu = null;
		
		Connection cnx=null;
		cnx = ConnectionBDD.getInstance().getCnx();

		String sql = "select o.*, p.name, p.consoleid, p.price as uni_price, p.price * o.quantity as total from ORDER_LINES o, PRODUCTS p where o.productid = p.id AND o.orderid = ? AND o.id = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, order.getId());
		ps.setInt(2, id);
		
		ResultSet res = ps.executeQuery();
		//public Customer(int id, String fname, String lname, String email, String username, String pwd)
		if(res.next()){
			lu = new OrderLine(res.getInt("id"), order, new Product(res.getInt("productid"),res.getString("name"), res.getFloat("uni_price")), res.getInt("quantity"));
			System.out.print("Found: " + res.getInt("o.id"));
		} else
			System.out.print("Not found");
		res.close();
		ConnectionBDD.getInstance().closeCnx();			
		return lu;
	}
	
	// TODO: FIX this method to use objects and not raw attributes
	
	public static String addToCart(Order order, int product_id, int quantity) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		String sql_exists = "SELECT * FROM ORDER_LINES WHERE orderid = ? AND productid = ?";
		PreparedStatement ps = cnx.prepareStatement(sql_exists);
		ps.setInt(1, order.getId());
		ps.setInt(2, product_id);
		ResultSet res = ps.executeQuery();
		
		
		if (res.next()){
			String sql = "UPDATE ORDER_LINES SET quantity = ? WHERE id = ?";
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, res.getInt("id"));
			int res_update = ps.executeUpdate();
			if (res_update == 1)
				return "updated";
			else
				throw new Exception("DataBase Update Error with order: " + order);
		}
		
		String sql = "INSERT INTO ORDER_LINES (orderid,productid,quantity) VALUES (?,?,?)";
		ps = cnx.prepareStatement(sql);
		ps.setInt(1, order.getId());
		ps.setInt(2, product_id);
		ps.setInt(3, quantity);
		int res_created = ps.executeUpdate();
		if (res_created == 1)
			return "created";
		else
			throw new Exception("DataBase Insertion Error with order: " + order);

	}
	

	
	public static String removeOrderLine(OrderLine order_line, Order order) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "DELETE FROM ORDER_LINES where id = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, order_line.getId());
		
		int res = ps.executeUpdate();
		//Execution et traitement de la réponse
		
		
		System.out.println("Cart Updated: " + res);
		if (res == 1)
			return "deleted";
		else
			throw new Exception("DataBase Delete Error with orderline: " + order_line);
	}
	
	

		
}

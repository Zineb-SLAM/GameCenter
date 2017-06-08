package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import beans.OrderLine;
import beans.Product;
import beans.Publisher;
import beans.ConsoleType;
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
			String sql = "select o.*, p.name product_name, p.maingenre, p.publisherid, p.agemin, p.consoleid, p.releasedate, p.quantity as stock_quantity, p.description, p.price as uni_price, c.name console_name, pub.name as pub_name, p.price * o.quantity as total from ORDER_LINES o, PRODUCTS p, CONSOLTYPES c, PUBLISHERS pub where o.productid = p.id AND orderid = ? and c.id = consoleid AND pub.id = publisherid";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setString(1, order.getId() + ""); // conversion en String
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			DecimalFormat df = new DecimalFormat("##.##");
			//OrderLine(int id, String fname, String lname, String email, String pwd)
			while(res.next()){
				//Product product = ProductsDao.find(res.getInt("id"));
				lu.add(new OrderLine(res.getInt("o.id"), order, new Product(res.getInt("productid"), res.getString("product_name"), res.getString("maingenre"), new Publisher(res.getInt("publisherid"), res.getString("pub_name")), res.getInt("agemin"), 
						new ConsoleType(res.getInt("consoleid"), res.getString("console_name")), res.getString("releasedate"), res.getFloat("uni_price"), res.getInt("stock_quantity"), res.getString("description")) , res.getInt("o.quantity"), res.getFloat("total")));
			}
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
	public static Order setOrderlines(Order order, int product_id, int quantity) throws Exception {
		return setOrderlines(order, product_id, quantity, false);
	}
	public static Order setOrderlines(Order order, int product_id, int quantity, boolean add) throws Exception {
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
			int new_quantity = quantity;
			if (add)
				new_quantity = new_quantity + res.getInt("quantity");
			ps.setInt(1, new_quantity);
			ps.setInt(2, res.getInt("id"));
			int res_update = ps.executeUpdate();
			if (res_update == 1){
				Order new_order = OrderDao.findOrCreateCart(order.getCustomer(), false);
				return new_order;
			}
			else
				throw new Exception("DataBase Update Error with order: " + order);
		}
		return null;
	}
	
	public static Order addToCart(Order order, int product_id, int quantity) throws Exception {
		Connection cnx=null;
		cnx = ConnectionBDD.getInstance().getCnx();
		Order try_update = setOrderlines(order, product_id, quantity, true);
		if(try_update != null)
			return try_update;
		
		String sql = "INSERT INTO ORDER_LINES (orderid,productid,quantity) VALUES (?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, order.getId());
		ps.setInt(2, product_id);
		ps.setInt(3, quantity);
		int res_created = ps.executeUpdate();
		if (res_created == 1){
			Order new_order = OrderDao.findOrCreateCart(order.getCustomer(), false);
			return new_order;
		}
		else
			throw new Exception("DataBase Insertion Error with order: " + order);

	}
	

	
	public static Order removeOrderLine(OrderLine order_line, Order order) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "DELETE FROM ORDER_LINES where id = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, order_line.getId());
		
		int res = ps.executeUpdate();
		//Execution et traitement de la réponse
		
		
		System.out.println("Cart Updated: " + res);
		if (res == 1){
			Order new_order = OrderDao.findOrCreateCart(order.getCustomer(), false);
			return new_order;
		}
		else
			throw new Exception("DataBase Delete Error with orderline: " + order_line);
	}
	
	
	public static Order removeLineOrderByProduct(Order order, Product product) throws Exception {
		Connection cnx=null;
		cnx = ConnectionBDD.getInstance().getCnx();
		String sql_exists = "SELECT * FROM ORDER_LINES WHERE orderid = ? AND productid = ?";
		PreparedStatement ps = cnx.prepareStatement(sql_exists);
		ps.setInt(1, order.getId());
		ps.setInt(2, product.getId());
		ResultSet res = ps.executeQuery();
		
		
		if (res.next()){
			String sql = "DELETE FROM ORDER_LINES WHERE id = ? AND orderid = ?";
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, res.getInt("id"));
			ps.setInt(2, res.getInt("orderid"));
			int res_update = ps.executeUpdate();
			if (res_update == 1){
				Order new_order = OrderDao.findOrCreateCart(order.getCustomer(), false);
				return new_order;
			}
			else
				throw new Exception("DataBase Delete orderline Error with order: " + order);
		}
		return null;
	}
	
	public static Order clear_cart(Order order) throws Exception {
		Connection cnx=null;
		cnx = ConnectionBDD.getInstance().getCnx();
		String sql = "DELETE FROM ORDER_LINES WHERE orderid = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, order.getId());
		int res_update = ps.executeUpdate();
		if (res_update == 1){
			Order new_order = OrderDao.findOrCreateCart(order.getCustomer(), false);
			return new_order;
		}
		else
			throw new Exception("DataBase Clear Cart Error with order: " + order);
	}
		
}

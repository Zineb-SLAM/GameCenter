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
			String sql = "SELECT * FROM ORDER_LINES WHERE ORDER = ?";
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
	
	// TODO: FIX this method to use objects and not raw attributes
	public static String create(int order_id, int product_id, int quantity) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql_exists = "SELECT * FROM ORDER_LINES WHERE orderid = ? AND productid = ?";
		PreparedStatement ps_exists = cnx.prepareStatement(sql_exists);
		ps_exists.setInt(1, order_id);
		ps_exists.setInt(2, product_id);
		ResultSet res_exists = ps_exists.executeQuery();
		
		res_exists.next();
		String sql = "UPDATE ORDER_LINES SET quantity = ? WHERE id = ?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		try {
			res_exists.getInt("id");
			ps.setInt(1, res_exists.getInt("quantity") + 1);
			ps.setInt(2, res_exists.getInt("id"));
		} catch (Exception e){
			sql = "INSERT INTO ORDER_LINES (orderid,productid,quantity) VALUES (?,?,?) RETURNING *";
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, order_id);
			ps.setInt(2, product_id);
			ps.setInt(3, quantity);
		}
		
		
		int res = ps.executeUpdate();
		//Execution et traitement de la réponse
		
		
		System.out.println("Inserted: " + res);
		if (res == 1)
			return "created";
		else
			throw new Exception("DataBase Insertion Error with order: " + order_id);
	}
	
	

		
}

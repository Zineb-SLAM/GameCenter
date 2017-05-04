package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.LineOrder;
import beans.Customer;

public class LineOrderDao {

	public static List<LineOrder> findAll(Customer customer) 
	{
		List<LineOrder> lu = new ArrayList<LineOrder>();
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());


			//Requete
			String sql = "SELECT * FROM LINE_ORDERS WHERE CUSTOMER = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, customer.getId() + ""); // conversion en String
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			System.out.println(res);
			
			//LineOrder(int id, String fname, String lname, String email, String pwd)
//			while(res.next()){
//				lu.add(new LineOrder(res.getInt("id"), res.getString("firstname"), res.getString("lastname"), res.getString("email"),
//						res.getString("usernmae"), res.getString("password")));
//			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
	}


		return lu;
	}
	

		
}

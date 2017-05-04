package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Order;
import beans.Customer;

import dao.PaymentsDao;
import beans.Payment;
public class OrderDao {

	public static List<Order> findAll(Customer customer) throws Exception 
	{
		List<Order> lu = new ArrayList<Order>();
		Connection cnx=null;
		//try 
		//{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());


			//Requete
			String sql = "SELECT * FROM ORDERS WHERE customerid = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, customer.getId());
			
			System.out.print("------------------Customer:" + customer.getId() + "---------------------");
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//Order(int id, String fname, String lname, String email, String pwd)
			while(res.next()){
				System.out.println("/////" + res.getInt("id"));
				lu.add(new Order(res.getInt("id"),customer , (res.getString("paid") == "True" || res.getString("paid") == "1"), new Payment(1, "temp", "temp", "temp")));
						//customer.payments(Integer.parseInt(res.getString("paymentid")))));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}


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
		
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;

public class CustomersDao {

	public static List<Customer> findAll() 
	{
		List<Customer> lu = new ArrayList<Customer>();
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());


			//Requete
			String sql = "SELECT * FROM CUSTOMERS WHERE status=1";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//System.out.println(res);
			
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				lu.add(new Customer(res.getInt("id"), res.getString("firstname"),
						res.getString("lastname"), res.getString("gender"), res.getString("email"),
						res.getString("username"), res.getString("password")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
	}

		return lu;
	}
	
	public static List<Customer> findAll(String sort) 
	{
		List<Customer> lu = new ArrayList<Customer>();
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			String sql = "SELECT * FROM CUSTOMERS WHERE status=1" ;

			switch(sort)
			{
				case "1":
					sql = "SELECT * FROM CUSTOMERS WHERE status=1 ORDER BY firstname";
					break;
				case "2":
					sql = "SELECT * FROM CUSTOMERS WHERE status=1 ORDER BY lastname";
					break;
				case "3":
					sql = "SELECT * FROM CUSTOMERS WHERE status=1 ORDER BY username";
			
			}
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//System.out.println(res);
			
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				lu.add(new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"), res.getString("gender"),
						res.getString("email"), res.getString("username"), res.getString("password")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
	}

		return lu;
	}
	

	
	public static Customer find(String username) 
	{

		Customer lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT id,description,prix FROM CUSTOMERS WHERE username=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet res = ps.executeQuery();
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				lu = new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"),res.getString("gender"), 
					     res.getString("email"), res.getString("username"),res.getString("password"));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lu;
	}

	
	public static void delete(String id)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE CUSTOMERS SET status=0 WHERE id=" + id;
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
		
}

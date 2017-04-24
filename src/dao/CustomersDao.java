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
			String sql = "SELECT * FROM CUSTOMERS";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			System.out.println(res);
			
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				lu.add(new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"), res.getString("email"),
						res.getString("usernaMe"), res.getString("password")));
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
				lu = new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"), 
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
	
	public static Customer create_customer(String gender ,String first_name, String last_name, String email, String username, String pwd) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "INSERT INTO CUSTOMERS (lastname, firstname, gender, username, email, password) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);

		missing_exception(last_name, "last_name");
		missing_exception(first_name, "first_name");
		missing_exception(gender, "gender");
		missing_exception(username, "username");
		missing_exception(email, "email");
		missing_exception(pwd, "pwd");
		
		ps.setString(1, last_name);
		ps.setString(2, first_name);
		ps.setString(3, gender);
		ps.setString(4, username);
		ps.setString(5, email);
		ps.setString(6, pwd);
		//Execution et traitement de la réponse
		int res = ps.executeUpdate();
		
		System.out.println("Inserted: " + res);
		if (res == 1)
			return CustomersDao.find(username);
		else
			throw new Exception("DataBase Insertion Error with customer: " + username);
	}

	
	private static void missing_exception(String param, String param_name) throws Exception {
		if(param == null)
			throw new Exception("Missing Parameter: " + param_name);
	}
}

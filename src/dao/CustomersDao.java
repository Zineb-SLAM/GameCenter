package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
						res.getString("username"), "-----------secret------------"));
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
				case "firstname":
					sql = "SELECT * FROM CUSTOMERS WHERE status=1 ORDER BY firstname";
					break;
				case "lastname":
					sql = "SELECT * FROM CUSTOMERS WHERE status=1 ORDER BY lastname";
					break;
				default: // "username":
					sql = "SELECT * FROM CUSTOMERS WHERE status=1 ORDER BY username";
			
			}
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//System.out.println(res);
			
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				lu.add(new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"), res.getString("gender"),
						res.getString("email"), res.getString("username"), "-----------secret------------"));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
	}

		return lu;
	}
	
	public static Customer findId(int id){
		return findId(id, false);
	}

	public static Customer findId(int id, boolean with_password) 
	{

		Customer lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM CUSTOMERS WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				String password;
				if (with_password)
					password = res.getString("password");
				else
					password = "-----------secret------------";
				lu = new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"),res.getString("gender"), 
					     res.getString("email"), res.getString("username"),password);
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lu;
	}
	
	public static Customer findUsername(String username) {
		return findUsername(username, true, true);
	}
	public static Customer findUsername(String username, boolean with_password, boolean with_admin) 
	{
		Customer lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			// Remplacer par un switch
			String sql = "SELECT id, lastname, firstname, gender, username, email, password, status FROM CUSTOMERS WHERE username=?";
			
//			if (with_admin) {
//				sql = "SELECT c.id, c.lastname, c.firstname, c.gender, c.username, c.email, c.password, c.status, where username=?";
//			}
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet res = ps.executeQuery();
			//public Customer(int id, String fname, String lname, String email, String username, String pwd)
			while(res.next()){
				String password;
				if (with_password)
					password = res.getString("password");
				else
					password = "-----------secret------------";
				
				int is_admin = 0;
//				if (with_admin)
//					is_admin = res.getInt("is_admin");
				
				lu = new Customer(res.getInt("id"), res.getString("firstname"), res.getString("lastname"),res.getString("gender"), 
					     res.getString("email"), res.getString("username"),password, is_admin == 1);
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lu;
	}
	
	public static Customer create(String gender ,String first_name, String last_name, String email, String username, String pwd) throws Exception {
		Connection cnx=null;
		
		cnx = ConnectionBDD.getInstance().getCnx();
		
		String sql = "INSERT INTO CUSTOMERS (lastname, firstname, gender, username, email, password, status) VALUES (?,?,?,?,?,?,true)";
		PreparedStatement ps = cnx.prepareStatement(sql);

		missing_exception(last_name, "last_name");
		missing_exception(first_name, "first_name");
		missing_exception(gender, "gender");
		missing_exception(username, "username");
		missing_exception(email, "email");
		missing_exception(pwd, "pwd");

        String hashed_pwd = hash_password(pwd);
		
        System.out.println("Digest(in hex format):: " + hashed_pwd);
		ps.setString(1, last_name);
		ps.setString(2, first_name);
		ps.setString(3, gender);
		ps.setString(4, username);
		ps.setString(5, email);
		ps.setString(6, hashed_pwd);
		//Execution et traitement de la réponse
        System.out.println(ps);

		int res = ps.executeUpdate();
		
		System.out.println("Inserted: " + res);
		if (res == 1)
			return CustomersDao.findUsername(username);
		else
			throw new Exception("DataBase Insertion Error with customer: " + username);
	}
	
	public static void delete(String id)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE CUSTOMERS SET status=0 WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static boolean exists(int id)
	{
		Connection cnx=null;

		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT * FROM CUSTOMERS WHERE status= 1 AND id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			if(res.next())
				return true;
			
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
		return false;
	}
	
	public static boolean authenticate(Customer customer, String password) throws NoSuchAlgorithmException {
		String hashed_password = hash_password(password);
		return hashed_password.equals(customer.getPwd());
	}
	
	private static void missing_exception(String param, String param_name) throws Exception {
		if(param == null)
			throw new Exception("Missing Parameter: " + param_name);
	}
	
	private static String hash_password(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
	}
}

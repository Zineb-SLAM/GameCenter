package dao;
import beans.Address;
import beans.Customer;
import dao.CustomersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class AddressesDao
 */

public class AddressesDao
{
	
	public static List<Address> findCustAddresses(Customer cust, int idadd, String type) throws Exception
	{
	
		List<Address> lu = new ArrayList<Address>();
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			String sql = "";
			PreparedStatement ps;
			if(idadd == -1) //find all the addresses of the customer
			{
				sql = "SELECT * FROM ADDRESSES WHERE status=1 AND customer = ?";
				sql = sql + " AND (type = '" + type + "' OR type = 'both')";
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, cust.getId());
				System.out.print(sql);
			}
			else //find a particular address for the customer
			{
				sql = "SELECT * FROM ADDRESSES WHERE status=1 AND customer = ? AND id = ?";
				sql = sql + " AND (type = '" + type + "' OR type = 'both')";
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, cust.getId());
				ps.setInt(2, idadd);
				System.out.print(sql);
			}
			
			ResultSet res = ps.executeQuery();

		//	Address(int id, String address, String zip, String city, String country, String type, boolean status, 
			//int idc, String fname, String lname, String gender, String email, String username, String pwd, boolean status
			while(res.next())
			{
				lu.add(new Address(res.getInt("id"), res.getString("address"), res.getString("zipcode"), 
						res.getString("city"), res.getString("country"), res.getString("type"), 
						res.getBoolean("status"), cust));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return lu;
	}
	
	public static boolean add(String address, String zipcode, String city, String country,
			String type, Customer cust) throws Exception
	{
		Connection cnx = null;
		
		missing_exception(address, "address");
		missing_exception(zipcode, "zipcode");
		missing_exception(city, "city");
		missing_exception(country, "country");
		missing_exception(type, "type");
		
		
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "INSERT INTO ADDRESSES (address, zipcode, city, country, type, customer, status)"
					+ "VALUES (?, ?, ?, ?, ?, ?, 1)";
			

			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2, zipcode);
			ps.setString(3, city);
			ps.setString(4, country);
			ps.setString(5, type);
			ps.setInt(6, cust.getId());
			int res = ps.executeUpdate();
			
			
			if(res == 1)
				return true;
			
			ps.close();
			
			System.out.println("Inserted: " + res);
			

		}catch (SQLException e) 
		{
			e.printStackTrace();
		} 	
		
		
		return false;
	}
	
	public static void delete(Customer cust, int idadd)
	{
		
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE ADDRESSES SET status=0 WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, cust.getId() );
			ps.setInt(2, idadd );
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void edit(Customer cust, int idadd, String address) throws Exception
	{
		Connection cnx=null;
		try
		{
			
			cnx = ConnectionBDD.getInstance().getCnx();
	
			String sql = "UPDATE ADDRESSES SET address=? WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, address );
			ps.setInt(2, cust.getId() );
			ps.setInt(3, idadd );
	
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return;
	}
	
	public static boolean exists(int id)
	{
		Connection cnx=null;

		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT * FROM ADDRESSES WHERE status= 1 AND id=?";
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
	
	
	private static void missing_exception(String param, String param_name) throws Exception 
	{
		if(param == null)
			throw new Exception("Missing Parameter: " + param_name);
	}
};
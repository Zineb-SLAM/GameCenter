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
				if(type != "ignore_type")
					sql = sql + " AND (type = '" + type + "' OR type = 'both')";
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, cust.getId());
				System.out.print(sql);
			}
			else //find a particular address for the customer
			{
				sql = "SELECT * FROM ADDRESSES WHERE status=1 AND customer = ? AND id = ?";
				if(type != "ignore_type")
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
	
	public static Address add(String address, String zipcode, String city, String country,
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
			
			
			if(res == 1){
				String res_sql = "SELECT * FROM ADDRESSES WHERE address = ? AND zipcode = ? AND city = ? AND country = ? AND type = ? AND customer = ? AND status = 1";
				ps = cnx.prepareStatement(res_sql);
				ps.setString(1, address);
				ps.setString(2, zipcode);
				ps.setString(3, city);
				ps.setString(4, country);
				ps.setString(5, type);
				ps.setInt(6, cust.getId());
				
				ResultSet res_fetch = ps.executeQuery();
				res_fetch.next();
				Address new_address = new Address(res_fetch.getInt("id"), res_fetch.getString("address"), res_fetch.getString("zipcode"), 
						res_fetch.getString("city"), res_fetch.getString("country"), res_fetch.getString("type"), 
						res_fetch.getBoolean("status"), cust);
				
				return new_address;
			}
			ps.close();
			
			System.out.println("Inserted: " + res);
			

		}catch (SQLException e) 
		{
			e.printStackTrace();
		} 	
		
		
		return null;
	}
	
	public static boolean delete(Customer cust, int idadd)
	{
		
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE ADDRESSES SET status=0 WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, cust.getId() );
			ps.setInt(2, idadd );
			int res = ps.executeUpdate();
			ps.close();
			ConnectionBDD.getInstance().closeCnx();	

			return res == 1;
				
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public static Address update(Customer cust, int idadd, String address, String zipcode, String city, String country,
			String type) throws Exception
	{
		Connection cnx=null;
		try
		{
			
			cnx = ConnectionBDD.getInstance().getCnx();
	
			String sql = "UPDATE ADDRESSES SET address=?, zipcode=?, city=?, country=?, type=? WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2, zipcode);
			ps.setString(3, city);
			ps.setString(4, country);
			ps.setString(5, type);
			
			ps.setInt(6, cust.getId());
			ps.setInt(7, idadd);
	
			int res = ps.executeUpdate();
			ps.close();
			ConnectionBDD.getInstance().closeCnx();	
			
			if(res==1){
				return AddressesDao.findCustAddresses(cust, idadd, type).get(0);
			}
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
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
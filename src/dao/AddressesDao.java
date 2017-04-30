package dao;
import beans.Address;
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
	
	public static List<Address> findCustAddress(int idcust, int idadd) throws Exception
	{
		if(!CustomersDao.exists(idcust))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ idcust);
		}
		
		
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
				sql = "SELECT * FROM Customers c, Addresses a WHERE c.status=1 AND a.status=1 "
						+ "AND c.id = a.customer AND c.id = ?";
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, idcust);
			}
			else //find a particular address for the customer
			{
				sql = "SELECT * FROM Customers c, Addresses a WHERE c.status=1 AND a.status=1"
						+ " AND c.id = a.customer AND c.id = ? AND a.id = ?";
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, idcust);
				ps.setInt(2, idadd);
			}
			
			ResultSet res = ps.executeQuery();

		//	Address(int id, String address, String zip, String city, String country, String type, boolean status, 
			//int idc, String fname, String lname, String gender, String email, String username, String pwd, boolean status
			while(res.next())
			{
				lu.add(new Address(res.getInt("a.id"), res.getString("address"), res.getString("zipcode"), res.getString("city"),
						res.getString("country"), res.getString("type"), res.getBoolean("a.status"), 
						res.getInt("c.id"), res.getString("firstname"), res.getString("lastname"), res.getString("gender"),
						res.getString("email"), res.getString("username"), res.getString("password"), res.getBoolean("c.status")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return lu;
	}
	
	public static boolean add(String address, String zipcode, String city, String country, String type, int idcust) throws Exception
	{
		Connection cnx = null;

		if(!CustomersDao.exists(idcust))
		{
			throw new Exception("ERROR: Insertion failed, customer not found "+ idcust);
		}
		
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
			ps.setInt(6, idcust);
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
	
	public static void delete(int idcust, int idadd)
	{
		
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE ADDRESSES SET status=0 WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idcust );
			ps.setInt(2, idadd );
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void edit(int idcust, int idadd, String address) throws Exception
	{
		Connection cnx=null;
		try
		{
			if(!AddressesDao.exists(idcust, idadd))
			{
				throw new Exception("ERROR: UPDATE failed, address or customer not found "+ idcust);
			}
			
			cnx = ConnectionBDD.getInstance().getCnx();
	
			String sql = "UPDATE ADDRESSES SET address=? WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, address );
			ps.setInt(2, idcust );
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

	public static boolean exists(int idcust, int idadd)
	{
		Connection cnx=null;

		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT * FROM ADDRESSES a, CUSTOMERS c "
					+ "WHERE a.status= 1 AND a.id=? AND c.id=? AND c.status=1 AND a.customer = c.id";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idadd);
			ps.setInt(2, idcust);
			
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
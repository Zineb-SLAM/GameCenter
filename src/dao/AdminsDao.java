package dao;
import beans.Address;
import beans.Admin;
import beans.Customer;
import dao.CustomersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminsDao
{
	public static List<Admin> findAll()
	{
		List<Admin> lu = new ArrayList<Admin>();
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			PreparedStatement ps;
			
			String sql = "SELECT * FROM ADMIN";
			ps = cnx.prepareStatement(sql);	
			ResultSet res = ps.executeQuery();

			while(res.next())
			{
				// Admin (int id, String f, String l, String u, String e, String p)
				lu.add(new Admin(res.getInt("id"), res.getString("firstname"), res.getString("lastname"),
						res.getString("username"), res.getString("email"), res.getString("password")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return lu;
		
	}
	
	public static Admin find(int id)
	{
		
		Admin lu= null;
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			PreparedStatement ps;
			String sql = "SELECT * FROM ADMIN WHERE id = ?";
			ps = cnx.prepareStatement(sql);	
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();

			while(res.next())
			{
				lu = new Admin(res.getInt("id"), res.getString("firstname"), res.getString("lastname"),
						res.getString("username"), res.getString("email"), res.getString("password"));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return lu;
		
	}
	
	public boolean isAdmin(int id)
	{
		boolean isadmin = true;
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			PreparedStatement ps;
			
			String sql = "SELECT * FROM  ADMIN WHERE id =? ";
			
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			
			if(!res.next())
				isadmin = false;		
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
				
		return isadmin;
		
	}
	

}

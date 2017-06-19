package dao;
import beans.Address;
import beans.Admin;
import beans.Customer;
import dao.CustomersDao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	public static Admin findUsername(String username)
	{
		
		Admin lu= null;
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			PreparedStatement ps;
			String sql = "SELECT * FROM ADMIN WHERE username = ?";
			ps = cnx.prepareStatement(sql);	
			ps.setString(1, username);
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
	
	public static boolean authenticate(Admin admin, String password) throws NoSuchAlgorithmException {
		String hashed_password = hash_password(password);
		return hashed_password.equals(admin.getPwd());
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

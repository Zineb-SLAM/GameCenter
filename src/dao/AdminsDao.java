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
	public static List<Admin> find(int idcust)
	{
		List<Admin> lu = new ArrayList<Admin>();
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			PreparedStatement ps;
			
			String sql = "SELECT * FROM CUSTOMERS c, ADMIN a WHERE c.status=1 AND c.id = a.customer AND c.id = ?";
			ps = cnx.prepareStatement(sql);	
			ps.setInt(1, idcust);
			ResultSet res = ps.executeQuery();

			while(res.next())
			{
				lu.add(new Admin(res.getInt("a.id"),  CustomersDao.findId(res.getInt("a.customer"))));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return lu;
		
	}
	
	public boolean isAdmin(int idcust)
	{
		boolean isadmin = true;
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			PreparedStatement ps;
			
			String sql = "SELECT * FROM CUSTOMERS c, ADMIN a WHERE c.status=1 AND c.customer = ? ";
			
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, idcust);
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

package dao;
import beans.Customer;
import beans.Address.AddressType;
import beans.Address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressesDao
 */

public class AddressesDao
{
	
	public static List<Address> findAll() 
	{
		List<Address> lu = new ArrayList<Address>();
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());


			//Requete
			String sql = "SELECT * FROM Customers c, Addresses a WHERE c.status=1 AND a.status=1 AND c.id = a.customer";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//System.out.println(res);
			
		//	Address(int id, String address, String zip, String city, String country, String type, boolean status, 
			//int idc, String fname, String lname, String gender, String email, String username, String pwd, boolean stat)

			while(res.next())
			{
				lu.add(new Address(res.getInt("id"), res.getString("address"), res.getString("zipcode"), res.getString("city"),
						res.getString("country"), res.getString("type"), res.getBoolean("a.status"), 
						res.getInt("c.id"), res.getString("firstname"), res.getString("lastname"), res.getString("gender"),
						res.getString("email"), res.getString("username"), res.getString("password"), res.getBoolean("c.status")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
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
			String sql = "UPDATE ADDRESSES SET status=0 WHERE id=" + id;
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
};
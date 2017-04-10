package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;

public class CustomerDao {

	public static List<Customer> findAll() 
	{
		List<Customer> lu = new ArrayList<Customer>();
		Connection con=null;
		try 
		{
			con = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName())
			
			if(con == null)
			{		
				return lu;
			}
			//DBTablePrinter.printTable(con, "CUSTOMERS");
			
			Statement stmt=con.createStatement(); 
			ResultSet res= stmt.executeQuery("SELECT * from CUSTOMERS");
		
			while(res.next())
			{
				lu.add(new Customer(res.getInt("id"), 
									res.getString("firstname"), 
									res.getString("lastname"), 
									res.getString("email"),
									res.getString("usernmae"), 
									res.getString("password")));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return lu;
	}
	

		
}

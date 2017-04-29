package dao;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PublisherDao
{
	public static int getId(String name)
	{
		Connection cnx=null;
		int id = -1;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			String sql = "";
			PreparedStatement ps;

			sql = "SELECT id FROM PUBLISHERS WHERE name LIKE ?";
				ps = cnx.prepareStatement(sql);
				ps.setString(1, "%"+name+"%");

			ResultSet res = ps.executeQuery();
			while (res.next()) 
			{
				id = res.getInt("id");
			}
			
		
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return id;
	}
	
	
};
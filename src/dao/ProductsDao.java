package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import beans.Customer;

public class ProductsDao {

	public static List<Product> findAll() {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Product> lu = new ArrayList<Product>();
		Connection cnx=null;
		try {
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT PRODUCTS.id as id, PRODUCTS.name as name, PRODUCTS.maingenre as genre, PUBLISHERS.name as publisher, "
					+ "PRODUCTS.agemin as agemin,  CONSOLTYPES.name as console, PRODUCTS.releasedate as releasedate, PRODUCTS.price as price,"
					+ " PRODUCTS.quantity as quantity, PRODUCTS.description as description FROM PRODUCTS, PUBLISHERS, CONSOLTYPES "
					+ "WHERE PRODUCTS.consoleid = CONSOLTYPES.id AND PRODUCTS.publisherid = PUBLISHERS.id";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			/*Product(int id, String name, String genre, String publ, int agemin, String console, 
					String date, float price, int qtty, String desc)*/
			while (res.next()) 
			{
					  lu.add(new Product(res.getInt("id"), res.getString("name"), 
							     res.getString("genre"), res.getString("publisher"), res.getInt("agemin"),
	                			 res.getString("console"), res.getDate("releasedate").toString(),
	                			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
	                			 )); 
	                            
	                           
	                           
	                            // out.println("\n");//Move to the next line to print the next row.           
		    }
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return lu;
	}
	
	public static Product find(int id) 
	{

		Product lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "SELECT id,description,prix FROM Products WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
		
			ResultSet res = ps.executeQuery();
			
			while(res.next())
			{
				lu = new Product(res.getInt("id"), res.getString("name"), 
					     res.getString("genre"), res.getString("publisher"), res.getInt("agemin"),
            			 res.getString("cosnsole"), res.getDate("releasedate").toString(),
            			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
            			 ); 
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lu;
	}

	
	public static List<Product> find(String genre) 
	{

		List<Product> lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT id,description,prix FROM PRODUCTS WHERE maingenre=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, genre);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Product(res.getInt("id"), res.getString("name"), 
					     res.getString("genre"), res.getString("publisher"), res.getInt("agemin"),
            			 res.getString("cosnsole"), res.getDate("releasedate").toString(),
            			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
            			 )); 
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lu;
	}
		
}

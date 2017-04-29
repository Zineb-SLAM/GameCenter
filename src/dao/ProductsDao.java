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

		List<Product> lu = new ArrayList<Product>();
		Connection cnx=null;
		try {
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c "
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			/*Product(int id, String name, String genre, String publ, int agemin, String console, 
					String date, float price, int qtty, String desc)*/
			while(res.next())
				{
					lu.add( new Product(res.getInt("pr.id"), res.getString("pr.name"), 
						     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
	            			 res.getString("c.name"), res.getDate("releasedate").toString(),
	            			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
	            			 )); 
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
			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c "
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id AND pr.id = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
		
			ResultSet res = ps.executeQuery();
			
			while(res.next())
			{
				lu = new Product(res.getInt("pr.id"), res.getString("pr.name"), 
					     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
            			 res.getString("c.name"), res.getDate("releasedate").toString(),
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
	
	public static List<Product> findGenre(String genre) 
	{

		List<Product> lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c"
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id AND pr.maingenre = ?";
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
	
	public static List<Product> findName(String name) 
	{

		List<Product> lu = new ArrayList<Product>();
		Connection cnx=null;
		try {
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c "
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id AND pr.name LIKE ? ";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet res = ps.executeQuery();
			
			System.out.println(res);
			
			/*Product(int id, String name, String genre, String publ, int agemin, String console, 
					String date, float price, int qtty, String desc)*/
			while (res.next()) 
			{

					lu.add( new Product(res.getInt("pr.id"), res.getString("pr.name"), 
						     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
	            			 res.getString("c.name"), res.getDate("releasedate").toString(),
	            			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
	            			 ));

       
		    }
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return lu;
	}
	
	public static List<Product> findPublisher(String name) 
	{

		List<Product> lu = new ArrayList<Product>();
		Connection cnx=null;
		try {
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c "
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id AND pb.name LIKE ? ";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet res = ps.executeQuery();
			
			System.out.println(res);
			
			/*Product(int id, String name, String genre, String publ, int agemin, String console, 
					String date, float price, int qtty, String desc)*/
			while (res.next()) 
			{

					lu.add( new Product(res.getInt("pr.id"), res.getString("pr.name"), 
						     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
	            			 res.getString("c.name"), res.getDate("releasedate").toString(),
	            			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
	            			 ));

       
		    }
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return lu;
	}
	
	public static List<Product> findConsole(String name) 
	{

		List<Product> lu = new ArrayList<Product>();
		Connection cnx=null;
		try {
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c "
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id AND c.name LIKE ? ";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet res = ps.executeQuery();
			
			System.out.println(res);
			
			/*Product(int id, String name, String genre, String publ, int agemin, String console, 
					String date, float price, int qtty, String desc)*/
			while (res.next()) 
			{

					lu.add( new Product(res.getInt("pr.id"), res.getString("pr.name"), 
						     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
	            			 res.getString("c.name"), res.getDate("releasedate").toString(),
	            			 res.getFloat("price"), res.getInt("quantity"), res.getString("description")
	            			 ));

       
		    }
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return lu;
	}

	public static List<Product> findAgemin(int age) 
	{

		List<Product> lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c"
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id AND agemin>?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, age);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) 
			{

					lu.add( new Product(res.getInt("pr.id"), res.getString("pr.name"), 
						     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
	            			 res.getString("c.name"), res.getDate("releasedate").toString(),
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
	
	public static List<Product> findDesc(String desc) 
	{

		List<Product> lu = null;
		
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM PRODUCTS pr , PUBLISHERS pb, CONSOLTYPES c"
					+ "WHERE pr.consoleid = c.id AND pr.publisherid = pb.id "
					+ "AND description LIKE '%?%' ";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, desc);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) 
			{

					lu.add( new Product(res.getInt("pr.id"), res.getString("pr.name"), 
						     res.getString("pr.maingenre"), res.getString("pb.name"), res.getInt("agemin"),
	            			 res.getString("c.name"), res.getDate("releasedate").toString(),
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
	
	
	public static void add(String name, String genre, String publisher, int agemin, String console, String date,
			float price, int quantity, String description)
	{
		Connection cnx=null;
		try
		{
			int idpub = PublisherDao.getId(publisher);
			int idconsole = ConsoleTypeDao.getId(console);
			
			cnx = ConnectionBDD.getInstance().getCnx();
			
			
			System.out.println("*********ID FOUND************ " + idpub + "  "  + idconsole);
			
			
			String sql = "INSERT INTO PRODUCTS (name, maingenre, publisherid, agemin, consoleid, releasedate, price, quantity, description)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, genre);
			ps.setInt   (3,  idpub);
			ps.setInt   (4, agemin);
			ps.setInt   (5, idconsole);
			ps.setString(6, date);
			ps.setFloat (7, price);
			ps.setInt   (8, quantity);
			ps.setString(9, description);			
			ps.executeUpdate();
			ps.close();
			ConnectionBDD.getInstance().closeCnx();		
			
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void editQuantity(String id, String name, String genre, String publisher, int age, String console, String date, float price, int qtty, String desc)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET quantity=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, qtty);
			ps.setString(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void editPrice(String id, float price)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET price=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setFloat(1, price);
			ps.setString(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void editAgemin(String id, int age)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET agemin=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, age);
			ps.setString(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	
	public static void ediMainGenre(String id, String genre)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET maingenre=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setString(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	
	public static void delete(int id)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET quantity=0 WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	
		
}

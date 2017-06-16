package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import beans.Publisher;
import beans.ConsoleType;
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
	
	private static int getIdPublisher(String name)
	{
		int id = -1;
		Connection cnx=null;
		try 
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT publisherid FROM PRODUCTS WHERE name= ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet res = ps.executeQuery();
			while (res.next()) 
			{
				id = res.getInt("publisherid");
			}
			
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();	
		
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return id;
	}
	
	private static String getMaingenre(String name)
	{
		Connection cnx = null;
		String maingenre = "null";
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "SELECT maingenre FROM PRODUCTS WHERE name = ?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) 
			{
				maingenre = res.getString("maingenre");
			}
				
			res.close();
			ConnectionBDD.getInstance().closeCnx();	
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return maingenre;
	}
	
//	public static Product update(Product product, String name, int quantity, double price, String maingenre, int agemin,  console, String description)
//	{
//		Connection cnx=null;
//		try
//		{
//			cnx = ConnectionBDD.getInstance().getCnx();
//			String sql = "UPDATE PAYMENTS SET name=?, quantity=?, price=?, maingenre=?, agemin=? consoleid=? description=? WHERE customer=? AND id=?";
//			
//			PreparedStatement ps = cnx.prepareStatement(sql);
//			ps.setString(1, name);
//			ps.setInt(2, quantity);
//			ps.setDouble(3, price);
//			ps.setString(4, maingenre);
//			ps.setInt(5, agemin);
//			ps.setInt(6, console.getId());
//			ps.setString(7, description);
//			ps.setInt(8, product.getId());
//			int res = ps.executeUpdate();
//			if (res == 1) {
//				return ProductsDao.find(product.getId());
//			}
//			ps.close();
//			
//			
//			ConnectionBDD.getInstance().closeCnx();	
//		}catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	public static void add(String name, String genre, String publisher, int agemin, String console, String date,
			float price, int quantity, String description)
	{
		Connection cnx=null;
		try
		{
			
			 int idpub = getIdPublisher(name);
			 System.out.println("------------------------ idpub:" + idpub + "---------------------------");
			 if(idpub == -1)
			 {
				 idpub = PublisherDao.getId(publisher);
			 }
			 
			 String maingenre_exis = getMaingenre(name);
			 if(maingenre_exis != "null")
			 {
				 genre = maingenre_exis;
			 }
			
			int idconsole = ConsoleTypeDao.getId(console);
			
			if(idpub == -1 || idconsole == -1)
				return;
			
			cnx = ConnectionBDD.getInstance().getCnx();
			
			
			System.out.println("*********ID FOUND************ " + idpub + "  "  + idconsole);
			
			
			String sql = "INSERT INTO PRODUCTS (name, maingenre, publisherid, agemin, consoleid, releasedate, price, quantity, description)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, genre);
			ps.setInt   (3, idpub);
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
	
	
	public static void editName(int id, String name)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET name=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public static void editQuantity(int id, int quantity)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET quantity=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void editPrice(int id, float price)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET price=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setFloat(1, price);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	private static String getName(int id)
	{
		String name ="";
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "SELECT name FROM PRODUCTS WHERE id= ?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				name = res.getString("name");
			}
			
			ps.close();			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return name;		
	}
	
	
	//all main genre of that game should be updates --> MAKES MORE SENSE, DOESN'T IT??!
	public static void editMaingenre(int id, String maingenre)
	{
		Connection cnx=null;
		try
		{
			String name = getName(id);
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET maingenre=? WHERE name=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, maingenre);
			ps.setString(2, name);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return;
	}
		
	
	//all ages for all the consoles of that game should be updated!!!
	public static void editAgemin(int id, int age)
	{
		Connection cnx=null;
		try
		{
			String name = getName(id);
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET agemin=? WHERE name=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, age);
			ps.setString(2, name);
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	

	//all main genre of that game should be updates --> MAKES MORE SENSE, DOESN'T IT??!
		
	public static void editPublisher(int id, String publisher)
	{
		int idpub = PublisherDao.getId(publisher);
		if(idpub == -1)
			return;
		Connection cnx=null;
		try
		{
				String name = getName(id);
				cnx = ConnectionBDD.getInstance().getCnx();
				
				String sql = "UPDATE PRODUCTS SET publisherid=? WHERE name=?";
				
				PreparedStatement ps = cnx.prepareStatement(sql);
				ps.setInt(1, idpub);
				ps.setString(2, name);
				ps.executeUpdate();
				ps.close();
				
				ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
			
	return;
		
	}
	
	
	public static void editConsole(int id, String console)
	{
		int idconsole = PublisherDao.getId(console);
		if(idconsole == -1)
			return;
		Connection cnx=null;
		try
		{
			
			cnx = ConnectionBDD.getInstance().getCnx();
			
			String sql = "UPDATE PRODUCTS SET consoleid=? WHERE id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idconsole);
			ps.setInt(2, id);
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

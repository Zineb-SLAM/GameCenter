package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public final class ConnectionBDD {

	private static volatile ConnectionBDD instance;
	private Connection cnx; 
	
	private ConnectionBDD() 
	{
		try 
		{
			
//			Properties p = new Properties();
//			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//			InputStream input = classLoader.getResourceAsStream("conf.properties");
//			p.load(input);
//			System.out.print("---------------------------------------------------------------------");
//			System.out.print(p.getProperty("database") + p.getProperty("dbUser") + p.getProperty("password"));
//			System.out.print("---------------------------------------------------------------------");

			Class.forName("com.mysql.jdbc.Driver");  
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/SR03", "root", "123456789");

		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.print("ERROR: Configuration properties not found...");
//			e.printStackTrace();
		}
	} 
	
	public static synchronized ConnectionBDD getInstance() {
		if(instance==null)
			instance = new ConnectionBDD();
		
		return instance;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}

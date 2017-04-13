package dao;
import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnectionBDD {

	private static volatile ConnectionBDD instance;
	private Connection cnx; 
	
	private ConnectionBDD() 
	{
		try 
		{
			
			/*Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader().
						getResourceAsStream("confBDD.properties"));*/

			Class.forName("com.mysql.jdbc.Driver");
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("foo.properties");
			// ...
			Properties properties = new Properties();
			properties.load(input);
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/SR03","root", properties.getProperty("password")); 			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
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

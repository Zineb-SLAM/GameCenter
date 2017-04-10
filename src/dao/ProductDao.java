package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import beans.Customer;

public class ProductDao {

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
			String sql = "SELECT id,description,prix FROM Products";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			//Product(int id, String name, String description, double price, int qtty, String type) 
			while(res.next()){
				lu.add(new Product(res.getInt("id"), res.getString("name"),
						res.getString("description"), res.getDouble("price"),
						res.getInt("quantity"), res.getString("type")));			 
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return lu;
	}
	
	public static Product find(int id) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		Product lu = null;
		
		Connection cnx=null;
		try {
			cnx = ConnectionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,description,prix FROM Products WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu = new Product(res.getInt("id"), res.getString("name"),
						res.getString("description"), res.getDouble("price"),
						res.getInt("quantity"), res.getString("type"));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}

		
}

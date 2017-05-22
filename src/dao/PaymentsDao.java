package dao;
import beans.Payment;
import beans.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PaymentsDao
{
	public static List<Payment> findCustPayments(Customer cust, int idpay) throws Exception
	{
		List<Payment> lu = new ArrayList<Payment>();
		Connection cnx = null;

		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			PreparedStatement ps;
			String sql="";
			
			if(idpay == -1)
			{
				sql = "SELECT * FROM PAYMENTS WHERE status = 1 AND customer = ?";
				
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, cust.getId());
			}
			else
			{
				sql = "SELECT * FROM PAYMENTS WHERE status = 1 AND customer = ? AND id = ?";
				
				ps = cnx.prepareStatement(sql);
				ps.setInt(1, cust.getId());
				ps.setInt(2, idpay);
			}
			
			ResultSet res = ps.executeQuery();
			/*Payment(int id, String t, String pan, String cvv, int idcust, String fname,
			String lname, String gender, String email, String username, String pwd)*/
			while(res.next())
			{
				lu.add(new Payment(res.getInt("id"), res.getString("type"), res.getString("pan"), 
						res.getString("cvv"),
						res.getInt("month"), res.getInt("year"), cust));
			}
			
			res.close();
			ConnectionBDD.getInstance().closeCnx();			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return lu;
	}

	
	public static void add(String type, String pan, String cvv, int month, int year, Customer cust) throws Exception
	{
		
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "INSERT INTO PAYMENTS(type,pan,cvv,month,year,customer,status)"
					+ " VALUES(?, ?, ?, ?, ?, ?,  1)";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, type );
			ps.setString(2, pan);
			ps.setString(3, cvv);
			ps.setInt(4, month);
			ps.setInt(5, year);
			ps.setInt(6, cust.getId());
			
			ps.executeUpdate();
			ps.close();
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return;
	}
	
 	public static void delete (Customer cust, int idpay)
	{
	
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE PAYMENTS SET status=0 WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, cust.getId() );
			ps.setInt(2, idpay);
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return;
	}
	
	
	public static void editPan(Customer cust, int idpay, String pan)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE PAYMENTS SET pan=? WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, pan);
			ps.setInt(2, cust.getId());
			ps.setInt(3, idpay);
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void editCvv(Customer cust, int idpay, String cvv)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE PAYMENTS SET cvv=? WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, cvv);
			ps.setInt(2, cust.getId());
			ps.setInt(3, idpay);
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return;
	}
	
	public static void editExpiration(Customer cust, int idpay, int month, int year)
	{
		Connection cnx=null;
		try
		{
			cnx = ConnectionBDD.getInstance().getCnx();
			String sql = "UPDATE PAYMENTS SET month=?  AND year=? WHERE customer=? AND id=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, cust.getId());
			ps.setInt(4, idpay);
			ps.executeUpdate();
			ps.close();
			
			
			ConnectionBDD.getInstance().closeCnx();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return;
	}
	
}
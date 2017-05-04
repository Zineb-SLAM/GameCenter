package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Payment implements Serializable, Comparable<Payment>
{
	//public enum CardType {visa, Mastercard, american_express, discover}

	int id;
	String type;
	String pan;
	String cvv;
	String expiration;
	Customer customer;
	boolean status;
	

	public Payment(int id, String t, String nb, String c, String expiration)
	{
		this.id = id;
		this.type = t;
		this.pan = nb;
		this.cvv = c;
		this.expiration = expiration;
		customer = new Customer();
	}
	
	public Payment(int id, String t, String pan, String cvv, String expiration, int idcust, String fname, String lname, String gender, String email, String username, String pwd)
	{
		this.id = id;
		this.type = t;
		this.pan = pan;
		this.cvv = cvv;
		this.expiration = expiration;
		customer = new Customer(idcust, fname, lname, gender, email, username, pwd);
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getPan()
	{
		return pan;
	}
	
	public String getCvv()
	{
		return cvv;
	}
	
	public void disableCard()
	{
		status = false;
	}
	
	@Override
	public int compareTo(Payment o) {
		return (this.cvv.compareTo(o.cvv));
	}
	
	
}
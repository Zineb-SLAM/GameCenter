package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Payment implements Serializable, Comparable<Payment>
{
	public enum CardType {visa, Mastercard, american_express, discover}

	int id;
	CardType type;
	String number;
	String code;
	Customer customer;
	boolean status;
	

	Payment(int id, CardType t, String nb, String c)
	{
		this.id = id;
		this.type = t;
		this.number = nb;
		this.code = c;
		customer = new Customer();
	}
	
	Payment(int id, CardType t, String nb, String c, int idcust, String fname, String lname, String gender, String email, String username, String pwd)
	{
		this.id = id;
		this.type = t;
		this.number = nb;
		this.code = c;
		customer = new Customer(idcust, fname, lname, gender, email, username, pwd);
	}
	
	
	int getId()
	{
		return id;
	}
	
	CardType getType()
	{
		return type;
	}
	String getNumber()
	{
		return number;
	}
	
	String getCode()
	{
		return code;
	}
	
	void disableCard()
	{
		status = false;
	}
	
	@Override
	public int compareTo(Payment o) {
		return (this.number.compareTo(o.number));
	}
	
	
}
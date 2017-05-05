package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable, Comparable<Address>
{	
	int id;
	String address;
	String zipcode;
	String city;
	String country;
	String type;
	Customer customer;
	boolean status;
	
	public Address(int id, String address, String zip, String city, String country,
			String type, boolean status, int idc, String fname, String lname, 
			String gender, String email, String username, String pwd, boolean stat)
	{
		this.id = id;
		this.address = address;
		this.zipcode = zip;
		this.city = city;
		this.country = country;
		this.type = type;
		customer  =  new Customer(idc, fname, lname, gender, email, username, pwd, stat);	
		this.status = status;
	}
	
	public Address(int id, String address, String zip, String city, String country,
			String type, boolean status, Customer cust)
	{
		this.id = id;
		this.address = address;
		this.zipcode = zip;
		this.city = city;
		this.country = country;
		this.type = type;
		this.customer = new Customer(cust);
		
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getZipcode()
	{
		return zipcode;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getType()
	{
		return type;
	}
	public Customer getCustomer()
	{
		return customer;
	}
	public void disableAddress()
	{
		this.status = false;
	}
	
	@Override
	public int compareTo(Address o) {
		return (this.address.compareTo(o.address));
	}
};

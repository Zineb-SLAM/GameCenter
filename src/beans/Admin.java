package beans;


public class Admin
{
	int id;
	Customer customer;
	
	public Admin (int id, Customer cust)
	{
		this.id = id;
		this.customer = cust;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
};
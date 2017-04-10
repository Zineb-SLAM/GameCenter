package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable, Comparable<Product>
{

	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	//private ConsoleType type;
	/**
	 * @param id
	 * @param description
	 * @param price
	 */
	public Product(int id, String name, String description, double price, int qtty, String stype)
	{
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.name = name;
		this.quantity = qtty;
		//this.type = ConsoleType(stype);
	}
	/**
	 * 
	 */
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int qtty)
	{
		this.quantity = qtty; 
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		return result;
	}
	/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	*/
	@Override
	public boolean equals(Object obj) {
		if(obj==null||(!(obj instanceof Product)))
			return false;
		Product tmp = (Product)obj;
		return((this.id==tmp.id) && this.description.equals(tmp.getDescription()));
	}
	@Override
	public int compareTo(Product o) {
		if(this.price==o.price)
			return 0;
		else if(this.price>o.price)
			return 1;
		else 
			return -1;
	}
	
	
	
	
}

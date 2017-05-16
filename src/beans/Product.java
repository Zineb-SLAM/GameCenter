package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable, Comparable<Product>
{
	private int id;
	private String name;
	private String maingenre;
	private Publisher publisher;
	private int agemin;
	private ConsoleType console;
	private String releasedate;
	private float price;
	private int quantity;
	private String description;
		
	/**
	 * @param id
	 * @param description
	 * @param price
	 */
	public Product(int id, String name, String genre, String publ, int agemin, String console,
			String date, float price, int qtty, String desc)
	{
		super();
		this.id = id;
		this.name = name;
		this.maingenre = genre;
		this.publisher = new Publisher(0, publ);
		this.agemin = agemin;
		this.console = new ConsoleType(0, console);
		this.releasedate = date;
		this.price = price;
		this.quantity = qtty;
		this.description = desc;
	}
	
	public Product(int id, String name, String genre, Publisher publ, int agemin, ConsoleType console,
			String date, float price, int qtty, String desc)
	{
		super();
		this.id = id;
		this.name = name;
		this.maingenre = genre;
		this.publisher = publ;
		this.agemin = agemin;
		this.console = console;
		this.releasedate = date;
		this.price = price;
		this.quantity = qtty;
		this.description = desc;
	}
	
	public Product(int id, String name, float price){
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getMaingenre()
	{
		return this.maingenre;
	}
	
	public void setMaingenre(String genre)
	{
		this.maingenre = genre;
	}
	public int getAgemin()
	{
		return this.agemin;
	}
	
	public void setAgemin(int agemin)
	{
		this.agemin = agemin;
	}
	
	public String getConsole()
	{
		if(this.console != null)
			return this.console.getName();
		else 
			return null;
	}
	
	public void setConsole(String console)
	{
		if(this.console != null)
			this.console.setName(console);
		
	}
	
	public String getPublisher()
	{
		if(this.publisher != null)
			return this.publisher.getName();
		else
			return null;
	}
	
	public void setPublisher(String publisher)
	{
		if(this.publisher != null)
			this.publisher.setName(publisher);
	}
	
	
	public String getReleasedate()
	{
		return this.releasedate;
	}
	
	public void setReleasedate(String date)
	{
		 this.releasedate = date;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return Math.floor(price * 100) / 100;
	}
	public void setPrice(float price) {
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

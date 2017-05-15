package beans;


public class Admin
{
	int id;
	String lastname;
	String firstname;
	String username;
	String email;
	String password;
	
	public Admin (int id, String f, String l, String u, String e, String p)
	{
		this.id = id;
		this.firstname = f;
		this.lastname = l;
		this.username = u;
		this.email = e;
		this.password = p;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPwd() {
		return password;
	}
};
package beans;
import java.io.Serializable;



public class Customer implements Serializable, Comparable<Customer>
{
		private int id;
		private String firstname;
		private String lastname;
		private String gender;
		private String email;
		private String username;
		private String pwd;
		private boolean status;
		
		public Customer(){}
		
		public Customer(int id, String fname, String lname, String gender, String email, String username, String pwd) 
		{
			super();
			this.id = id;
			this.firstname = fname;
			this.lastname = lname;
			this.gender = gender;
			this.email = email;
			this.username = username;
			this.pwd = pwd;
			this.status = true; 
		}
		
		public Customer(int id, String fname, String lname, String gender,  String email, String username, String pwd, boolean stat) 
		{
			super();
			this.id = id;
			this.firstname = fname;
			this.lastname = lname;
			this.gender = gender;
			this.email = email;
			this.username = username;
			this.pwd = pwd;
			this.status = stat; 
		}
		
		public Customer(Customer cust)
		{
			this.id        = cust.getId();
			this.username  = cust.getUsername();
			this.firstname = cust.getFirstname();
			this.lastname  = cust.getLastname();
			this.gender    = cust.getGender();
			this.email     = cust.getGender();
			this.pwd       = cust.getPwd();
			this.status    = cust.getStatus();
		}
		
		public int getId() {
			return id;
		}
		
		public String getFirstname() {
			return firstname;
		}
		public String getLastname() {
			return lastname;
		}
		
		public String getGender(){
			return gender;
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getUsername()
		{
			return username;
		}
		
		public String getPwd() {
			return pwd;
		}
		
		public boolean getStatus()
		{
			return status;
		}
		
		public void setFirstname(String name) {
			this.firstname = name;
		}
		
		public void setLastname(String name) {
			this.lastname = name;
		}
		
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		
		public void setUsername(String username)
		{
			this.username = username;
		}
		
		
		
		public void setPwd(String pwd) throws Exception {
			if(pwd.length()<4)
				throw new Exception("Erreur : longeur de mot de passe <4");
			else
				this.pwd = pwd;
		}
		
	

		@Override
		public int compareTo(Customer o) {
			return this.lastname.compareTo(o.lastname);
		}
				
		
};

package beans;
import java.io.Serializable;

public class Customer implements Serializable, Comparable<Customer>
{

		private int id;
		private String firstname;
		private String lastname;
		private char gender;
		private String email;
		private String username;
		private String pwd;
		
		
		
		public Customer() {
	
		}
		
		public Customer(int id, String fname, String lname, String email, String username, String pwd) {
			super();
			this.firstname = fname;
			this.lastname = lname;
			this.email = email;
			this.username = username;
			this.pwd = pwd;
			this.id = id;
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
		
		public char getGender(){
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
		
		
		
		
}

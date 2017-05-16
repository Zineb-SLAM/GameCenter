package controllers;

//import org.json.simple.JSONObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import beans.Customer;
import dao.CustomersDao;
import services.AES;

@Path("/auth")
public class AuthenticationController {

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer register(@FormParam("gender") String gender, @FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("email") String email, 
			@FormParam("username") String username,
			@FormParam("pwd") String pwd) {
		try {
				return CustomersDao.create(gender, first_name, last_name, email, username, pwd);
		}
		catch (Exception e) {
			return new Customer();	
		}
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/login") // To be tested
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject login(@FormParam("username") String username, @FormParam("email") String email, @FormParam("pwd") String pwd, @FormParam("to_decrypt") String to_decrypt){
		try {
			Customer customer = CustomersDao.findUsername(username);
			long timestamp;
			if (customer.getPwd() == pwd){
				timestamp = System.currentTimeMillis()/1000;
				String authenticationToken = username + "-" +timestamp + "-" + (timestamp + 1000);
				String encryptedAuthToken = AES.encrypt(authenticationToken);
				JSONObject json = new JSONObject();
			    json.put("user", customer);
			    json.put("authentication_token", encryptedAuthToken);
				return json;
			}
			else
				return new JSONObject();
		} catch (Exception e) {
			return new JSONObject(); // TODO: Set a real error handler
		}
		
	}
}

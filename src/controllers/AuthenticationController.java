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
	public JSONObject register(@FormParam("gender") String gender, @FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("email") String email, 
			@FormParam("username") String username,
			@FormParam("pwd") String pwd) {
		try {
				Customer customer = CustomersDao.create(gender, first_name, last_name, email, username, pwd);
				return makeToken(customer);
		}
		catch (Exception e) {
			return new JSONObject();	
		}
	}
	
	
	@POST
	@Path("/login") // To be tested
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject login(@FormParam("username") String username, @FormParam("email") String email, @FormParam("pwd") String pwd, @FormParam("to_decrypt") String to_decrypt){
		try {
			Customer customer = CustomersDao.findUsername(username);
			if (customer.getPwd() == pwd){

				return makeToken(customer);
			}
			else
				return new JSONObject();
		} catch (Exception e) {
			return new JSONObject(); // TODO: Set a real error handler
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject makeToken(Customer customer){
		String encryptedAuthToken = AES.makeToken(customer.getUsername(), false);
		JSONObject json = new JSONObject();
	    json.put("user", customer);
	    json.put("authentication_token", encryptedAuthToken);
	    return json;
	}
}

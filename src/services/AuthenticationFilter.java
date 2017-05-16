package services;
import javax.inject.Named;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import org.json.simple.JSONObject;

@Named
@Provider
@PreMatching
public class AuthenticationFilter  implements ContainerRequestFilter {
	
	@Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		JSONObject json = new JSONObject();
		try {
	    
			System.out.print("-------------------------Within Filter-----------------------------");
			
		    String decryptedToken = AES.decrypt(authorizationHeader);
		    String[] token_parts = decryptedToken.split("-");
		    if (authorizationHeader == null)
				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
		    else
			    if (token_parts.length < 3 || (Integer.parseInt(token_parts[2]) < (System.currentTimeMillis()/1000))){
				    json.put("error", "You are not authorized with this service");
				    json.put("error_description", "You are not authorized to this service");
				    requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
			    }
		    // Else, everything seems fine ^^
		} catch (Exception e){
			try {
				throw new Exception("BOOM!!!!!!!!!!!!!!!!!: "+ authorizationHeader);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println("--------------------------Decode: " + decryptedToken +"------------------");
		}
	    
    }
}
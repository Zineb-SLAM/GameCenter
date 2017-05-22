package services;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import org.json.simple.JSONObject;

@Provider

public class AuthenticationFilter  implements ContainerRequestFilter {
	
	@SuppressWarnings("unchecked")
	@Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
		try {
			if(requestContext.getUriInfo().getMatchedResources().get(0).getClass() == Class.forName("controllers.AuthenticationController"))
				return;
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		JSONObject json = new JSONObject();
		try {
			
			System.out.print("-------------------------Within Request Filter-----------------------------");
			
		    String decryptedToken = AES.decrypt(authorizationHeader);
		    String[] token_parts = decryptedToken.split("-");
		    if (authorizationHeader == null)
				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
		    else
			    if (token_parts.length < 3 || (Integer.parseInt(token_parts[2]) < (System.currentTimeMillis()/1800))){
				    json.put("error", "You are not authorized with this service");
				    json.put("error_description", "You are not authorized to this service");
				    requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
			    }
		    // Else, everything seems fine ^^
		} catch (Exception e){
			json.put("error", "You are not authorized with this service");
		    json.put("error_description", "You are not authorized to this service");
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
			try {
				throw new Exception("BOOM!!!!!!!!!!!!!!!!!: "+ requestContext.getUriInfo().getMatchedResources().get(0).getClass());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Error: " + e1.toString());
			}
			//System.out.println("--------------------------Decode: " + decryptedToken +"------------------");
		}
	    
    }
}
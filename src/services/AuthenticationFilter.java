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
//		JSONObject json = new JSONObject();
//	    json.put("error", "You are not authorized with this service");
//	    json.put("error_description", "");
//	    
//		System.out.print("-------------------------Within Filter-----------------------------");
//		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//			if (authorizationHeader == null)
//				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//			else
//				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
    }
}
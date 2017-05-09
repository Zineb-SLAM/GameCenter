package services;
import javax.inject.Named;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Named
@Provider
@PreMatching
public class AuthenticationFilter  implements ContainerRequestFilter {
	
	@Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.print("-------------------------Within Filter-----------------------------");
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (authorizationHeader == null)
				e.printStackTrace();
			else
				e.getCause();
		}
    }
}
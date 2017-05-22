//package services;
//import org.json.simple.JSONObject;
//
//import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.core.MediaType;
//import java.io.IOException;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.ext.Provider;
///*
// * Created by xzirva on 21/05/17.
// */
//
//import static java.lang.Thread.sleep;
//
//@Provider
//public class AuthenticationResponseFilter implements ContainerResponseFilter {
//
//    @Inject
//    HttpServletRequest request;
//
//    @Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//        
//        try {
//			if(requestContext.getUriInfo().getMatchedResources().get(0).getClass() == Class.forName("controllers.AuthenticationController"))
//				return;
//	        if (responseContext.getStatusInfo() == Status.UNAUTHORIZED){
//	        	return;
//	        }
//		} catch (ClassNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//        
//		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//		JSONObject json = new JSONObject();
//		try {
//			
//			
//			System.out.print("-------------------------Within Response Filter-----------------------------");
//			
//		    String decryptedToken = AES.decrypt(authorizationHeader);
//		    String[] token_parts = decryptedToken.split("-");
//		    /** Parts:
//		     * 0: username
//		     * 1: token creation timestamp
//		     * 2: token validation timestamp
//		     * 3(optional): admin
//		     */
//		    boolean admin = false;
//		    if (token_parts.length > 3 && token_parts[3] == "admin")
//		    	admin = true;
//		    String new_auth_token = AES.makeToken(token_parts[0], admin);
//		    
//		    responseContext.getHeaders().add("authenticiation_token", new_auth_token);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//        
//    }
//}

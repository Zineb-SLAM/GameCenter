//package services;
//import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;
//
//import java.io.IOException;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.ext.Provider;
//import org.json.simple.JSONObject;
//
//import beans.Admin;
//import beans.Customer;
//import dao.AdminsDao;
//import dao.CustomersDao;
//import static java.lang.Thread.sleep;
//
//@Provider
//public class AuthenticationFilter  implements ContainerRequestFilter {
//	
//	@SuppressWarnings("unchecked")
//	@Override
//    public void filter(ContainerRequestContext requestContext) throws IOException {
//		try {
//			if(requestContext.getUriInfo().getMatchedResources().get(0).getClass() == Class.forName("controllers.AuthenticationController"))
//				return;
//			if(requestContext.getUriInfo().getMatchedResources().get(0).getClass() == Class.forName("controllers.ProductsController"))
//				return;
//		} catch (ClassNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//			
//		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//		JSONObject json = new JSONObject();
//	    json.put("error", "You are not authorized with this service");
//	    json.put("error_description", "You are not authorized to this service");
//		try {
//			
//			System.out.print("-------------------------Within Request Filter-----------------------------");
//			
//		    String decryptedToken = AES.decrypt(authorizationHeader);
//		    String[] token_parts = decryptedToken.split("-");
//		    if (authorizationHeader == null)
//				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//		    else
//			    if (token_parts.length < 3 || (Integer.parseInt(token_parts[2]) < (System.currentTimeMillis()/1800))){
//				    requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//			    }
//		    
//		    	if (token_parts.length == 3){
//		    			if(requestContext.getUriInfo().getMatchedResources().get(0).getClass() == Class.forName("controllers.AdminsController")){
//		    				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//		    			}
//		    			MultivaluedMap<String, String> path_params = requestContext.getUriInfo().getPathParameters();
//	    				System.out.println(path_params.getFirst("id"));
//		    			if((requestContext.getUriInfo().getMatchedResources().get(0).getClass() == Class.forName("controllers.CustomersController") && path_params.getFirst("id") != null) ||
//		    				(path_params.getFirst("customer_id") != null)){
//		    				int id;
//		    				if (path_params.getFirst("customer_id") == null)
//		    				{
//		    					id = Integer.parseInt(path_params.getFirst("id"));
//		    				} else {
//		    					id = Integer.parseInt(path_params.getFirst("customer_id"));
//		    				}
//		    				Customer customer = CustomersDao.findId(id);
//		    				System.out.print(customer.getUsername() + "/" + token_parts[0]);
//		    				if (!customer.getUsername().equals(token_parts[0]))
//		    					requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//		    			}
//		    	}
//		    	
//		    	if (token_parts.length == 4) {
//		    		Admin admin = AdminsDao.findUsername(token_parts[0]);
//		    		if (admin == null)
//		    			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//		    	}
//		    	
//		    // Else, everything seems fine ^^
//		} catch (Exception e){
//			json.put("error", "You are not authorized with this service");
//		    json.put("error_description", "You are not authorized to this service");
//			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
//			try {
//				throw new Exception("BOOM!!!!!!!!!!!!!!!!!: "+ requestContext.getUriInfo().getMatchedResources().get(0).getClass());
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				System.out.println("Error: " + e1.toString());
//			}
//			//System.out.println("--------------------------Decode: " + decryptedToken +"------------------");
//		}
//	    
//    }
//}

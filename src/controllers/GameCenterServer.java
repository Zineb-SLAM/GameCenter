package controllers;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//import services.AuthenticationFilter;
//import services.AuthenticationResponseFilter;

@ApplicationPath("web-services")
public class GameCenterServer extends Application {
	private Set<Object> singletons = new HashSet<>();

    public GameCenterServer() {
//        singletons.add(new AuthenticationFilter());
        singletons.add(new CustomersController());
        singletons.add(new AdminsController());
        singletons.add(new OrderLinesController());
        singletons.add(new OrdersController());
        singletons.add(new AddressesController());
        singletons.add(new AuthenticationController());
        singletons.add(new GamesController());
        singletons.add(new PaymentsController());
        singletons.add(new ProductsController());
//        singletons.add(new AuthenticationResponseFilter());
    }

    @Override
    public Set<Object> getSingletons() 
    {
        return singletons;
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();
        return resources;
    }
}

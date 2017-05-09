package controllers;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import services.AuthenticationFilter;

@ApplicationPath("web-services")
public class GameCenterServer extends Application {
	private Set<Object> singletons = new HashSet<>();

    public GameCenterServer() {
        singletons.add(new AuthenticationFilter());
        singletons.add(new CustomersController());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(AuthenticationFilter.class);

        return resources;
    }
}

package tracker.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RESTConfig extends ResourceConfig{
	
	public RESTConfig(){
		packages("tracker.restapi");
	}
	
}

package tracker.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tracker.dao.HeroDAO;
import tracker.model.hero.Hero;

@Path("/heroes")
public class HeroController {

	@GET
	@Path("/setHeroes")
	public void setHeroes(){
		HeroDAO.setHero_list();
	}	
	
	@GET
	@Path("/getHeroes")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Hero> getHeroes(){
		return HeroDAO.getHero_list();	
	}
}
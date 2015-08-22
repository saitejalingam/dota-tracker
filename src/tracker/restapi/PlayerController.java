package tracker.restapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tracker.dao.MatchDetailsDAO;
import tracker.dao.PlayerDAO;
import tracker.model.Player;
import tracker.model.SentDetails;

@Path("/player")
public class PlayerController {
	
	@GET
	@Path("/{playerID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SentDetails> getDetails(@PathParam("playerID") String playerID){
		
		MatchDetailsDAO mdDao = new MatchDetailsDAO();	
		return mdDao.getMatchDetails(playerID);	
	}
	
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPlayer(Player p){
		return PlayerDAO.addPlayer(p);
	}
	
	@DELETE
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public String removePlayer(Player p){
		return PlayerDAO.removePlayer(p);
	}
	
	@GET
	@Path("/getPlayers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getPlayers(){
		return PlayerDAO.getPlayers();
	}
}

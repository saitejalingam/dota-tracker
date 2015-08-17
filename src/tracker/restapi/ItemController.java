package tracker.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tracker.dao.ItemDAO;
import tracker.model.item.Item;

@Path("/items")
public class ItemController {

	@GET
	@Path("/setItems")
	public void setItems(){	
		ItemDAO.setItem_list();
	}
	
	@GET
	@Path("/getItems")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Item> getItems(){
		return ItemDAO.getItem_list();
	}
}

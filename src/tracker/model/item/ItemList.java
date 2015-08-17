package tracker.model.item;

import java.util.ArrayList;

public class ItemList {
	
	private int status;
	private ArrayList<Item> items;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}

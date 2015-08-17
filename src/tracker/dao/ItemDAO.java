package tracker.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import tracker.model.item.Item;
import tracker.model.item.ItemResult;
import tracker.util.DBConnect;


public class ItemDAO {
	
	public static ArrayList<Item> getItem_list() {
		ArrayList<Item> item_list = new ArrayList<Item>();
		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM items_db");
			rs = ps.executeQuery();

			while(rs.next()){
				
				Item item = new Item();
				item.setId(rs.getInt("items_id"));
				item.setName(ItemDAO.formatName(rs.getString("items_name")));
				item.setLocalized_name(rs.getString("items_localized_name"));
				
				item_list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(ps, rs, con);
		}

		return item_list;
	}

	public static void setItem_list() {
		
		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			URL url = new URL("https://api.steampowered.com/IEconDOTA2_570/GetGameItems/V001/?key=739EEE918CCB268E99F85B1A4BF6FF04&language=en");
			URLConnection connect = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			
			rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));

			ObjectMapper mapper = new ObjectMapper();
			ItemResult obj = mapper.readValue(rd, ItemResult.class);
			
			List<Item> items = new ArrayList<Item>();
			items = obj.getResult().getItems();
			
			for(int i=0; i< items.size(); i++){
				
				ps = con.prepareStatement("INSERT INTO items_db (items_id, items_name, items_localized_name) VALUES (?, ? ,?)");
				ps.setInt(1, items.get(i).getId());	
				ps.setString(2, items.get(i).getName());
				ps.setString(3, items.get(i).getLocalized_name());
				ps.executeUpdate();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(ps, rs, con);
		}

	}

	public static String formatName(String name){
		String str ="", arr_split[];
		List<String> arr = new ArrayList<String>();
		
		arr_split = name.split("_");
		for(int j=1; j<arr_split.length; j++)
			arr.add(arr_split[j]);
		str = StringUtils.join(arr, "_");
		return str;
	}
}
	
	
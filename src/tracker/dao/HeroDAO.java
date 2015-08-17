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

import tracker.model.hero.Hero;
import tracker.model.hero.HeroResult;
import tracker.util.DBConnect;


public class HeroDAO {

	public static ArrayList<Hero> getHero_list() {

		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Hero> hero_list = new ArrayList<Hero>();

		try {
			ps = con.prepareStatement("SELECT * FROM heroes_db");
			rs = ps.executeQuery();

			while(rs.next()){
				
				Hero hero = new Hero();
				hero.setId(rs.getInt("heroes_id"));
				hero.setName(HeroDAO.getHeroName(rs.getString("heroes_name")));
				hero.setLocalized_name(rs.getString("heroes_localized_name"));
				
				hero_list.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(ps, rs, con);
		}

		return hero_list;
	}
	
	public static void setHero_list(){
		
		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			URL url = new URL("https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?key=739EEE918CCB268E99F85B1A4BF6FF04&language=en_us");
			URLConnection connect = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			
			rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
    
			ObjectMapper mapper = new ObjectMapper();
			HeroResult obj = mapper.readValue(rd, HeroResult.class);
			
			List<Hero> hero = new ArrayList<Hero>();
			hero = obj.getResult().getHeroes();
			
			for(int i=0; i< hero.size(); i++){
				
				ps = con.prepareStatement("INSERT INTO heroes_db (heroes_id, heroes_name, heroes_localized_name) VALUES (?, ? ,?)");
				ps.setInt(1, hero.get(i).getId());	
				ps.setString(2, hero.get(i).getName());
				ps.setString(3, hero.get(i).getLocalized_name());
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

	public static String getHeroName(String name){
		String str ="", arr_split[];
		List<String> arr = new ArrayList<String>();
		
		arr_split = name.split("_");
		for(int j=3; j<arr_split.length; j++)
			arr.add(arr_split[j]);

		str = StringUtils.join(arr, "_");
		return str;
	}
	
}

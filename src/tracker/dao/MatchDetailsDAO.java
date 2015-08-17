package tracker.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import tracker.model.SentDetails;
import tracker.model.details.PlayerDetails;
import tracker.model.details.ResultDetails;
import tracker.model.history.ResultHistory;

public class MatchDetailsDAO {
	
	public List<SentDetails> getMatchDetails(String playerID){
		
		try {
			URL url = new URL("https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v0001/?key=739EEE918CCB268E99F85B1A4BF6FF04&account_id="+playerID+"&matches_requested=25");
			URLConnection connect = url.openConnection();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));

			ObjectMapper mapper = new ObjectMapper();
			ResultHistory obj = mapper.readValue(rd, ResultHistory.class);
			
			List<String> matchIDs = new ArrayList<String>();
			for(int i=0; i< obj.getResult().getMatches().size(); i++){
				matchIDs.add(obj.getResult().getMatches().get(i).getMatch_id()+"");
			}
			
			
			List<SentDetails> returnList = new ArrayList<SentDetails>();
			
			for(int j=0; j< matchIDs.size(); j++){
				url = new URL("http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1/?key=739EEE918CCB268E99F85B1A4BF6FF04&match_id="+matchIDs.get(j));
				connect = url.openConnection();
				
				rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line = null;
	            while ((line = rd.readLine()) != null) {
	                sb.append(line);
	            }
	            line = sb.toString();
	            
	            mapper = new ObjectMapper();
				ResultDetails obj1 = mapper.readValue(line, ResultDetails.class);
				List<PlayerDetails> p_list = new ArrayList<PlayerDetails>();
				PlayerDetails player = new PlayerDetails();
				p_list = obj1.getResult().getPlayers();
				
				int k = 0;
				while(p_list.get(k).getAccount_id() != Long.valueOf(playerID))
					k++;
				
				player = p_list.get(k);
				SentDetails match = new SentDetails();
				match.setPlayer_slot(player.getPlayer_slot());
				match.setHero_id(player.getHero_id());
				match.setItems(new int[] {player.getItem_0(), player.getItem_1(), player.getItem_2(), player.getItem_3(), player.getItem_4(), player.getItem_5()});
				match.setKills(player.getKills());
				match.setDeaths(player.getDeaths());
				match.setAssists(player.getAssists());
				match.setLast_hits(player.getLast_hits());
				match.setDenies(player.getDenies());
				match.setGpm(player.getGold_per_min());
				match.setXpm(player.getXp_per_min());
				match.setRadiant_win(obj1.getResult().isRadiant_win());
				match.setDuration(obj1.getResult().getDuration());
				match.setStart_time(obj1.getResult().getStart_time());
	            
				returnList.add(match);
			}
			
            return returnList;  
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}

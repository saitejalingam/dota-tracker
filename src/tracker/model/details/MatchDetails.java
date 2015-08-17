package tracker.model.details;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"barracks_status_dire", "barracks_status_radiant", "cluster", "dire_captain", "engine", "first_blood_time", "game_mode", "human_players", "leagueid", "lobby_type", "match_seq_num", "negative_votes", "picks_bans", "positive_votes", "radiant_captain", "tower_status_dire", "tower_status_radiant"})
public class MatchDetails {
	
	private int duration;
	private long match_id;
	private ArrayList<PlayerDetails> players;
	private boolean radiant_win;
	private long start_time;
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public long getMatch_id() {
		return match_id;
	}
	public void setMatch_id(long match_id) {
		this.match_id = match_id;
	}
	public ArrayList<PlayerDetails> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<PlayerDetails> players) {
		this.players = players;
	}
	public boolean isRadiant_win() {
		return radiant_win;
	}
	public void setRadiant_win(boolean radiant_win) {
		this.radiant_win = radiant_win;
	}
	public long getStart_time() {
		return start_time;
	}
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	
	
}

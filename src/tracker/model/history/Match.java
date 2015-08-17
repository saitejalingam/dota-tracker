package tracker.model.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"match_seq_num", "start_time", "lobby_type", "radiant_team_id", "dire_team_id", "players"})
public class Match {

	private int match_id;
	
	public int getMatch_id() {
		return match_id;
	}
	
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
}

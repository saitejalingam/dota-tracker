package tracker.model.history;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"num_results", "results_remaining", "status", "total_results"})
public class MatchHistory {
	
	private ArrayList<Match> matches;
	
	public ArrayList<Match> getMatches() {
		return matches;
	}
	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}	
}

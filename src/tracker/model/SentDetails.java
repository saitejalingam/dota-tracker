package tracker.model;

public class SentDetails {

	private int player_slot;
	private int hero_id;
	private int[] items;
	private int kills;
	private int deaths;
	private int assists;
	private int last_hits;
	private int denies;
	private int gpm;
	private int xpm;
	private boolean radiant_win;
	private int duration;
	private long start_time;
	
	public int getPlayer_slot() {
		return player_slot;
	}
	
	public void setPlayer_slot(int player_slot) {
		this.player_slot = player_slot;
	}
	
	public int getHero_id() {
		return hero_id;
	}
	
	public void setHero_id(int i) {
		this.hero_id = i;
	}
	
	public int[] getItems() {
		return items;
	}
	
	public void setItems(int[] i) {
		this.items = i;
	}
	
	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	public int getAssists() {
		return assists;
	}
	
	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	public int getLast_hits() {
		return last_hits;
	}
	
	public void setLast_hits(int last_hits) {
		this.last_hits = last_hits;
	}
	
	public int getDenies() {
		return denies;
	}
	
	public void setDenies(int denies) {
		this.denies = denies;
	}
	
	public int getGpm() {
		return gpm;
	}
	
	public void setGpm(int gpm) {
		this.gpm = gpm;
	}
	
	public int getXpm() {
		return xpm;
	}
	
	public void setXpm(int xpm) {
		this.xpm = xpm;
	}
	
	public boolean getRadiant_win() {
		return radiant_win;
	}
	
	public void setRadiant_win(boolean b) {
		this.radiant_win = b;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public long getStart_time() {
		return start_time;
	}
	
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	
}

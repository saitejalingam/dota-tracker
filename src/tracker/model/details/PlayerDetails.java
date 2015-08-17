package tracker.model.details;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"additional_units", "ability_upgrades", "gold", "gold_spent", "hero_damage", "hero_healing", "leaver_status", "level", "tower_damage"})
public class PlayerDetails {
	
	private long account_id;
	private int assists;
	private int deaths;
	private int denies;
	private int gold_per_min;
	private int hero_id;
	private int item_0;
	private int item_1;
	private int item_2;
	private int item_3;
	private int item_4;
	private int item_5;
	private int kills;
	private int last_hits;
	private int player_slot;
	private int xp_per_min;
	
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getDenies() {
		return denies;
	}
	public void setDenies(int denies) {
		this.denies = denies;
	}
	public int getGold_per_min() {
		return gold_per_min;
	}
	public void setGold_per_min(int gold_per_min) {
		this.gold_per_min = gold_per_min;
	}
	public int getHero_id() {
		return hero_id;
	}
	public void setHero_id(int hero_id) {
		this.hero_id = hero_id;
	}
	public int getItem_0() {
		return item_0;
	}
	public void setItem_0(int item_0) {
		this.item_0 = item_0;
	}
	public int getItem_1() {
		return item_1;
	}
	public void setItem_1(int item_1) {
		this.item_1 = item_1;
	}
	public int getItem_2() {
		return item_2;
	}
	public void setItem_2(int item_2) {
		this.item_2 = item_2;
	}
	public int getItem_3() {
		return item_3;
	}
	public void setItem_3(int item_3) {
		this.item_3 = item_3;
	}
	public int getItem_4() {
		return item_4;
	}
	public void setItem_4(int item_4) {
		this.item_4 = item_4;
	}
	public int getItem_5() {
		return item_5;
	}
	public void setItem_5(int item_5) {
		this.item_5 = item_5;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getLast_hits() {
		return last_hits;
	}
	public void setLast_hits(int last_hits) {
		this.last_hits = last_hits;
	}
	public int getPlayer_slot() {
		return player_slot;
	}
	public void setPlayer_slot(int player_slot) {
		this.player_slot = player_slot;
	}
	public int getXp_per_min() {
		return xp_per_min;
	}
	public void setXp_per_min(int xp_per_min) {
		this.xp_per_min = xp_per_min;
	}
	
		
}

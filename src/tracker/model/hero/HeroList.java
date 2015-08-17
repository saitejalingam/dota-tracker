package tracker.model.hero;

import java.util.ArrayList;

public class HeroList {

	private int count;
	private int status;
	private ArrayList<Hero> heroes;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}
}

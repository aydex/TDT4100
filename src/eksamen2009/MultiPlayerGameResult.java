package eksamen2009;

import java.util.ArrayList;

public abstract class MultiPlayerGameResult implements GameResult {
	
	ArrayList<String> players = new ArrayList<String>();
	
	public ArrayList<String> getPlayers() {
		return players;
	}
	
	public void addPlayer(String name) {
		players.add(name);
	}
	
	public void removePlayer(String name) {
		players.remove(players.indexOf(name));
	}
}

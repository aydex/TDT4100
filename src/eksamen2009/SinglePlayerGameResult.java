package eksamen2009;

public abstract class SinglePlayerGameResult implements GameResult {
	
	String player;
	
	protected SinglePlayerGameResult(String player) {
		this.player = player;
	}
	
	public String getGameString() {
		return "played by " + player;
	}
	
	public int compareTo(GameResult o) {
		return getResultString().compareTo(o.getResultString());
	}
	
}
